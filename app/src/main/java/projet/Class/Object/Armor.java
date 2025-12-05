package projet.Class.Object;

public class Armor extends Object {
    String name;
    int protection;


    public Armor(){
        this.name = "armure de fer";
        this.protection = 25;
    }

    public Armor(String name, int protection){
        this.name = name;
        this.protection = protection;
    }
    
}
