package fanfic;

public class Door {

    private DoorMaterial material;
    private double durability;
    private boolean isOpen;

    public Door(DoorMaterial material, double durability, boolean isOpen) {
        this.material = material;
        this.durability = durability;
        this.isOpen = isOpen;
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

}
