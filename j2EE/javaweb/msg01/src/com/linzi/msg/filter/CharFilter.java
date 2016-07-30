package com.linzi.msg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {
	private String encoding;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest requsest, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		requsest.setCharacterEncoding(encoding);
		chain.doFilter(requsest, response);
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		encoding = cfg.getInitParameter("encoding");
		if (encoding == null || "".equals(encoding.trim())){
			encoding = "UTF-8";
		}
	}
}
