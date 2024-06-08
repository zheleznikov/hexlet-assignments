@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<h1>Users</h1>
@if (page.getUsers().isEmpty())
    <p>No users</p>
@else
    @for(User user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>