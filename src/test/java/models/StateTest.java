package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StateTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    public State setupState() {
        return new State("Oregon", "1", "4.093 million");
    }


    @Test
    public void getNameReturnsCorrectly() throws Exception {
        State newState = setupState();
        assertEquals("Oregon", newState.getName());
    }

    @Test
    public void getNumberOfParksReturnsCorrectly() throws Exception {
        State newState = setupState();
        assertEquals("1", newState.getNumberOfParks());
    }

    @Test
    public void getPopultaionReturnsCorrectly() throws Exception {
        State newState = setupState();
        assertEquals("4.093 million", newState.getPopulation());
    }

    @Test
    public void setNameSetsCorrectly() throws Exception {
        State newState = setupState();
        newState.setName("Ellen Degeneras");
        assertNotEquals("Oprah", newState.getName());
    }

    @Test
    public void setNumberOfParksReturnsCorrectly() throws Exception {
        State newState = setupState();
        newState.setNumberOfParks("100");
        assertNotEquals("1", newState.getNumberOfParks());
    }

    @Test
    public void setPopulationReturnCorrectly() throws Exception {
        State newState = setupState();
        newState.setPopulation("6 million");
        assertNotEquals("4.093 million", newState.getPopulation());
    }









}
