<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>Albums Management</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>Manage Albums</h1>-->
<#--<a href="/albums/new">Add New Album</a>-->
<#--<table border="1">-->
<#--    <thead>-->
<#--    <tr>-->
<#--        <th>ID</th>-->
<#--        <th>Title</th>-->
<#--        <th>Release Date</th>-->
<#--        <th>Artist</th>-->
<#--        <th>Group</th>-->
<#--        <th>Actions</th>-->
<#--    </tr>-->
<#--    </thead>-->
<#--    <tbody>-->
<#--    <#list albums as album>-->
<#--        <tr>-->
<#--            <td>${album.albumID}</td>-->
<#--            <td>${album.title}</td>-->
<#--            <td>${album.releaseDate}</td>-->
<#--            <td><#if album.artist??>${album.artist.name}</#if></td>-->
<#--            <td><#if album.group??>${album.group.name}</#if></td>-->
<#--            <td>-->
<#--                <a href="/albums/edit/${album.albumID}">Edit</a>-->
<#--                <form action="/albums/delete/${album.albumID}" method="post" style="display:inline;">-->
<#--                    <button type="submit">Delete</button>-->
<#--                </form>-->
<#--            </td>-->
<#--        </tr>-->
<#--    </#list>-->
<#--    </tbody>-->
<#--</table>-->
<#--<a href="/">Back to Home</a>-->
<#--</body>-->
<#--</html>-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Albums</title>
</head>
<body>
<h1>Albums</h1>
<a href="/albums/new">Add New Album</a>
<br><br>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>Genre</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list albums as album>
        <tr>
            <td>${album.title}</td>
            <td>${album.artist.name}</td>
            <td>${album.releaseDate?string("yyyy-MM-dd")}</td>
            <td>${album.genre}</td>
            <td>
                <a href="/albums/edit/${album.albumID}">Edit</a>
                <form action="/albums/delete/${album.albumID}" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this album?');">
                    <button type="submit" style="color: red;">Delete</button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
