package projet.Class.Object;

public class Gear {
    private Weapon weapon;
    private Armor armor;


    public Gear(){
        this.setWeapon(ObjectFactory.CreateSword(1));
        this.setArmor(ObjectFactory.CreateAmor(1));
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
