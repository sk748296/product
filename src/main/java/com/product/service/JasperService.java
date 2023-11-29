package com.product.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class JasperService {

	@Autowired
	private ProductRepository productRepository;

	public String generateReport(String format) throws FileNotFoundException {
		try {
			List<Product> products = productRepository.findAll();
			String reportPath = "\\D:Content\\report";

			// Compile the file in jasper
			File file = ResourceUtils.getFile("classpath:work.jrxml");
			System.out.println("Absolute Path" + file.getAbsolutePath());

			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

			// get Data sourse
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(products);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("COMPANY_BY", "Shivam pvt ltd");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrBeanCollectionDataSource);
					

			// Export Report in pdf file
			if (format.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "kalu.pdf");

			} else if (format.equalsIgnoreCase("html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "kalu.html");
				
			}
			else if(format.equalsIgnoreCase("docx")) {
				JRDocxExporter exporter = new JRDocxExporter();

				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				String outputPath = "\\D:Content\\report";
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputPath+"kalu.docx"));
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));


				exporter.exportReport();
				
			}
			else if (format.equalsIgnoreCase("xlsx")) {

				System.out.println("Inside xlsx");
				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				String outputPath = "\\D:Content\\report";
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputPath+"kalu.xlsx"));
				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setDetectCellType(true);// Set configuration as you like it!!
				configuration.setCollapseRowSpan(false);
				exporter.setConfiguration(configuration);
				exporter.exportReport();

			}

			
			System.out.println("Done");
			return "Report sucessfully generated @Path =" + reportPath;

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error check on console log";
		}
	}

}
