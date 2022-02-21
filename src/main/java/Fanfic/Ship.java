package Fanfic;

import java.util.ArrayList;

public class Ship {

    private String name;
    private Coords coords;
    private Engine engine16V;
    private ArrayList<Cabin> cabins;

    public Ship(String name, Coords coords, Engine engine16V, ArrayList<Cabin> cabins) {
        this.name = name;
        this.coords = coords;
        this.engine16V = engine16V;
        this.cabins = cabins;
    }

    public String getName() {
        return name;
    }

    public Coords getCoords() {
        return coords;
    }

    public Engine getEngine16V() {
        return engine16V;
    }

    public ArrayList<Cabin> getCabins() {
        return cabins;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", coords=" + coords +
                ", cabins=" + cabins +
                '}';
    }
}
