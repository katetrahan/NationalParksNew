package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;


public class Sql2oParkDao implements ParkDao{

    Sql2o sql2o;

    public Sql2oParkDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Park park) {
        String sql = "INSERT INTO parks (name, peak, terrain, visits, resize) VALUES (:name, :peak, :terrain, :visits, :resize)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(park)
                    .executeUpdate()
                    .getKey();
            park.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Park> getAll(){
        String sql = "SELECT * FROM parks";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Park.class);
        }
    }


}
