package trabalho5;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora-de-imc")
public class CalculadoraIMC extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
		private String classificaIMC(double imc) {
			String classificacao;
			
			if(imc < 16){
                classificacao = "Abaixo do peso (magreza grave)";
            }
            else if(imc >= 16 && imc < 17){
                classificacao = "Abaixo do peso (magreza moderada)";
            }
            else if(imc >= 17 && imc < 18.5){
                classificacao = "Abaixo do peso";
            }
            else if(imc >= 18.5 && imc < 25){
                classificacao = "Peso normal";
            }
            else if(imc >= 25 && imc < 30){
                classificacao = "Sobrepeso";
            }
            else if(imc >= 30 && imc < 35){
                classificacao = "Obesidade Grau I";
            }
            else if(imc >= 35 && imc < 40){
                classificacao = "Obesidade Grau II \n (severa)";
            }else{
                classificacao = "Obesidade Grau III \n (mórbida)";
            }
			
			return classificacao;
		}
		
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	
			String altura = request.getParameter("altura");
	        String peso = request.getParameter("peso");

	        double alt = Double.parseDouble(altura);
	        double pes = Double.parseDouble(peso);
	        double imc = pes/(alt * alt);

	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<body");
	        
	        	out.println("<div style='text-align: center'>");
	        		out.println("<h1>Parte 1</h1>");
	        		out.println("<h3>Calculadora de Índice de Massa Corporal (IMC)</h3>");
		
		        		out.println("<p>");
			        		out.printf("IMC: %.2f", imc); 
			        		out.println("kg/m² <br>");
				        	out.println("Sua classificação: " + classificaIMC(imc) + ".");
			        	out.println("</p>");
			        
		        out.println("</div>");
	        	
	        out.println("</body>");
	        out.println("</html>");
		}
}
