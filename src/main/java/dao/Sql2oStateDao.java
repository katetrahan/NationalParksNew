package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;


public class Sql2oStateDao implements StateDao {

    private final Sql2o sql2o;

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

    @Override
    public void update(int id, String newName, String newNumberOfParks, String newPopulation){
        String sql = "UPDATE states SET name = :name, numberOfParks = :numberOfParks, population = :population WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("numberOfParks", newNumberOfParks)
                    .addParameter("population", newPopulation)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM states WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println();
        }
    }

//    @Override
//    public List<Park> getAllParksForAState(int stateId) {
//        ArrayList<Park> parks = new ArrayList<>();
//        String getParksIdsQuery = "SELECT parkId FROM states_parks WHERE stateId = :stateId";
//        try (Connection con = sql2o.open()) {
//            List<Integer> allParksIds = con.createQuery(getParksIdsQuery)
//                    .addParameter("stateId", stateId)
//                    .executeAndFetch(Integer.class);
//
//            for(Integer parkId: allParksIds) {
//                String sql = "SELECT * FROM parks WHERE id = :parkId";
//                parks.add(
//                        con.createQuery(sql)
//                        .addParameter("parkId", parkId)
//                        .executeAndFetchFirst(Park.class)
//                );
//            }
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//
//        return parks;
//    }




//    @Override
//    public void addStateToPark(State state, Park park) {
//        String sql = "INSERT INTO states_parks (stateId, parkId) VALUES (:stateId, :parkId)";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("stateId", state.getId())
//                    .addParameter("parkId", park.getId())
//                    .executeUpdate();
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }




}
