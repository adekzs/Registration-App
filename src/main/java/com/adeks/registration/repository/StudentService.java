package com.adeks.registration.repository;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adeks.registration.model.Student;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;




@SessionScoped
public class StudentService implements Serializable{
	
	@Inject
	StudentRepo studentRepo;
	
	public StudentService() {
		
	}
	public Student createStudent(Student student) {
		Boolean std = false;
		try {
			std = studentRepo.createStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  std ? student : null;
	}
	
	public Student getStudentById(int id) {
		Student std = null;
		try {
			std = studentRepo.findStudentById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}
	
	public Student findStudentByEmail(String email) {
		Student std = null;
		try {
			std = studentRepo.findStudentByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}
	
	public Boolean deleteStudent(int id) {
		Boolean std = false;
		try {
			std = studentRepo.deleteStudent(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		try {
			students = studentRepo.findAllStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return students;
	}
	public Boolean updateStudent(Student std, int id) {
		Boolean isUpdated = false;
		try {
			isUpdated = studentRepo.updateStudent(id, std);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return isUpdated;
	}
	public byte[] getImageData(int img_id) {
		// TODO Auto-generated method stub
		byte[] result = null;
		Blob blb = null;
		try {
			blb = null;
			result = blb.getBytes(0, (int) blb.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
