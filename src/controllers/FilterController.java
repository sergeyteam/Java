package controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterController implements Filter {
	
	private FilterConfig config = null; 
	
    @Override
	public void init(FilterConfig config) throws ServletException {
    	 this.config = config; 
	}

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	String path = req.getRequestURI().substring(req.getContextPath().length());
    	System.out.println(chain);
    	if (path.matches("/")) {
    		request.getRequestDispatcher("/home").forward(request, response);  
//    		((HttpServletResponse) response).sendRedirect(req.getRequestURI() + "404.html");
//    		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response); // - страничка для аплоада картинок
		}
	}
	
	public void destroy() {
		config = null; 
	}

}
