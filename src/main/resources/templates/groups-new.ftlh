<!DOCTYPE html>
<html>
<head>
    <title>Add New Group</title>
</head>
<body>
<h1>Add New Group</h1>
<form action="/groups/save" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="debutYear">Debut Year:</label>
    <input type="number" id="debutYear" name="debutYear">
    <br>
    <label for="company">Company:</label>
    <input type="text" id="company" name="company">
    <br>
    <button type="submit">Save</button>
</form>
<a href="/groups">Back to Groups</a>
</body>
</html>
