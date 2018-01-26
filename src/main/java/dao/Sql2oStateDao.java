package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;


public class Sql2oStateDao implements StateDao {

    Sql2o sql2o;

    public Sql2oStateDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add (State state) {
        String sql = "INSERT INTO states (name, numberOfParks, population) VALUES (:name, :numberOfParks, :population)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(state)
                    .executeUpdate()
                    .getKey();
            state.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<State> getAll() {
        String sql = "SELECT * FROM states";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(State.class);
        }
    }

    @Override
    public State findById(int id) {
        String sql = "SELECT * FROM states WHERE id = :id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(State.class);
        }
    }



}
