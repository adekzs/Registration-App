package com.adeks.registration.servelets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.adeks.registration.model.Login;
import com.adeks.registration.model.Student;
import com.adeks.registration.repository.StudentService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/reg")
@MultipartConfig(maxFileSize = 16177215)
public class RegistrationServlet extends HttpServlet{
	
	
	@Inject
	private Student std;

	@Inject
	private StudentService studentService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String firstname = request.getParameter("firstname");
	        String middle = request.getParameter("middlename");
	        String surname = request.getParameter("surname");
	        String address = request.getParameter("address");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        Part filePart = request.getPart("photo");
	        
	        InputStream inputStream = null;
	        
	        if (filePart != null) {
	        	inputStream = filePart.getInputStream();
	        	std.setInputstream(inputStream);
	        }
	        std.setAddress(address);
	        std.setEmail(email);
	        std.setFirstName(firstname);
	        std.setMiddleName(middle);
	        std.setPhone(phone);
	        std.setSurName(surname);
	        
	        
	        System.out.println("firstname: " + firstname);
	        System.out.println("email: " + email);
	        Student sd = studentService.createStudent(std);
	        

	        // get response writer
	        PrintWriter writer = response.getWriter();
//	        Student reslt = studentService.createStudent(std);
	        // build HTML code
//	        req.setAttribute("message", message);
			request.getRequestDispatcher("/find").forward(request, response);
//	        String htmlRespone = "<html>";
//	        htmlRespone += "<h2>is it  updated, row 6"+ sd.toString()+ "<br/>";      
//	        htmlRespone += "</html>";
//	         
//	        // return response
//	        writer.println(htmlRespone);
	}

	
}
