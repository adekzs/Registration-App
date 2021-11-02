package com.adeks.registration.servelets;

import java.io.IOException;
import java.io.InputStream;

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

@WebServlet("/update")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateServlet extends HttpServlet {

	@Inject
	StudentService stdService;

	@Inject
	Student std;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String middle = request.getParameter("middlename");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		Part filePart = request.getPart("photo");
		InputStream inputStream = null;

		if (filePart != null) {
			inputStream = filePart.getInputStream();
			std.setInputstream(inputStream);
			
		}
		System.out.println("id: " + id);
		std.setAddress(address);
		std.setEmail(email);
		std.setFirstName(firstname);
		std.setMiddleName(middle);
		std.setPhone(phone);
		std.setSurName(surname);
		std.setId(Integer.valueOf(id));

		System.out.println("Student is =====================: " + std.toString());
		System.out.println("email: " + email);

		stdService.updateStudent(std, Integer.valueOf(id));
		response.sendRedirect(request.getContextPath() + "/find?id=all");
	}
}
