package com.lti;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.ExamSetupImplement;
import com.lti.entity.Student_Info;

@SpringBootTest

class OnlineExaminationAppApplicationTests {

	@Test
	public void schematest() {
		ExamSetupImplement e=new ExamSetupImplement();
		Student_Info s=new Student_Info();
		s.setName("Raghav Mittal");
		e.testing(s);
		
	}

}
