package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

import static org.junit.Assert.*;


public class Sql2oStateDaoTest {

    Connection con;
    Sql2oStateDao stateDao;
    Sql2oParkDao parkDao;

    public State setupState() {
        return new State("Oregon", "1", "4.093 million");
    }

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        stateDao = new Sql2oStateDao(sql2o);
//        parkDao = new Sql2oParkDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception{
        con.close();
    }

    @Test
    public void add() throws Exception {
        State state = setupState();
        stateDao.add(state);
        assertEquals(1, state.getId());
    }

    @Test
    public void getAll() throws Exception {
        State state = setupState();
        stateDao.add(state);
        State secondstate = setupState();
        stateDao.add(secondstate);
        State notAddedState = setupState();
        assertEquals(2,stateDao.getAll().size());
    }

    @Test
    public void findById() throws Exception {
        State state = setupState();
        State secondstate = setupState();
        State thirdstate = setupState();
        stateDao.add(state);
        stateDao.add(secondstate);
        stateDao.add(thirdstate);
        assertEquals(secondstate, stateDao.findById(secondstate.getId()));
    }

}
