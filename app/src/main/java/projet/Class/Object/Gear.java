package projet.Class.Object;

public class Gear {
    private Weapon weapon;
    private Armor armor;


    public Gear(){
        this.setWeapon(ObjectFactory.CreateSword(0));
        this.setArmor(ObjectFactory.CreateArmor(0));
    }


    //All get
    public Weapon getWeapon(){
        return weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }


    


}
