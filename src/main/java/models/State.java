package models;

import java.util.Objects;


public class State {

    private String name;
    private String numberOfParks;
    private String population;
    private int id;

    public State(String name, String numberOfParks, String population) {
        this.name = name;
        this.numberOfParks = numberOfParks;
        this.population = population;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfParks() {
        return numberOfParks;
    }

    public void setNumberOfParks(String numberOfParks) {
        this.numberOfParks = numberOfParks;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (id != state.id) return false;
        if (!name.equals(state.name)) return false;
        if (numberOfParks != null ? !numberOfParks.equals(state.numberOfParks) : state.numberOfParks != null)
            return false;
        return population != null ? population.equals(state.population) : state.population == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (numberOfParks != null ? numberOfParks.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
