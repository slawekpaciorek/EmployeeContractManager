<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>

<div class="container-fluid page">

    <div class="row no-gutter">

        <div class="col-lg-2 col-md-4 col-sm-12 no-gutter left-bar">
            <ul>
                <li><a href="index.jsp">Start</a></li>
                <li><a href="wykaz-umow">Zobacz wszystkie umowy</a></li>
                <li><a href="dodaj-nowa">Wprowadź nową umowę</a></li>
                <li><a href="znajdz">Znajdz umowę</a></li>
            </ul>
        </div>

        <div class="col-lg-10 col-md-8 col-sm-12 main-bar">

            <div class="contracts">

                <h2>Lista wszystkich umów</h2>

                <c:choose>
                    <c:when test="${contracts == null}">
                        <div class="welcome-text">
                            <p>
                                <span>${message}</span>
                            </p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <table class="table-hover ">
                        <tr>
                            <th>Numer</th>
                            <th>Pracownik</th>
                            <th>Adres</th>
                            <th>Rodzaj kontraktu</th>
                            <th>Data ważności</th>
                            <th>Wynagrodzenie</th>
                            <th>Okres wypowiedzenia</th>
                            <th>Operacja</th>
                        </tr>
                        <c:forEach items="${contracts}" var="contract">
                            <tr>
                                <td>${contract.getNumber()}</td>
                                <td>${contract.getEmployee()}</td>
                                <td>${contract.getEmployee().getAdress()}</td>
                                <td>${contract.getState()}</td>
                                <td>${contract.getTermOfValidity()}</td>
                                <td>${contract.getSalary()}</td>
                                <td>${contract.getExpiryTime().name()}</td>
                                <td>
                                    <form method="get">
                                        <button type="submit" class="btn btn-warning" formaction="modyfikacja" name="email" value="${contract.getEmployee().getEmail()}">Modyfikacja</button>
                                        <button type="submit" class="btn btn-danger" formaction="usuwanie" name="email" value="${contract.getEmployee().getEmail()}">Usunięcie</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </table
                    </c:otherwise>
                </c:choose>
            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp"%>