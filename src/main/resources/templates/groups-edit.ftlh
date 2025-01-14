<!DOCTYPE html>
<html>
<head>
    <title>Edit Group</title>
</head>
<body>
<h1>Edit Group</h1>
<form action="/groups/update/${group.groupId}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${group.name}" required>
    <br>
    <label for="debutYear">Debut Year:</label>
    <input type="number" id="debutYear" name="debutYear" value="${group.debutYear}">
    <br>
    <label for="company">Company:</label>
    <input type="text" id="company" name="company" value="${group.company}">
    <br>
    <button type="submit">Update</button>
</form>
<a href="/groups">Back to Groups</a>
</body>
</html>
