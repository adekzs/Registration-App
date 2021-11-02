package com.adeks.registration.servelets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.adeks.registration.model.Student;
import com.adeks.registration.repository.StudentService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/find")
public class FindServlet extends HttpServlet {

	@Inject
	StudentService stdService;

	@Inject
	Student std;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Student> stds = new ArrayList<Student>();

		if (req.getParameter("id") != null) {
			String id = req.getParameter("id");
			if (id.equals("all") || id.isEmpty()) {
				stds = stdService.getAllStudents();
				req.setAttribute("students", stds);
				req.getRequestDispatcher("records.jsp").forward(req, resp);
			} else {
				Integer id_int = Integer.valueOf(id);
				std = stdService.getStudentById(id_int);
				String base64Image = "";
				try {
				InputStream inputStream = std.getInputstream();
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
				System.out.println("Base64 image is ============"+ base64Image);
				req.setAttribute("student", std);
				req.setAttribute("base64Image", base64Image);
				req.getRequestDispatcher("edit.jsp").forward(req, resp);
			}
		} else if (req.getParameter("email") != null) {
			String email = req.getParameter("email");
			std = stdService.findStudentByEmail(email);
			req.setAttribute("student", std);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> stds = new ArrayList<Student>();
		stds = stdService.getAllStudents();
		req.setAttribute("students", stds);
		req.getRequestDispatcher("records.jsp").forward(req, resp);
	}
	
	

}
