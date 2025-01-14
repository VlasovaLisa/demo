<!DOCTYPE html>
<html>
<head>
    <title>Groups Management</title>
</head>
<body>
<h1>Manage Groups</h1>
<a href="/groups/new">Add New Group</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Debut Year</th>
        <th>Company</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list groups as group>
        <tr>
            <td>${group.groupID}</td>
            <td>${group.name}</td>
            <td>${group.debutYear}</td>
            <td>${group.company}</td>
            <td>
                <a href="/groups/edit/${group.groupID}">Edit</a>
                <form action="/groups/delete/${group.groupID}" method="post" style="display:inline;">
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
