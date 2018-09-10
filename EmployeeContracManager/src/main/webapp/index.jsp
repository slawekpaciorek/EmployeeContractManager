<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

            <div class="row no-gutters title-text">
                <span>Employee Contract Manager</span>
            </div>

            <div class="welcome-text">
                <p>
                    <span>Witaj w aplikacji do zarządzania kontraktami</span>
                </p>
            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp"%>
