package models;

import java.util.Objects;


public class Park {
    private String name;
    private String terrain;
    private String visits;
    private String resize;
    private int id;

    public Park(String name, String terrain, String visits, String resize) {
        this.name = name;
        this.terrain = terrain;
        this.visits = visits;
        this.resize = resize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getResize() {
        return resize;
    }

    public void setResize(String resize) {
        this.resize = resize;
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
        Park park = (Park) o;
        return id == park.id &&
                Objects.equals(name, park.name) &&
                Objects.equals(terrain, park.terrain) &&
                Objects.equals(visits, park.visits) &&
                Objects.equals(resize, park.resize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, terrain, visits, resize, id);
    }
}

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Park park = (Park) o;
//
//        if (id != park.id) return false;
//        if (!name.equals(park.name)) return false;
//        if (peak != null ? !peak.equals(park.peak) : park.peak != null) return false;
//        if (size != null ? !size.equals(park.size) : park.size != null) return false;
//        if (terrain != null ? !terrain.equals(park.terrain) : park.terrain != null) return false;
//        if (visits != null ? !visits.equals(park.visits) : park.visits != null) return false;
//        return resize != null ? resize.equals(park.resize) : park.resize == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + (peak != null ? peak.hashCode() : 0);
//        result = 31 * result + (size != null ? size.hashCode() : 0);
//        result = 31 * result + (terrain != null ? terrain.hashCode() : 0);
//        result = 31 * result + (visits != null ? visits.hashCode() : 0);
//        result = 31 * result + (resize != null ? resize.hashCode() : 0);
//        result = 31 * result + id;
//        return result;
//    }

