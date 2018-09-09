package com.isa.servlets;

import com.isa.dao.ContractRepoDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("usuwanie")
public class DeleteServlet extends HttpServlet {

    @Inject
    ContractRepoDao contractRepoDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String employeeEmail = req.getParameter("email");

        contractRepoDao.getAllContracts();

        contractRepoDao.delete(employeeEmail);

        resp.sendRedirect("wykaz-umow");
    }

}
