package projet.Class.Character;

import java.util.ArrayList;
import projet.Class.Object.Gear;
import projet.Class.Object.Weapon;
import projet.Class.Object.Armor;

public class Aventurer extends Character {

    private ArrayList<Object> inventory;
    private Gear gear;
    private int level;
    private int exp;

    public Aventurer() {
        super();
        this.level = 1;
        this.exp = 0;
        this.inventory = new ArrayList<Object>();
        this.gear = new Gear();
    }

    public Aventurer(int life, int speed, int armor, int attack, Gear gear, int level, int exp) {
        super(life, speed, armor, attack);
        this.gear = gear;
        this.level = level;
        this.exp = exp;
    }

    //All get
    public ArrayList<Object> getInventory() {
        return inventory;
    }

    public Gear getGear() {
        return gear;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    //All set
    protected void setIventory(Object object) {
        inventory.add(object);
    }

    @Override
    public void showStats() {
        System.out.println("Vie : " + getLife());
        System.out.println("Armure : " + getArmor());
        System.out.println("Vitesse : " + getSpeed());
        System.out.println("Attaque : " + getAttack());
        System.out.println("EXP : " + getExp());
    }

    protected boolean isDead() {
        if (getLife() <= 0) {
            return true;
        }
        return false;
    }

    protected void equipWeapon(Weapon weapon) {
        this.gear.setWeapon(weapon);
    }

    protected void equipArmor(Armor armor) {
        this.gear.setArmor(armor);
    }

    public void escape() {
        if (Math.random() < 0.3) {
            System.out.println("Vous avez réussi à fuir le combat !");
        } else {
            System.out.println("Échec de la fuite ! Vous allez affronter la réalité big noob !");
        }
    }
}
