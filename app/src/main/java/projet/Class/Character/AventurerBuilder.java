package projet.Class.Character;

import projet.Class.Object.Gear;

public class AventurerBuilder {   
    
    private static AventurerBuilder INSTANCE;
    private int life;
    private int maxLife;
    private int speed;
    private int armor;
    private int attack;
    private int level;
    private int exp;
    private Gear gear;

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
    public int getLevel(){return level;}
    public int getExp(){return exp;}
    public Gear getGear(){return gear;}


    public AventurerBuilder life(int value) {this.life = value; this.maxLife = value; return this;}
    public AventurerBuilder speed(int value) {this.speed = value; return this;}
    public AventurerBuilder armor(int value) {this.armor = value + this.gear.getArmor().getPower(); return this;}
    public AventurerBuilder attack(int value) {this.attack = value + this.gear.getWeapon().getPower(); return this;}
    public AventurerBuilder level(){this.level = 1; return this;}
    public AventurerBuilder gear(){this.gear = new Gear(); return this;}
    public Human buildHuman() {return new Human(this);}
    public Elf buildEld() {return new Elf(this);}
    public Dwarf buildDwarf() {return new Dwarf(this);}
    
    
}
