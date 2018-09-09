package com.isa.servlets;

import com.isa.dao.ContractRepoDao;
import com.isa.domain.Adress;
import com.isa.domain.Contract;
import com.isa.domain.ContractState;
import com.isa.domain.Employee;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("dodaj-nowa")
public class InsertNewServlet extends HttpServlet {

    @Inject
    ContractRepoDao contractRepoDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("insert-new.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        Set<Integer> contractNumbers = contractRepoDao.getAllContracts().stream().map(Contract::getNumber).collect(Collectors.toSet());

        String employeeName = req.getParameter("employeeName");
        String employeeSurname = req.getParameter("employeeSurname");
        String employeeEmail = req.getParameter("employeeEmail");
        String employeeSalary= req.getParameter("baseSalary");
        String zipCode = req.getParameter("zipCode");
        String cityName = req.getParameter("cityName");
        String streetName = req.getParameter("streetName");
        String streetNumber = req.getParameter("streetNumber");
        String flatNumber = req.getParameter("flatNumber");
        String expiryDate = req.getParameter("expiryDate");
        String contractType = req.getParameter("contractType");

        Adress adress = new Adress();
        adress.setZipCode(zipCode);
        adress.setCity(cityName);
        adress.setStreet(streetName);
        adress.setStreetNnumber(streetNumber);
        adress.setFlatNumber(flatNumber);

        Employee employee = new Employee();
        employee.setAdress(adress);
        employee.setName(employeeName);
        employee.setSurname(employeeSurname);
        employee.setEmail(employeeEmail);
        employee.setSalaryBase(Double.parseDouble(employeeSalary));

        Contract contract = new Contract();
        Integer number;
        if(contractNumbers.size() == 0){
            number = 1;
        }
        else{
            number = contractRepoDao.getAllContracts().stream().max(Comparator.comparing(Contract::getNumber)).get().getNumber() + 1;
        }
        contract.setNumber(number);
        contract.setEmployee(employee);
        contract.setTermOfValidity(LocalDate.parse(expiryDate));
        contract.setState(ContractState.valueOf(contractType));
        contract.salaryUpdate();

        contractRepoDao.addToRepo(contract);

        RequestDispatcher dispatcher = req.getRequestDispatcher("insert-new.jsp");
        dispatcher.forward(req, resp);

    }
}
