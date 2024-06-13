@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    <form action="/users" method="get" class="form">
        <input type="search" name="term" required value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Last name</th>
        </tr>
        </thead>
        <tbody>
        @for (User user : page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
            </tr>
        @endfor

        </tbody>

    </table>





`
)