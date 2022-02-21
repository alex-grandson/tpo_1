package Fanfic;

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

    public void rushCabin(int monkeysCount) {
        System.out.println("Cabin " + this.cabinNumber + " is rushing by " + monkeysCount + " monkey(s)");
        this.monkeys = monkeysCount;
        if (this.monkeys > this.door.getDurability() || this.door.isOpen()) {
            System.out.println("Monkeys rushed cabin");
            this.door.setOpen(true);
        } else {
            System.out.println("Monkeys lost this time");
        }
    }

    public Door getDoor() {
        return door;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public int getMonkeys() {
        return monkeys;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void setMonkeys(int monkeys) {
        this.monkeys = monkeys;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Cabin {" +
                "cabinNumber=" + cabinNumber +
                ", door=" + door +
                ", people=" + people +
                ", monkeys=" + monkeys +
                '}';
    }
}
