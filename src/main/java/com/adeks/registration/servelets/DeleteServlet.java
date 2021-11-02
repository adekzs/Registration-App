package com.adeks.registration.servelets;

import java.io.IOException;

import com.adeks.registration.model.Student;
import com.adeks.registration.repository.StudentService;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	@Inject
	StudentService stdService;

	@Inject
	Student std;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Boolean isDeleted = stdService.deleteStudent(Integer.valueOf(id));
		 RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/find?id=all");
			    dispatcher.forward(req, resp);
	}
}
