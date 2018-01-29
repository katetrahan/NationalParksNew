package dao;

import models.Tip;

import java.util.List;


public interface TipDao {

    //create
    void add(Tip tip);
    //read

//    List<Tip> getAll();

    List<Tip> getAllTipsByPark(int parkId);

    //update
    //delete
    void deleteById(int id);




}
