package projet.Class.Character;

public class Orc extends Monster {

    private double height;

    public Orc() {
        super(120, 30, 40, 50, 20, 5);
        this.height = 2.5;
    }

    public double getHeight() {
        return height;
    }

}