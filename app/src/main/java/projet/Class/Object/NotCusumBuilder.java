package projet.Class.Object;

public class NotCusumBuilder {

    private static NotCusumBuilder INSTANCE;

    private String name;
    private int power;

    public String getName(){return name;}
    public int getPower(){return power;}

    private NotCusumBuilder(){};

    public static NotCusumBuilder create(){
        INSTANCE = new NotCusumBuilder();{
            return INSTANCE;
        }
    }

    public static NotCusumBuilder getInstance(){return INSTANCE;}

    public NotCusumBuilder name(String value){this.name = value; return this;}
    public NotCusumBuilder power(int value){this.power = value; return this;}
    public Weapon buildWeapon(){return new Weapon(this);}
    public Armor buildArmor(){return new Armor(this);}
    
}
