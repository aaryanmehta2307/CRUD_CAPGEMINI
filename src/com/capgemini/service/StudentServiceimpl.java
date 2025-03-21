package com.capgemini.service;

import com.capgemini.DAOFactory.StudentDAOFactory;

import in.capgemini.dto.Student;
import in.capgemini.persistence.IStudentDAO;

public class StudentServiceimpl implements IStudentService {
	private IStudentDAO studentDAO;
	
	@Override
	public String addStudent(Integer StudentId, String StudentName, String StudentCourse, Integer Batchno) {
		studentDAO= StudentDAOFactory.getStudentDAO();
		if(studentDAO!=null) {
			return studentDAO.addStudent(StudentId, StudentName, StudentCourse, Batchno);
		}
		else {
			
			return "failed";
		}
	}

	@Override
	public Student selectStudent(Integer StudentId) {
		studentDAO=StudentDAOFactory.getStudentDAO();
		return studentDAO.selectStudent(StudentId);
	}

	@Override
	public String updateStudent(Student StudentId) {
		studentDAO=StudentDAOFactory.getStudentDAO();
		return studentDAO.updateStudent(StudentId);
		
	}

	@Override
	public String deleteStudent(Integer StudentId) {
		studentDAO =StudentDAOFactory.getStudentDAO();
		return studentDAO.deleteStudent(StudentId);
	}

}
