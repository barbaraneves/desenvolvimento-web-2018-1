package index;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Filtro implements Filter {

    public Filtro() {
        // TODO Auto-generated constructor stub
    }
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpReponse = (HttpServletResponse) response;
		HttpSession sessao = httpRequest.getSession();
		
		if(sessao.getAttribute("usuario-logado") != null ||
				httpRequest.getRequestURI().endsWith("pagina-login") ||
				httpRequest.getRequestURI().endsWith("efetuar-login") ||
				httpRequest.getRequestURI().contains("Trabalho6")){

			chain.doFilter(request, response);
			
			return;
		}
		httpReponse.sendRedirect("pagina-login");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
