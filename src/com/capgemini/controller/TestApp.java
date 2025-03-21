package com.capgemini.controller;

import java.util.Scanner;

import com.capgemini.ServiceFactory.StudentServiceFactory;
import com.capgemini.service.IStudentService;

import in.capgemini.dto.Student;

public class TestApp {

	public static void main(String[]args) {
		 Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operation you want to perform:");
        System.out.println("1. Insert Operation");
        System.out.println("2. Select Operation");
        System.out.println("3. Delete Operation");
        System.out.println("4. Update Operation");        
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                InsertOperation();
                break;
            case 2:
             
                selectoperation();
                break;
            case 3:
            	deleteoperation();
                break;
            case 4:
            	updateoperation();
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        sc.close();
		
	}
	
	private static void updateoperation() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student UID to be updated::");
		int studentUID = scanner.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.selectStudent(studentUID);
		if(student.getStudentId()!=null) {
			Student newStudent = new Student();
			System.out.println("Student UID is::"+student.getStudentId());
			newStudent.setStudentId(student.getStudentId());
			System.out.println("Student old name is::"+student.getStudentName()+"Enter new name::");
			String newName = scanner.next();
			if (newName.isEmpty()) {
			    newStudent.setStudentName(student.getStudentName());
			} else {
			    newStudent.setStudentName(newName);
			}
			System.out.println("Student old course is::"+student.getStudentCourse()+"Enter new course::");
			String newCourse = scanner.next();
			if(newCourse.endsWith("") || newCourse=="") {
				newStudent.setStudentCourse(student.getStudentCourse());
			}
			else {
				newStudent.setStudentCourse(newCourse);
			}
			
			System.out.println("Student old batch is::"+student.getBatchno()+"Enter new batch::");
			int newBatch = scanner.nextInt();
			if(newBatch==0) {
				newStudent.setBatchno(student.getBatchno());
			}
			else {
				newStudent.setBatchno(newBatch);
			}
			String status = studentService.updateStudent(newStudent);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record updated successfully");
					}
					else {
						System.out.println("Record updation failed");
					}
			
		}
		
		
	}
	
	private static void deleteoperation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id to be deleted:");
		int sid=sc.nextInt();
		IStudentService studentService= StudentServiceFactory.getStudentService();
		String msg=studentService.deleteStudent(sid);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted Successfully");
			
		}
		else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("Record is not available for student uid:"+sid);
		}
		else {
			System.out.println("Record deletion Failed");
		}
		sc.close();
	}
	private static void selectoperation() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Id:");
		int sid=sc.nextInt();
		IStudentService studentService =StudentServiceFactory.getStudentService();
		Student studentobject=studentService.selectStudent(sid);
		if(studentobject.getStudentId()==null) {
			System.out.println("Record not found for given Student Uid"+sid);
		}
		else {
			System.out.println("StudentId \t Student Name \t StudentCourse \t StudentBatchno:");
			System.out.println(studentobject.getStudentId()+"\t\t   "+  studentobject.getStudentName()+"\t\t  "+studentobject.getStudentCourse()+"\t\t  "+studentobject.getBatchno());
			
		}
		sc.close();
	}
	private static void InsertOperation() {
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Student UID:");
		Integer sUID=sc.nextInt();
		
		System.out.println("Enter Student Name:");
		String sName=sc.next();
		
		System.out.println("Enter Student Course:");
		String sCourse=sc.next();
		
		System.out.println("Enter Student Batch:");
		Integer sBatch=sc.nextInt();
		
		String message=studentService.addStudent(sUID, sName, sCourse, sBatch);
		if(message.equalsIgnoreCase("success")) {
			System.out.println("Record Inserted Successfully");
			
		}
		else {
			System.out.println("Record Insertion Failed");
		}
		sc.close();
		

	}
}

