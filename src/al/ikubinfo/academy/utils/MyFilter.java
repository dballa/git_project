package al.ikubinfo.academy.utils;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(filterName = "MyFilter", urlPatterns = { "*.xhtml" })
public class MyFilter implements Filter{
	
	
	private ServletContext context;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String contextPath = req.getContextPath();
			String uri = req.getRequestURI();
			HttpSession session = req.getSession(false);

			if (uri.indexOf("/login.xhtml") > 0 || (session != null && session.getAttribute("userId") != null))
				chain.doFilter(request, response);
			else  {
				res.sendRedirect(contextPath + "/login.xhtml");
			}
		} catch (Throwable t) {
			t.getMessage();
		}

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Initializing");

	}

	@Override
	public void destroy() {

	}
	
}