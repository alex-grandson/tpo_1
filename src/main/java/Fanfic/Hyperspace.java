package Fanfic;

import java.util.ArrayList;

public class Hyperspace {
    private ArrayList<Ship> ships;

    public Hyperspace(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }
}
