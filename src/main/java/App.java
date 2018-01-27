
import com.google.gson.Gson;
import dao.Sql2oStateDao;
import dao.Sql2oParkDao;
import dao.Sql2oTipDao;
import exceptions.ApiException;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oStateDao stateDao;
        Sql2oParkDao parkDao;
        Sql2oTipDao tipDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        stateDao = new Sql2oStateDao(sql2o);
        parkDao = new Sql2oParkDao(sql2o);
        tipDao = new Sql2oTipDao(sql2o);
        conn = sql2o.open();



        //States

        post("/states/new","application/json", (request, response) -> {
            State state = gson.fromJson(request.body(),State.class);
            stateDao.add(state);
            response.status(201);
            return gson.toJson(state);
        });


        get("/states", "application/json", (request, response) -> {
            return gson.toJson(stateDao.getAll());
        });

        get("states/:id", "application/json", (request, response) -> {
            int stateId = Integer.parseInt(request.params("id"));

            State stateToFind = stateDao.findById(stateId);

            if(stateToFind == null) {
                throw new ApiException(404, String.format("No state with this id: \"%s\" exists", request.params("id")));
            }
            return gson.toJson(stateDao.findById(stateId));
        });

        //Parks

        post("/parks/new", "application/json", (request, response) -> {
            Park park = gson.fromJson(request.body(),Park.class);
            parkDao.add(park);
            response.status(201);
            return gson.toJson(park);
        });

        get("/parks", "application/json", (request, response) -> {
            return gson.toJson(parkDao.getAll());
        });




    }






}
