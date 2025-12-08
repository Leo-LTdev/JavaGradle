package projet.Class.Character;

public class AventurerBuilder {   
    
    private static AventurerBuilder INSTANCE;
    private int life;
    private int maxLife;
    private int speed;
    private int armor;
    private int attack;

    private AventurerBuilder(){};

    public static AventurerBuilder create(){
        INSTANCE = new AventurerBuilder();{
            return INSTANCE;
        }
    }

    public static AventurerBuilder getInstance(){return INSTANCE;}


    public int getLife(){return life;}
    public int getMaxLife(){return maxLife;}
    public int getSpeed(){return speed;}
    public int getArmor(){return armor;}
    public int getAttack(){return attack;}


    public AventurerBuilder life(int value) {this.life = value; this.maxLife = value; return this;}
    public AventurerBuilder speed(int value) {this.speed = value; return this;}
    public AventurerBuilder armor(int value) {this.armor = value; return this;}
    public AventurerBuilder attack(int value) {this.attack = value; return this;}
    public Human buildHuman() {return new Human(this);}
    public Elf buildEld() {return new Elf(this);}
    public Dwarf buildDwarf() {return new Dwarf(this);}
    
    
}
