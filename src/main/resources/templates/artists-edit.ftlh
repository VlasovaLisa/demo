<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Artist</title>
</head>
<body>
<h1>Edit Artist</h1>
<form action="/artists/update/${artist.artistID}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${artist.name}" required>
    <br><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender">
        <option value="Male" <#if artist.gender == "Male">selected</#if>>Male</option>
        <option value="Female" <#if artist.gender == "Female">selected</#if>>Female</option>
        <option value="Other" <#if artist.gender == "Other">selected</#if>>Other</option>
    </select>
    <br><br>

    <label for="birthdate">Birthdate:</label>
    <!-- Используем заранее отформатированную дату -->
    <input type="date" id="birthdate" name="birthdate" value="${formattedBirthdate}">
    <br><br>

    <label for="groupID">Group:</label>
    <select id="groupID" name="group">
        <option value="">None</option>
        <#list groups as group>
            <option value="${group.groupID}" <#if artist.group?has_content && artist.group.groupID == group.groupID>selected</#if>>${group.name}</option>
        </#list>
    </select>
    <br><br>

    <button type="submit">Update Artist</button>
</form>
<a href="/artists">Back to Artists</a>
</body>
</html>
