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

            <div class="add-contract">

                <h2>Wprowadź dane umowy</h2>

                <form method="post">
                    <div class="form-section">
                        <h3>Pracownik :</h3>
                        <div>
                            <input name="employeeName" placeholder="imię" type="text" required>
                            <input name="employeeSurname" placeholder="naziwsko" type="text" required>
                            <input name="employeeEmail" placeholder="adres email" type="email" required>
                            <input name="baseSalary" placeholder="podstawa wynagrodzenia" type="number" required>
                        </div>
                        <h3>Adres : </h3>
                        <div>
                            <input name="zipCode" placeholder="kod pocztowy" type="text" required>
                            <input name="cityName" placeholder="miasto" type="text" required>
                        </div>
                        <div>
                            <input name="streetName" placeholder="ulica" type="text" required>
                            <input name="streetNumber" placeholder="numer ulicy" type="number" required>
                            <input name="flatNumber" placeholder="numer mieszkania" type="number" required>
                        </div>
                        <h3>Szczegóły kontraktu : </h3>
                        <div>
                            <label>
                                Data zakończenia
                                <input type="date" name="expiryDate" required>
                            </label>
                            <label>
                                Rodzaj umowy
                                <select required name="contractType">
                                    <option>wybierz...</option>
                                    <option>B2B</option>
                                    <option>UoP</option>
                                    <option>UD</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="form-button">
                        <button type="submit" class="btn btn-success" formaction="dodaj-nowa">Zapisz</button>
                        <button type="submit" class="btn btn-warning" formaction="modyfikacja">Modyfikuj</button>
                    </div>
                </form>
            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp"%>