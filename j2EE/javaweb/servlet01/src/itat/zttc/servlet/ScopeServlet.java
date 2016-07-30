package itat.zttc.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScopeServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init servlet");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String username = config.getInitParameter("username");
		System.out.println(username);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service is invoking");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doGet is invoking");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy is invoking");
	}
}
