<!DOCTYPE html>
<html>
<head>
    <title>Albums Management</title>
</head>
<body>
<h1>Manage Albums</h1>
<a href="/albums/new">Add New Album</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Release Date</th>
        <th>Artist</th>
        <th>Group</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list albums as album>
        <tr>
            <td>${album.albumId}</td>
            <td>${album.title}</td>
            <td>${album.releaseDate}</td>
            <td><#if album.artist??>${album.artist.name}</#if></td>
            <td><#if album.group??>${album.group.name}</#if></td>
            <td>
                <a href="/albums/edit/${album.albumId}">Edit</a>
                <form action="/albums/delete/${album.albumId}" method="post" style="display:inline;">
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
