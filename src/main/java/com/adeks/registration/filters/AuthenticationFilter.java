package com.adeks.registration.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "/AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("login.jsp")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession(false);

			if (session == null) { // checking whether the session exists
				this.context.log("Unauthorized access request");

				res.sendRedirect(req.getContextPath() + "/login.jsp");
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}

	}

}
