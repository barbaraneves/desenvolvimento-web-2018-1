package trabalho5;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/soma-e-subtracao")
public class SomarSubtrair extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
		
		double n1 = Double.parseDouble(numero1);
		double n2 = Double.parseDouble(numero2);
		
		double soma = n1 + n2;
		double subtracao = n1 - n2;

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body");
        
        	out.println("<div style='text-align: center'>");
        		out.println("<h1>Parte 2</h1>");
        		out.println("<h3>Soma e Subtração de Números</h3>");
        		out.println("<p>A <b>soma</b> de " + n1 + " e " + n2 + " é <b>" + soma + "</b>. </p>");
        		out.println("<p>A <b>subtração</b> de " + n1 + " e " + n2 + " é <b>" + subtracao + "</b>. </p>");
        	out.println("</div>");
        	
        out.println("</body>");
        out.println("</html>");
	}
}
