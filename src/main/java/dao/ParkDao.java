package dao;

import models.*;

import java.util.List;

public interface ParkDao {

    //create
    void add(Park park);
//    void addParktoState(Park park, State state);

    //read
    List<Park> getAll();
   List<State> getAllStatesForAPark(int id); //few but SOME instances where a national park is in multiple states



    //update
//    void update(int id, String name, String peak, String size, String terrain, String visits, String resize);

    //delete
    void deleteById(int id);


}


