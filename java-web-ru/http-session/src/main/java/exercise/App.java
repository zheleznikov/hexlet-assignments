package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            String pageNumber = ctx.queryParam("page") == null ? "1" : ctx.queryParam("page");
            String numberOfElements = ctx.queryParam("per") == null ? "5" : ctx.queryParam("per");

            int start = (Integer.parseInt(pageNumber) - 1) * Integer.parseInt(numberOfElements); // 4
            int finish = Integer.parseInt(pageNumber) * Integer.parseInt(numberOfElements); // 6

            List<Map<String, String>> result = new ArrayList<>();

            for (int i = start; i < finish; i++) {
                result.add(USERS.get(i));
            }

            ctx.json(result);

        });

        /*  Продвинутое решение
           app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var offset = (page - 1) * per;
            List<Map<String, String>> sliceOfUsers = USERS.subList(offset, offset + per);
            ctx.json(sliceOfUsers);
        });
        * */



        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
