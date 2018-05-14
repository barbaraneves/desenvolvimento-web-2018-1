package index;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/efetuar-login")
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EfetuarLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarPessoas();
		
		Usuario usuario = usuarioDAO.buscarPessoa(login, senha);
		
		//PrintWriter out = response.getWriter();
		
		//Caso o usuário esteja na lista de pessoas cadastradas
		if(usuario != null) {
			sessao.setAttribute("usuario-logado", login);
			//Ele é redirecionado para a página de sucesso.html
			response.sendRedirect("sucesso.html");
		}
		//Caso o usuário tenha feito o login errado
		else{
			//Ele irá para a página de erro.html onde ele poderá fazer o login novamente
			response.sendRedirect("erro.html");
		}
		
	}
}
