package projet.Class.Object;

public class Weapon extends Item {

    public Weapon() {
    }

    public Weapon(ObjectBuilder builder) {
        this.setName(builder.getName());
        this.setPower(builder.getPower());
    }

}
