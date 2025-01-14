<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Album</title>
</head>
<body>
<h1>Create New Album</h1>
<form action="/albums/save" method="post">
    <label for="title">Album Title:</label>
    <input type="text" id="title" name="title" required>
    <br><br>

    <label for="artist">Artist:</label>
    <select id="artist" name="artist">
        <#list artists as artist>
            <option value="${artist.artistID}">${artist.name}</option>
        </#list>
    </select>
    <br><br>

    <label for="releaseDate">Release Date:</label>
    <input type="date" id="releaseDate" name="releaseDate">
    <br><br>

    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre">
    <br><br>

    <button type="submit">Create Album</button>
</form>
<a href="/albums">Back to Albums</a>
</body>
</html>
