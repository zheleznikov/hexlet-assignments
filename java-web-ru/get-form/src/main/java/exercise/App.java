package exercise;

import io.javalin.Javalin;

import java.util.List;

import exercise.model.User;
import exercise.dto.users.UsersPage;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;

import io.javalin.rendering.template.TemplateUtil;
import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("users/", ctx -> {
            String term = ctx.queryParam("term");

            List<User> users = term == null
                    ? USERS
                    : USERS.stream()
//                    .filter(item -> item.getFirstName().toLowerCase().startsWith(term.toLowerCase()))
                    .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                    .toList();

            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", TemplateUtil.model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
