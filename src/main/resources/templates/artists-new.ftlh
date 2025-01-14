<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Artist</title>
</head>
<body>
<h1>Add New Artist</h1>
<form action="/artists/save" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select>
    <br><br>

    <label for="birthdate">Birthdate:</label>
    <input type="date" id="birthdate" name="birthdate">
    <br><br>

    <label for="groupID">Group:</label>
    <select id="groupID" name="group">
        <option value="">None</option>
        <#list groups as group>
            <option value="${group.groupID}">${group.name}</option>
        </#list>
    </select>
    <br><br>

    <button type="submit">Add Artist</button>
</form>
<a href="/artists">Back to Artists</a>
</body>
</html>
