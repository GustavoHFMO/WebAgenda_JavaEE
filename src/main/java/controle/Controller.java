package controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/insert"})
public class Controller extends HttpServlet {
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/Controller")) {
			contatos(request, response);
			
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		
		} else {
			response.sendRedirect("index.html");
		}
		
		// codigo para testar a conexao no servlet
		//dao.testeConexao();
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("agenda.jsp");
		
		// criando um objeto que vai receber os dados do javaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		
		// encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		
		/***
		// recebendo os dados da lista
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
		}***/
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		//invocar o metodo inserir contato
		dao.inserirContato(contato);
		
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("Controller");
	}
	

}
