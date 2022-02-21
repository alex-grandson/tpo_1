package fanfic;

import java.util.ArrayList;

public class Cabin {

    private Door door;
    private ArrayList<Person> people;
    private int monkeys;
    private int cabinNumber;

    public Cabin(Door door, ArrayList<Person> people, int monkeys, int cabinNumber) {
        this.door = door;
        this.people = people;
        this.monkeys = monkeys;
        this.cabinNumber = cabinNumber;
    }

    public boolean rushCabin(int monkeysCount) {
        System.out.println("Cabin " + this.cabinNumber + " is rushing by " + monkeysCount + " monkey(s)");
        this.monkeys = monkeysCount;
        if (this.monkeys > this.door.getDurability() || this.door.isOpen()) {
            System.out.println("Monkeys rushed cabin");
            this.door.setOpen(true);
            return true;
        } else {
            System.out.println("Monkeys lost this time");
        }
        return false;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

}
