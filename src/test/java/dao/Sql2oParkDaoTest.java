package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;


public class Sql2oParkDaoTest {

    Connection con;
    Sql2o sql2o;
    Sql2oParkDao parkDao;
    Sql2oStateDao stateDao;

    public Park setupPark() {
        return new Park("Park", "Peak", "1000 acres", "Hot", "200 visits a year", "Up for resizing");
    }

    public State setupState() {
        return new State("Oregon", "1", "4.093 million");
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

    @Test
    public void getAll() throws Exception {
        Park park = setupPark();
        parkDao.add(park);
        Park park1 = setupPark();
        parkDao.add(park1);
        Park notaddedpark = setupPark();
        assertEquals(2,parkDao.getAll().size());
    }

    @Test
    public void deleteById_deletesCorrectPark() throws Exception {
        Park park = setupPark();
        parkDao.add(park);
        Park park1 = setupPark();
        parkDao.add(park1);
        parkDao.deleteById(park.getId());
        parkDao.deleteById(park1.getId());
        assertEquals(0, parkDao.getAll().size());
    }

//    @Test
//    public void addParkToState() throws Exception {
//        State testState = setupState();
//        State otherState = setupState();
//
//        stateDao.add(testState);
//        stateDao.add(otherState);
//
//        Park testPark = setupPark();
//        parkDao.add(testPark);
//
//        parkDao.addParkToState(testPark, testState);
//        parkDao.addParkToState(testPark,otherState);
//
//        assertEquals(2, parkDao.getAll);
//    }







//    @Test
//    public void findById() throws Exception {
//        Park park1 = new Park("Zion", "Tall", "Big", "Cold", "100","No");
//        parkDao.add(park1);
//
//        Park park2 = new Park("Crater Lake", "Short", "Small", "Warm", "200", "No");
//        parkDao.add(park2);
//
//        assertEquals(park2, parkDao.findById(park2.getId()));
//    }




}
