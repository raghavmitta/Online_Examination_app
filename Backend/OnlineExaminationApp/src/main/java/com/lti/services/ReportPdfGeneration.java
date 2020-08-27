package com.lti.services;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.entity.Detail_report_db;
import com.lti.entity.Question_bank;

class ReportPdfGeneration {
		
	public void generatePdf(List <Detail_report_db> DetailList) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("d:/uploads/pdf/"+ DetailList.get(0).getReport_id().getReport_id() + ".pdf"));
		document.open();
		for (Detail_report_db obj : DetailList) {
			document.add(new Paragraph("Response id: " + obj.getReport_id() + " \n Question: " + obj.getQues_id().getQuestion() + "\n Correct Answer:" + obj.getQues_id().getCorrect_answer() +  "Response:" + obj.getResponse() ));

		}

		document.close();
	}
}