package fanfic;

import java.util.ArrayList;
import java.util.List;

public class Hyperspace {
    private final List<Ship> ships = new ArrayList<>();

    public boolean addShip(Ship ship) {
        System.out.println("Ship entered hyperspace");
        return ships.add(ship);
    }

    public int getShipsCount() {
        return ships.size();
    }

}
