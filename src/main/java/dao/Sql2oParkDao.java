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
        String sql = "INSERT"
    }


}
