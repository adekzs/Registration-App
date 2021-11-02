package com.adeks.registration.servelets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (!username.equals("mis") || !password.contentEquals("mis")) {
			message = "Invalid Credentials";
			req.setAttribute("message", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {

			HttpSession oldSession = req.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}

			HttpSession newSession = req.getSession(true);

			newSession.setMaxInactiveInterval(5 * 60);
			req.setAttribute("message", message);
			req.getRequestDispatcher("/find").forward(req, resp);
		}
	}

}
