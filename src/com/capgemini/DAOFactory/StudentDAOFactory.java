package com.capgemini.DAOFactory;

import in.capgemini.persistence.IStudentDAO;
import in.capgemini.persistence.StudentDAOimpl;

public class StudentDAOFactory {
	
	private static IStudentDAO studentDAO=null;
	
	
	private StudentDAOFactory() {}
	
	public static IStudentDAO getStudentDAO() {
		if(studentDAO==null) {
			studentDAO=new StudentDAOimpl();
			
		}
		return studentDAO;
	}
	
}
