package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;




public class Sql2oTipDaoTest {
    Connection con;
    Sql2o sql2o;
    Sql2oTipDao tipDao;
    Sql2oParkDao parkDao;

    public Park setupPark() {
        return new Park("Park",  "Hot", "200 visits a year", "Up for resizing");
    }

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        sql2o = new Sql2o(connectionString, "", "");
        tipDao = new Sql2oTipDao(sql2o);
        parkDao = new Sql2oParkDao(sql2o);
        con = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void add() throws Exception {
        Park testPark = setupPark();
        parkDao.add(testPark);
        Tip testTip = new Tip ("Oprah","Bring comfy shoes", 5, testPark.getId()); tipDao.add(testTip);
        assertEquals(1, testTip.getId());
    }

    @Test
    public void addingTipSetsId() throws Exception {
        Park testPark = setupPark();
        parkDao.add(testPark);
        Tip testTip = new Tip("Oprah","Bring comfy shoes", 5, testPark.getId());
        tipDao.add(testTip);
        assertEquals(1,testTip.getId());

    }

    @Test
    public void getAllTipsByPark() throws Exception {
        Park testPark = setupPark();
        parkDao.add(testPark);

        Park newPark = setupPark();
        parkDao.add(newPark);

        Tip testTip = new Tip("jan", "bring sunscreen", 4, testPark.getId());
        tipDao.add(testTip);

        Tip othertip = new Tip("donald", "parks suck", 1, testPark.getId());
        tipDao.add(othertip);

        assertEquals(2, tipDao.getAllTipsByPark(testPark.getId()).size());//need to get id of park first.
        assertEquals(0, tipDao.getAllTipsByPark(newPark.getId()).size());//need to get id of park first
    }









}
