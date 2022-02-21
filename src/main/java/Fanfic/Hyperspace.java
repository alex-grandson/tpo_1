package Fanfic;

import java.util.ArrayList;

public class Hyperspace {
    private ArrayList<Ship> ships;

    public Hyperspace() {
        this.ships = new ArrayList<Ship>();
    }

    public Hyperspace(ArrayList<Ship> ships) {
        System.out.println("Initializing hyperspace...");
        this.ships = ships;
    }

    public void addShip(Ship ship) {
        System.out.println("Ship entered hyperspace:\n" + ship.toString());
        ships.add(ship);
    }

    @Override
    public String toString() {
        return "Hyperspace{" +
                "ships=" + ships +
                '}';
    }
}
