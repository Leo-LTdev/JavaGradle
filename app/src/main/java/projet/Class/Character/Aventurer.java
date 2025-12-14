package projet.Class.Character;

import java.util.ArrayList;

import projet.Class.Interface.Ideal_damage;
import projet.Class.Interface.IseReposer;
import projet.Class.Object.Gear;
import projet.Class.Object.Weapon;
import projet.Class.Object.Armor;
import projet.Class.Object.Potion;

public abstract class Aventurer extends Character implements Ideal_damage, IseReposer {

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
    private void setExp(int exp) {
        this.exp = exp;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public void setInventory(Object object) {
        inventory.add(object);
    }

    @Override
    public void showStats() {
        System.out.println("Vie : " + getLife());
        System.out.println("Armure : " + getArmor());
        System.out.println("Vitesse : " + getSpeed());
        System.out.println("Attaque : " + getAttack());
        System.out.println("EXP : " + getExp());
        System.out.println("Level : " + getLevel());
    }

    public void gainExp(Monster monster) {
        int total = getExp() + monster.getXpvalue();
        setExp(total);
        if (getExp() > 100) {
            setLevel(getLevel() + 1);
            setExp(0);
            System.err.println("Vous êtes passé niveau " + getLevel());
        }
        System.err.println("Vous êtes à " + total + " EXP / 100 avant le niveau supérieur");
    }

    @Override
    public void dealDamage(Character target) {
        int totalDamage = getAttack() - damageReduction(target);
        if (totalDamage < 0) {
            totalDamage = 0;
        }
        target.takeDamage(totalDamage);

        if (target.isDead()) {
            System.out.println("Vous avez tué le monstre en infligeant : " + totalDamage);
        } else {
            System.out.println("Vous avez infligé " + totalDamage + " degat");
            System.out.println("Il reste " + target.getLife() + " PV");
        }
    }

    public void drinkPotion(Potion potion) {
        setLife(getLife() + potion.getPower());
        potion.reduceUse();
        System.out.println("Vous vous soignez de : " + potion.getPower() + " PV");

    }

    public void equipWeapon(Weapon weapon) {

        setAttack(getAttack() - getGear().getWeapon().getPower());
        getInventory().add(getGear().getWeapon());

        getGear().setWeapon(weapon);

        int index = this.getInventory().indexOf(weapon);
        getInventory().remove(index);

        int totalAtk = getAttack() + weapon.getPower();
        setAttack(totalAtk);

        System.out.println("Vous equipez " + weapon.getName());
    }

    public void equipArmor(Armor armor) {

        setArmor(getArmor() - getGear().getArmor().getPower());
        getInventory().add(getGear().getArmor());

        getGear().setArmor(armor);

        int index = this.getInventory().indexOf(armor);
        getInventory().remove(index);

        int totalArmor = getArmor() + armor.getPower();
        setArmor(totalArmor);

        System.out.println("Vous equipez " + armor.getName());
    }

    public boolean escape() {
        if (Math.random() < 0.3) {
            System.out.println("Vous avez réussi à fuir le combat !");
            return true;
        } else {
            System.out.println("Échec de la fuite ! Vous allez affronter la réalité big noob !");
            return false;
        }
    }

    @Override
    public void seReposer() {
        this.setLife(getLife() + 20);
        System.out.println("Vous avez pu vous reposer et récupérer 20 points de vie !");
    }
}
