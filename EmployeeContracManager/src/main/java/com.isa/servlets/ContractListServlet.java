package com.isa.servlets;

import com.isa.dao.ContractRepoDao;
import com.isa.domain.Contract;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("wykaz-umow")
public class ContractListServlet extends HttpServlet {

    @Inject
    ContractRepoDao contractRepoDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("contract-list.jsp");

        List<Contract> contracts = contractRepoDao.getAllContracts();

        if(contracts.size() == 0){
            String message = "Nie wprowadziłeś jeszcze żadnyh danych, przejdz do modułu dodowania kontraktów";
            req.setAttribute("message", message);
        }
        else {
            req.setAttribute("contracts", contracts);
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
