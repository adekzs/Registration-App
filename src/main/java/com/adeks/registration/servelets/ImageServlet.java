package com.adeks.registration.servelets;

import java.io.IOException;
import java.io.OutputStream;

import com.adeks.registration.repository.StudentService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

	@Inject
	StudentService stdService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int img_id = Integer.parseInt(request.getParameter("your_id"));
		OutputStream oImage;
		byte barray[] = stdService.getImageData(img_id);
		response.setContentType("image/gif");
		oImage = response.getOutputStream();
		oImage.write(barray);
		oImage.flush();
		oImage.close();

	}

}
