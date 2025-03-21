package in.capgemini.persistence;

import in.capgemini.dto.Student;

public interface IStudentDAO {
	public String addStudent(Integer StudentId,String StudentName,String StudentCourse,Integer Batchno);
	
	public Student selectStudent(Integer StudentId);
	

	public String updateStudent(Student student);

	public String deleteStudent(Integer StudentId);
}
