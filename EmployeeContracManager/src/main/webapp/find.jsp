<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <div class="find-contract">

                <h2>Znajdź umowę</h2>

                <form method="post">
                    <div class="form-section">
                        <h3>Wpisz adres email pracownika</h3>
                    </div>
                    <input type="email" placeholder="wprowadz adres email" name="employeeEmail">
                    <button type="submit" class="btn btn-success">Sprawdź</button>
                </form>
            </div>

            <div class="search-result">
                <c:choose>
                    <c:when test="${contract == null}">
                        <c:choose>
                            <c:when test="${message == null}">
                                <div class="message-text">
                                    <p>
                                        <span>${message = "Nie wykonano jeszcze żadnego wyszukiwania"}</span>
                                    </p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="message-text">
                                    <p>
                                        <span>${message}</span>
                                    </p>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <h5>${message = "Wyszukano następujące umowy : "}</h5>
                        <div class="contracts">
                        <table class="table-hover">
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
                        </table>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>

</div>

<%@include file="footer.jsp"%>