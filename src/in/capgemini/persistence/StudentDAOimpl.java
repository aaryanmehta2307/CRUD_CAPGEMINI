package in.capgemini.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.DBUtil.DBConnection;

import in.capgemini.dto.Student;

public class StudentDAOimpl implements IStudentDAO {

	Connection con=null;
	PreparedStatement psmt=null;
	DBConnection connectionobject=new DBConnection();
	ResultSet resultSet=null;
	Student student =new Student();
	int rowaffected=0;
	@Override
	public String addStudent(Integer StudentId, String StudentName, String StudentCourse, Integer Batchno) {
		String sqlInsertQuery="insert into Studentdb values(?,?,?,?)";
		try {
			con=connectionobject.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null) {
			try {
				psmt=con.prepareStatement(sqlInsertQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				if(psmt!=null) {
					try {
						psmt.setInt(1, StudentId);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				
					try {
						psmt.setString(2, StudentName);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
						psmt.setString(3, StudentCourse);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
						psmt.setInt(4, Batchno);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					
					try {
						rowaffected=psmt.executeUpdate();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					
					
				}
		}
		if(rowaffected>0) {
			return "success";
			
		}
		else {
			return "failed";
		}
		
	}

	@Override
	public Student selectStudent(Integer StudentId) {
		String sqlsearchquery="select * from studentdb where StudentId=?";
		try {
			con=connectionobject.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null) {
			try {
				psmt=con.prepareStatement(sqlsearchquery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(psmt!=null) {
				try {
					psmt.setInt(1, StudentId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					resultSet=psmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(resultSet!=null) {
					try {
						if(resultSet.next()) {
							student=new Student();
							student.setStudentId(resultSet.getInt(1));
							student.setStudentName(resultSet.getString(2));
							student.setStudentCourse(resultSet.getString(3));
							student.setBatchno(resultSet.getInt(4));
						
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		return student;
		
	}

	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update studentdb set StudentName=?, StudentCourse=?, Batchno=? where StudentId=?";
		try {
			con=connectionobject.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null) {
			try {
				psmt = con.prepareStatement(sqlUpdateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.setInt(4, student.getStudentId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setString(1, student.getStudentName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setString(2, student.getStudentCourse());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setInt(3, student.getBatchno());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rowaffected = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowaffected==1) {
			return "success";
		}
		return "failure";
	}


	@Override
	public String deleteStudent(Integer StudentId) {
		String sqldeleteQuery="delete from studentdb where StudentId=?";
		try {
			con=connectionobject.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null) {
			try {
				psmt=con.prepareStatement(sqldeleteQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				if(psmt!=null) {
					try {
						psmt.setInt(1, StudentId);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					
					try {
						rowaffected=psmt.executeUpdate();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
		}
		if(rowaffected>0) {
			return "success";
			
		}
		else {
			return "failed";
		}
		
	
	}

}
