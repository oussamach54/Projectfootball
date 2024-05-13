<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Equipe</title>
</head>
<body>
<h1>Create Equipe</h1>
<form action="equipe" method="post">


    <label for="nom">Nom de l'équipe:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="pays">Pays:</label>
    <input type="text" id="pays" name="pays" required><br>

    <input type="submit" value="Créer">
</form>
<br>
<a href="equipelist">Liste des équipes</a>
</body>
</html>
