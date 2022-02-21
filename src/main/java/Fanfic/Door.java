package Fanfic;

public class Door {

    private DoorMaterial material;
    private double durability;
    private boolean isOpen;

    public Door(DoorMaterial material, double durability, boolean isOpen) {
        this.material = material;
        this.durability = durability;
        this.isOpen = isOpen;
    }

    public DoorMaterial getMaterial() {
        return material;
    }

    public double getDurability() {
        return durability;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Door{" +
                "material=" + material +
                ", durability=" + durability +
                ", isOpen=" + isOpen +
                '}';
    }
}
