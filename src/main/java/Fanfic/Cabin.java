package Fanfic;

import java.util.ArrayList;

public class Cabin {

    private Door door;
    private ArrayList<Person> people;
    private ArrayList<Monkey> monkeys;
    private int cabinNumber;

    public Cabin(Door door, ArrayList<Person> people, ArrayList<Monkey> monkeys, int cabinNumber) {
        this.door = door;
        this.people = people;
        this.monkeys = monkeys;
        this.cabinNumber = cabinNumber;
    }

    public Door getDoor() {
        return door;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Monkey> getMonkeys() {
        return monkeys;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void setMonkeys(ArrayList<Monkey> monkeys) {
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
