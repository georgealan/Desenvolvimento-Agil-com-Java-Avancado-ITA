package com.oraculo.controller;

import com.oraculo.model.Oraculo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/oraculoController")
public class OraculoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipoProduto = req.getParameter("produto");
        Oraculo oraculo = new Oraculo();
        List<String> produtos = oraculo.melhoresProdutos(tipoProduto);
        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("resposta.jsp").forward(req, resp);
    }
}
