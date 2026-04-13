package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;

@WebServlet(urlPatterns = {"/main", "/insert", "/select", "/update", "/delete"})
public class ProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProdutoDAO dao = new ProdutoDAO();
    Produto p = new Produto();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getServletPath();

        // LISTAR
        if (action.equals("/main")) {
            ArrayList<Produto> lista = dao.listar();
            req.setAttribute("produtos", lista);
            req.getRequestDispatcher("lista.jsp").forward(req, resp);
        }

        // SELECIONAR PARA EDITAR
        else if (action.equals("/select")) {
            p.setId(Integer.parseInt(req.getParameter("idprod")));
            dao.buscar(p);

            req.setAttribute("idprod", p.getId());
            req.setAttribute("nome", p.getNome());
            req.setAttribute("tipo", p.getTipo());
            req.setAttribute("sessao", p.getSessao());

            req.getRequestDispatcher("editar.jsp").forward(req, resp);
        }

        // EXCLUIR
        else if (action.equals("/delete")) {
            p.setId(Integer.parseInt(req.getParameter("idprod")));
            dao.deletar(p);
            resp.sendRedirect("main");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getServletPath();

        // INSERIR
        if (action.equals("/insert")) {
            p.setNome(req.getParameter("nome"));
            p.setTipo(req.getParameter("tipo"));
            p.setSessao(req.getParameter("sessao"));

            dao.inserir(p);
            resp.sendRedirect("main");
        }

        // ATUALIZAR
        else if (action.equals("/update")) {
            p.setId(Integer.parseInt(req.getParameter("idprod")));
            p.setNome(req.getParameter("nome"));
            p.setTipo(req.getParameter("tipo"));
            p.setSessao(req.getParameter("sessao"));

            dao.atualizar(p);
            resp.sendRedirect("main");
        }
    }
}