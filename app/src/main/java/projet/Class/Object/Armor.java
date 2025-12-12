package projet.Class.Object;

public class Armor extends Object {

    public Armor(){}

    public Armor(ObjectBuilder builder){
        this.setName(builder.getName());
        this.setPower(builder.getPower());
    }
    

}
