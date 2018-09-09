package com.isa.servlets;

import com.isa.dao.ContractRepoDao;
import com.isa.domain.Contract;
import com.isa.domain.Employee;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("znajdz")
public class FindServlet extends HttpServlet {

    @Inject
    ContractRepoDao contractRepoDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("find.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String email = req.getParameter("employeeEmail");
        List<String> emailList = contractRepoDao.getAllContracts().stream().map(Contract::getEmployee).map(Employee::getEmail).collect(Collectors.toList());

        if(!emailList.contains(email)){
            String message = "Nie poprawny adres email, wpisz jeszcze raz";
            req.setAttribute("message", message);
        }
        else {
            Contract contract = contractRepoDao.getAllContracts()
                    .stream()
                    .filter(c -> c.getEmployee().getEmail().equals(email))
                    .findAny().get();

            req.setAttribute("contract", contract);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("find.jsp");
        dispatcher.forward(req, resp);

    }
}
