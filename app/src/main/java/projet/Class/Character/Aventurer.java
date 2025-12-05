package projet.Class.Character;

import java.util.ArrayList;
import projet.Class.Object.Gear;
import projet.Class.Object.Weapon;
import projet.Class.Object.Armor;


public abstract class Aventurer extends Character {
    private ArrayList<Object> inventory;
    private Gear gear;
    private int level;
    private int exp;

    public Aventurer(){
        super();
        this.level = 1;
        this.exp = 0;
        this.inventory = new ArrayList<Object>();
        this.gear = new Gear();
    }

    public Aventurer(int life, int speed, int armor, int attack,Gear gear, int level, int exp){
        super(life,speed,armor,attack);
        this.gear = gear;
        this.level = level;
        this.exp = exp;
    }

    //All get
    public ArrayList<Object> getInventory(){
        return inventory;
    }

    public Gear getGear(){
        return gear;
    }

    public int getLevel(){
        return level;
    }

    public int getExp(){
        return exp;
    }

    //All set
    protected void setIventory(Object object){
        inventory.add(object);
    }



    //Methode

    protected void equipWeapon(Weapon weapon){
        this.gear.setWeapon(weapon);
    }

    protected void equipArmor(Armor armor){
        this.gear.setArmor(armor);
    }


}
