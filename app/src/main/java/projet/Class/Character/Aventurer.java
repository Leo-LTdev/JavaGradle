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

    private void setExp(int exp){
        this.exp = exp;
    }

    //All set
    protected void setIventory(Object object){
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

    protected void gainExp(Monster monster){
        int total = getExp() + monster.getXpvalue();
        setExp(total);
    }

    public void dealDamage(Character target){
        int totalDamage = getAttack() - damageReduction(target);
        if (totalDamage < 0) {
            totalDamage = 0;
        }
        target.takeDamage(totalDamage);

        if (target.isDead()){
            System.out.println("Vous avez tué le monstre en infligeant : " + totalDamage);
        } else {
            System.out.println("Vous avez infligé " + totalDamage + " degat");
            System.out.println("Il reste " + target.getLife() + " PV");
        }
    }

    protected void equipWeapon(Weapon weapon){
        
        setAttack(getAttack() - getGear().getWeapon().getPower());
        getInventory().add(getGear().getWeapon());
        
        getGear().setWeapon(weapon);
        
        int index = this.getInventory().indexOf(weapon);
        getInventory().remove(index);

        int totalAtk = getAttack() + weapon.getPower();
        setAttack(totalAtk);
    }

    protected void equipArmor(Armor armor){

        setAttack(getArmor() - getGear().getAmor().getPower());
        getInventory().add(getGear().getAmor());
        
        getGear().setArmor(armor);
        
        int index = this.getInventory().indexOf(armor);
        getInventory().remove(index);

        int totalAtk = getArmor() + armor.getPower();
        setAttack(totalAtk);
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
}
