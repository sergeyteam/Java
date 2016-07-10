package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericFilter implements Filter {
	public FilterConfig filterConfig; // 1

	public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
		chain.doFilter(request, response);
	}

	public void init(final FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		
	}

}
