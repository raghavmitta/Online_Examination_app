package com.lti.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.controller.AdminController.Status;
import com.lti.controller.PdfDownload.Status.StatusType;

@RestController
@CrossOrigin
public class PdfDownload {
	@GetMapping("/profile")
	public Status fetchPdf(@RequestParam("Id") int id, HttpServletRequest request) {
		// reading the project's deployed folder location
		String projPath = request.getServletContext().getRealPath("/");
		String tempDownloadPath = projPath + "/downloads/";
		// creating a folder within the project where we will place the Pdf of the
		// customer getting fetched
		File f = new File(tempDownloadPath);
		if (!f.exists())
			f.mkdir();
		String targetFile = tempDownloadPath + id + ".pdf";
		// the original location where the uploaded pdf are present
		String uploadedPdfPath = "d:/uploads/pdf";
		String sourceFile = uploadedPdfPath + id + ".pdf";
		try {
			FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
			System.out.println("readfile complete");
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Uploaded!");
			return status;
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	public static class Status {
		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

}
