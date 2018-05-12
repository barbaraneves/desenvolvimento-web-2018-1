package trabalho5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mega-sena")
public class GerarNumero extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Integer> resultado = new ArrayList<Integer>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        //Números não repetidos entre 1 e 60 para Mega-Sena
        for(int i = 1; i <= 60; i++){
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        //Sugestão dos 6 números entre 1 e 60
        for (int i = 0; i < 6; i++){
            resultado.add(numeros.get(i));
        }
        Collections.sort(resultado);

        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<body");
        
        	out.println("<div style='text-align: center'>");
        		out.println("<h1>Parte 3</h1>");
		        out.println("<h3> Números Sorteados </h3>");
		        for (Integer valor : resultado) {
		        	out.println(valor + " ");
		        }
	        out.println("</div>");
	        
        out.println("</body>");
        out.println("</html>");
	}
}
