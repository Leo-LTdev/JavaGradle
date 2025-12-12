package projet.Class.Object;

public class Armor extends Object {
    String name;
    int protection;


    public Armor(){}

    public Armor(NotCusumBuilder builder){
        this.setName(builder.getName());
        this.setPower(builder.getPower());
    }
    

}
