package projet.Class.Object;

public class Gear {
    private Weapon weapon;
    private Armor armor;


    public Gear(){
        weapon = new Weapon();
        armor = new Armor();
    }


    //All get
    public Weapon getWeapon(){
        return weapon;
    }

    public Armor getAmor(){
        return armor;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }
}
