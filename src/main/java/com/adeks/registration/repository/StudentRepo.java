package com.adeks.registration.repository;



import jakarta.enterprise.context.SessionScoped;


import jakarta.transaction.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.adeks.registration.model.Student;


@SessionScoped
public class StudentRepo implements Serializable{

	private DataSource ds;

	public StudentRepo() {
		super();
		if (ds == null) {
			InitialContext cxt = null;

			try {
				cxt = new InitialContext();
				ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/studentRepo");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				System.out.println("Inside error block");
				e.printStackTrace();
			}
		}
	}

	@Transactional
	public Boolean createStudent(Student student) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "INSERT INTO student ( firstname, middlename, surname, address, email, phone, photo) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, student.getFirstName());
		stmt.setString(2, student.getMiddleName());
		stmt.setString(3, student.getSurName());
		stmt.setString(4, student.getAddress());
		stmt.setString(5, student.getEmail());
		stmt.setString(6, student.getPhone());
		stmt.setBlob(7, student.getInputstream());
		return stmt.executeUpdate() > 0;
	}

	@Transactional
	public Boolean updateStudent(Integer id, Student student) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "UPDATE  student SET firstname = ?, middlename = ?, surname = ?, address = ?, email = ?, phone = ?, photo = ? WHERE studentid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, student.getFirstName());
		stmt.setString(2, student.getMiddleName());
		stmt.setString(3, student.getSurName());
		stmt.setString(4, student.getAddress());
		stmt.setString(5, student.getEmail());
		stmt.setString(6, student.getPhone());
		stmt.setBlob(7, student.getInputstream());
		stmt.setInt(8, id);
		return stmt.executeUpdate() > 0;
	}

	@Transactional
	public Boolean deleteStudent(Integer id) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "DELETE FROM student WHERE studentid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt.executeUpdate() > 0;

	}

	public Student findStudentById(Integer id) throws SQLException{
		Connection conn = ds.getConnection();
		String sql = "SELECT studentid, firstname, middlename, surname, address, email, phone, photo FROM student WHERE studentid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		Student std = null;
		if (result.next()) {
			std = new Student();
			std.setAddress(result.getString("address"));
			std.setEmail(result.getString("email"));
			std.setFirstName(result.getString("firstname"));
			std.setId(result.getInt("studentid"));
			std.setMiddleName(result.getString("middlename"));
			std.setPhone(result.getString("phone"));
			std.setSurName(result.getString("surname"));
			std.setInputstream(result.getBlob("photo").getBinaryStream());
		}
		
		return std;
	}

	public Student findStudentByEmail(String email) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "SELECT studentid, firstname, middlename, surname, address, email, phone, photo FROM student WHERE email= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet result = stmt.executeQuery();
		Student std = null;
		while (result.next()) {
			std = new Student();
			std.setAddress(result.getString("address"));
			std.setEmail(result.getString("email"));
			std.setFirstName(result.getString("firstname"));
			std.setId(result.getInt("studentid"));
			std.setMiddleName(result.getString("middlename"));
			std.setPhone(result.getString("phone"));
			std.setSurName(result.getString("surname"));
			std.setInputstream(result.getBlob("photo").getBinaryStream());
		}
		return std;
	}

	public List<Student> findAllStudent() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "SELECT studentid, firstname, middlename, surname, address, email, phone FROM student";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		List<Student> students = new ArrayList<>();
		Student std = null;
		while (result.next()) {
			std = new Student();
			std.setAddress(result.getString("address"));
			std.setEmail(result.getString("email"));
			std.setFirstName(result.getString("firstname"));
			std.setId(result.getInt("studentid"));
			std.setMiddleName(result.getString("middlename"));
			std.setPhone(result.getString("phone"));
			std.setSurName(result.getString("surname"));
			students.add(std);
		}
		return students;
	}

	public String getImageData(int img_id) throws SQLException {
		// TODO Auto-generated method stub
		 String base64Image = null;
		try {
		Connection conn = ds.getConnection();
		String sql = "SELECT photo FROM student where studentid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, img_id);
		ResultSet result = stmt.executeQuery();
		Blob r = null;
		if (result.next()) {
			 r = result.getBlob("photo");
		}		
		InputStream inputStream = r.getBinaryStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
       
         
        
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);                  
			}
			 byte[] imageBytes = outputStream.toByteArray();
		         base64Image = Base64.getEncoder().encodeToString(imageBytes);
		        
		        
		        inputStream.close();
		        outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
       
		return base64Image;
	}
}
