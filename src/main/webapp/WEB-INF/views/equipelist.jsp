<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Equipe List</title>
</head>
<body>
<header>
    <h1>Equipe List</h1>
</header>
<main>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nom</th>
            <th scope="col">Pays</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${equipesVue}" var="equipe">
            <tr>
                <td>${equipe.id}</td>
                <td>${equipe.nom}</td>
                <td>${equipe.pays}</td>
                <td>
                    <a href="deleteEquipe?id=${equipe.id}">delete </a>
                    <a href="EditEquipe?id=${equipe.id}">edit </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<footer>
    <a href="createequipe">Equipe Creation</a>
</footer>
</body>
</html>
