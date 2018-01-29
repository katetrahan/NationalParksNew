package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Sql2oTipDao implements TipDao {

    Sql2o sql2o;

    public Sql2oTipDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Tip tip) {
        String sql = "INSERT INTO tips (writtenBy, content, rating, parkId) VALUES (:writtenBy, :content, :rating, :parkId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(tip)
                    .executeUpdate()
                    .getKey();
            tip.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

//    @Override
//    public List<Tip> getAll() {
//        String sql = "SELECT * FROM tips";
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql)
//                    .executeAndFetch(Tip.class);
//        }
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from tips WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<Tip> getAllTipsByPark(int parkId) {
        String sql = "SELECT * FROM tips WHERE parkId = :parkId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addColumnMapping("PARKID", "parkId")
                    .addParameter("parkId", parkId)
                    .executeAndFetch(Tip.class);
        }
    }
}
