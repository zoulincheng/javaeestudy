package com.linzi.msg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.linzi.msg.model.SystemContext;

public class SystemContextFilter implements Filter {
	int pageSize;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		try {
			int pageOffset = 0;
			int pageSize = 15;
			try {
				pageOffset = Integer.parseInt(req.getParameter("pager.offset"));
				//pageSize = Integer.parseInt(req.getParameter("pageSize"));
			} catch (NumberFormatException e) {
				
			}
			SystemContext.setPageOffset(pageOffset);
			//SystemContext.setPageIndex(pageIndex);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(req, res);
		} finally {
			//SystemContext.removePageIndex();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 15;
		}
	}
}
