package fanfic;

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

        System.out.println("Ready... Steady... Go... " + this.toString());
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
