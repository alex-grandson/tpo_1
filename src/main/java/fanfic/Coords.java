package fanfic;

public class Coords {
    private double x;
    private double y;
    private double z;

    public Coords(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
