<!DOCTYPE html>
<html>
<head>
    <title>Artists Management</title>
</head>
<body>
<h1>Manage Artists</h1>
<a href="/artists/new">Add New Artist</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Birthdate</th>
        <th>Group</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list artists as artist>
        <tr>
            <td>${artist.artistId}</td>
            <td>${artist.name}</td>
            <td>${artist.gender}</td>
            <td>${artist.birthdate}</td>
            <td><#if artist.group??>${artist.group.name}</#if></td>
            <td>
                <a href="/artists/edit/${artist.artistId}">Edit</a>
                <form action="/artists/delete/${artist.artistId}" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="/">Back to Home</a>
</body>
</html>
