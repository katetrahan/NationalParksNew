package dao;

import models.*;
import java.util.List;

public interface StateDao {
    //create
    void add(State state);
//    void addStateToPark(State state, Park park);


    //read
    List<State> getAll();
    List<Park> getAllParksForAState(int stateId);

    State findById(int id);

    //update
    void update(int id, String name, String numberOfParks, String population);

    //delete
    void deleteById(int id);


}
