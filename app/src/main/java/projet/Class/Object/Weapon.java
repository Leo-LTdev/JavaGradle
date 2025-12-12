package projet.Class.Object;

public class Weapon extends Object {

    public Weapon(){
    }

    public Weapon(ObjectBuilder builder) {
        this.setName(builder.getName());
        this.setPower(builder.getPower());
    }

}
