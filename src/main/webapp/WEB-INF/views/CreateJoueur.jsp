<%--
  Created by IntelliJ IDEA.
  User: OUSSAMA CHAROUK
  Date: 03/05/2024
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Créer un joueu</title>
</head>

<body>
<h1>Créer un joueur</h1>
<form action="saveJoueur" method="post">
    <label for="nom">Nom du joueur:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="poste">Poste du joueur:</label>
    <input type="text" id="poste" name="poste" required><br>

    <label for="equipeId">ID de l'équipe:</label>
    <input type="text" id="equipeId" name="equipeId" required><br>

    <input type="submit" value="Save">
</form>
</body>
</html>
