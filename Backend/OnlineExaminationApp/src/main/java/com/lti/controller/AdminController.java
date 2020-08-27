package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.AdminController.Status.StatusType;
import com.lti.dto.AdminViewQuestionDto;
import com.lti.dto.FileUploadDto;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/addsubject")
	public void addSubject(Exam_Db exam) {
		adminService.save(exam);
	}

	@PostMapping(path = "/viewsubject")
	public Exam_Db fetchSubjetById(int examId) {
		return adminService.fetchExamById(examId);
	}

	@GetMapping("/subjectlist")
	public List<Exam_Db> fetchAllSubject() {
		return adminService.fetchAllSubjects();
	}

	@PostMapping(path = "/addquestion")
	public Status addQuestion(Question_bank question) {
		try {
			adminService.save(question);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Questions added successfully!");
			return status;
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@RequestMapping(path = "/fetchquestion/{examId}", method = RequestMethod.GET)
	public List<AdminViewQuestionDto> fetchQuestionByExamId(@PathVariable int examId) {
		List<AdminViewQuestionDto> list = new ArrayList<AdminViewQuestionDto>();

		for (Question_bank obj : adminService.fetchQuestionByExamId(examId)) {
			AdminViewQuestionDto adminViewQuestionDto = new AdminViewQuestionDto();
			BeanUtils.copyProperties(obj, adminViewQuestionDto);
			list.add(adminViewQuestionDto);
		}
		return list;

	}

	@PostMapping("/file-upload")
	public Status upload(FileUploadDto fileUploadDto) throws Exception {
		System.out.println("file upload begins" + fileUploadDto.getExam_id());
		String fileUploadLocation = "d:/uploads/csv";
		String fileName = fileUploadDto.getCsvFile().getOriginalFilename();
		String targetFile = fileUploadLocation + fileName;
		try {
			FileCopyUtils.copy(fileUploadDto.getCsvFile().getInputStream(), new FileOutputStream(targetFile));
			System.out.println("file upload complete");
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		System.out.println("running readfile");
		adminService.readFile(fileUploadDto.getExam_id(), fileName, targetFile);
		System.out.println("readfile complete");
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	@PostMapping("/delete-question")
	public Status upload(@RequestBody int indexes[]) {
		try {
			for(int i=0; i<indexes.length; i++) {
			Question_bank question_bank = new Question_bank();
			question_bank = adminService.fetchQuestion(indexes[i]);
			question_bank.setActive(0);
			adminService.save(question_bank);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Questions deleted successfully!");
			return status;
			}
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		return null;

	}

//	public List<Question_bank> fetchQuestionByExamId ( int examId) {
//	return adminService.fetchQuestionByExamId(examId);
//
//}
	// public List<Question_bank> fetchAllQuestions(){
	// return adminService.fetchAllQuestions();
	// }

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
