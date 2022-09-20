package com.bluni.bluni.models.util;

import com.bluni.bluni.models.entity.Computer;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("/views/computers/listar")
public class listarComputersPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Computer> listadoComputers = (List<Computer>) model.get("computers");
        PdfPCell celda = null;
        PdfPTable tituloTable = new PdfPTable(1);
        PdfPTable computerTable = new PdfPTable(11);
        computerTable.setWidths(new float[] {0.3f, 0.5f, 0.5f, 0.5f, 0.8f, 0.8f, 0.8f, 0.8f, 0.5f, 0.5f, 0.6f});

        document.setPageSize(PageSize.LEGAL.rotate());
        document.setMargins(-60, -60, 40, 20);
        document.open();

        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.WHITE);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
        Font fuenteCeldas = FontFactory.getFont(FontFactory.COURIER, 8, Color.BLACK);

        celda = new PdfPCell(new Phrase("LISTADO GENERAL DE COMPUTADORES", fuenteTitulo));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(30);
        celda.setBorderColor(Color.lightGray);
        tituloTable.addCell(celda);

        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Board", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Disco duro", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("GPU", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("MAC", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Marca", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Modelo", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("CPU", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("RAM", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Tipo", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        celda = new PdfPCell(new Phrase("Ubicación", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.BLACK);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(10);
        celda.setBorderColor(Color.lightGray);
        computerTable.addCell(celda);

        for (Computer computer : listadoComputers){

            Long id = computer.getId();
            String idString = Long.toString(id);
            celda = new PdfPCell(new Phrase(idString, fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getBoard(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getDisco_duro(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getGrafica(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getMac(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getMarca(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getModelo(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getProcesador(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getRam(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getTipo(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);

            celda = new PdfPCell(new Phrase(computer.getUbication().getUbicacion(), fuenteCeldas));
            celda.setPadding(5);
            celda.setBorderColor(Color.lightGray);
            computerTable.addCell(celda);


        };
        document.add(tituloTable);
        document.add(computerTable);
    }
}
