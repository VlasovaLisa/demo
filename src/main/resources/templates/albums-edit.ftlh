<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Album</title>
</head>
<body>
<h1>Edit Album</h1>
<form action="/albums/update/${album.albumID}" method="post">
    <label for="title">Album Title:</label>
    <input type="text" id="title" name="title" value="${album.title}" required>
    <br><br>

    <label for="artist">Artist:</label>
    <select id="artist" name="artist">
        <#list artists as artist>
            <option value="${artist.artistID}" <#if album.artist.artistID == artist.artistID>selected</#if>>${artist.name}</option>
        </#list>
    </select>
    <br><br>

    <label for="releaseDate">Release Date:</label>
    <input type="date" id="releaseDate" name="releaseDate" value="${album.releaseDate?string("yyyy-MM-dd")}">
    <br><br>

    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre" value="${album.genre}">
    <br><br>

    <button type="submit">Update Album</button>
</form>

<form action="/albums/delete/${album.albumID}" method="post" onsubmit="return confirm('Are you sure you want to delete this album?');">
    <button type="submit" style="color: red;">Delete Album</button>
</form>

<a href="/albums">Back to Albums</a>
</body>
</html>
