package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oParkDaoTest {

    Connection con;
    Sql2o sql2o;
    Sql2oParkDao parkDao;
    Sql2oStateDao stateDao;

    public Park setupPark() {
        return new Park("Park", "Peak", "1000 acres", "Hot", "200 visits a year", "Up for resizing");
    }



    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        sql2o = new Sql2o(connectionString, "", "");
        parkDao = new Sql2oParkDao(sql2o);
        stateDao = new Sql2oStateDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void add() throws Exception {
        Park park = setupPark();
        parkDao.add(park);
        assertEquals(1,park.getId());
    }


}
