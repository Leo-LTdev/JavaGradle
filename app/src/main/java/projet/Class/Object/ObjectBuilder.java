package projet.Class.Object;

public class ObjectBuilder {

    private static ObjectBuilder INSTANCE;

    private String name;
    private int power;

    public String getName(){return name;}
    public int getPower(){return power;}

    private ObjectBuilder(){};

    public static ObjectBuilder create(){
        INSTANCE = new ObjectBuilder();{
            return INSTANCE;
        }
    }

    public static ObjectBuilder getInstance(){return INSTANCE;}

    public ObjectBuilder name(String value){this.name = value; return this;}
    public ObjectBuilder power(int value){this.power = value; return this;}
    public Weapon buildWeapon(){return new Weapon(this);}
    public Armor buildArmor(){return new Armor(this);}
    
}
