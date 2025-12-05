package projet.Class.Object;

public class Weapon extends Object {
    String name;
    int power;


    public Weapon(){
        this.name = "hache";
        this.power = 15;
    }

    public Weapon(String name, int power){
        this.name = name;
        this.power = power;
    }
    
}
