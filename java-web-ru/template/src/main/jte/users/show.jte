@import exercise.dto.users.UserPage
@param UserPage page
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
        <div>${page.getUser().getEmail()}</div>
    </main>
</div>
</body>
</html>
