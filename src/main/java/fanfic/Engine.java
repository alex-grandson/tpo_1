package fanfic;

public class Engine {

    private final double HP;
    private final double volume;
    private final double consumption;

    public Engine(double HP, double volume, double consumption) {
        this.HP = HP;
        this.volume = volume;
        this.consumption = consumption;
    }

    public double getHP() {
        return HP;
    }

    public double getVolume() {
        return volume;
    }

    public double getConsumption() {
        return consumption;
    }
}
