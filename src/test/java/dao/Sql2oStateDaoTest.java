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

    private Connection con;
    private Sql2oStateDao stateDao;
    private Sql2oParkDao parkDao;
    private Sql2oTipDao tipDao;

    public State setupState() {
        return new State("Oregon", "1", "4.093 million");
    }

    public Park setupPark() {
        return new Park("Park",  "Hot", "200 visits a year", "Up for resizing");
    }

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        stateDao = new Sql2oStateDao(sql2o);
        parkDao = new Sql2oParkDao(sql2o);
        tipDao = new Sql2oTipDao(sql2o);
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
    public void addingStateSetsStateId() throws Exception {
        State testState = setupState();
        int originalStateId = testState.getId();
        stateDao.add(testState);
        assertNotEquals(originalStateId,testState.getId());

    }

    @Test
    public void addedStatesreturnCorrectly() throws Exception {
        State testState = setupState();
        stateDao.add(testState);
        assertEquals(1,stateDao.getAll().size());
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
    public void zerosStatesReturnsZeroStates() throws Exception {
        assertEquals(0, stateDao.getAll().size());
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

    @Test
    public void update() throws Exception {
        State state = setupState();
        stateDao.add(state);
        stateDao.update(state.getId(),"Utah", "", "");
        assertEquals("Utah", stateDao.findById(state.getId()).getName());
    }

    @Test
    public void deleteById() throws Exception {
        State state = setupState();
        stateDao.add(state);
        State secondstate = setupState();
        stateDao.add(secondstate);

        stateDao.deleteById(state.getId());
        stateDao.deleteById(secondstate.getId());
        assertEquals(0,stateDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectState() throws Exception {
        State stateOne = setupState();
        stateDao.add(stateOne);
        stateDao.deleteById(stateOne.getId());
        assertEquals(0,stateDao.getAll().size());
    }

    @Test
    public void getAllParksForAStateReturnsCorrectly() throws Exception { // implement add
        Park parkOne = setupPark();
        parkDao.add(parkOne);
        State stateOne = setupState();
        stateDao.add(stateOne);
        Park parkTwo = setupPark();
        parkDao.add(parkTwo);
        State stateTwo = setupState();
        stateDao.add(stateTwo);

        stateDao.addStateToPark(stateOne,parkOne);
        stateDao.addStateToPark(stateTwo,parkTwo);

        Park[] parks = {parkOne};
        assertEquals(stateDao.getAllParksForAState(stateOne.getId()), Arrays.asList(parks));

    }


}
