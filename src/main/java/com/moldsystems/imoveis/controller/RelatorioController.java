package com.moldsystems.imoveis.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class RelatorioController {
    @Autowired
    private DataSource dataSource;
	
	@GetMapping("/relatorio")
    public ResponseEntity<InputStreamResource> gerarRelatorio(HttpServletResponse response) throws JRException, IOException, SQLException {
		
	    // Obtenha a conexão do DataSource
	    Connection connection = dataSource.getConnection();
	    
        // Carregue o arquivo .jasper do seu relatório
        InputStream jasperStream = this.getClass().getResourceAsStream("/report/imoveis.jasper");

        // Gere o relatório em formato PDF
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, connection);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        // Crie um InputStreamResource a partir dos bytes do PDF
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(pdfBytes));

        // Defina os cabeçalhos da resposta HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio.pdf");
        headers.setContentType(MediaType.APPLICATION_PDF);

        // Retorne a resposta com o PDF como um InputStreamResource
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(pdfBytes.length)
                .body(resource);
    }
}
