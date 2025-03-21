package com.capgemini.ServiceFactory;

import com.capgemini.service.IStudentService;
import com.capgemini.service.StudentServiceimpl;

public class StudentServiceFactory {
	private static IStudentService studentService=null;
	
	private StudentServiceFactory() {}
	
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService=new StudentServiceimpl();
		}
		return studentService;
	}
}
