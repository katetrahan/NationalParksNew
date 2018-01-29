package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;


public class Sql2oParkDao implements ParkDao {

    private final Sql2o sql2o;

    public Sql2oParkDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Park park) {
        String sql = "INSERT INTO parks (name, terrain, visits, resize) VALUES (:name, :terrain, :visits, :resize)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(park)
                    .executeUpdate()
                    .getKey();
            park.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Park> getAll() {
        String sql = "SELECT * FROM parks";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Park.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM parks WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public void addParkToState(Park park, State state) {
        String sql = "INSERT INTO states_parks (parkId, stateId) VALUES (:parkId, :stateId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("stateId", state.getId())
                    .addParameter("parkId", park.getId())
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<State> getAllStatesForAPark(int parkId) {
        ArrayList<State> states = new ArrayList<>();

        String stateParkQuery = "SELECT stateId FROM states_parks WHERE parkId = :parkId";

        try (Connection con = sql2o.open()) {
            List<Integer> allStateIds = con.createQuery(stateParkQuery)
                    .addParameter("parkId", parkId)
                    .executeAndFetch(Integer.class);
            for (Integer stateId : allStateIds) {
                String stateQuery = "SELECT * FROM states WHERE id = :stateId";
                states.add(
                        con.createQuery(stateQuery)
                                .addParameter("stateId", stateId)
                                .executeAndFetchFirst(State.class));
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
return states;

    }
}




