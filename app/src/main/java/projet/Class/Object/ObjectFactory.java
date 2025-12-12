package projet.Class.Object;

import java.util.GregorianCalendar;

public class ObjectFactory {

    public static Weapon CreateSword(int choice){
    
        NotCusumBuilder factory = NotCusumBuilder.create();
    
        switch (choice) {
            case 1:
               return factory.name("Wooden Sword")
                            .power(5)
                            .buildWeapon();
            
            case 2:
                return factory.name("Iron Sword")
                            .power(10)
                            .buildWeapon();
            
            case 3:
                return factory.name("Diamond Sword")
                            .power(15)
                            .buildWeapon();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");
        }
    
    }


    public static Armor CreateAmor(int choice){
        NotCusumBuilder factory = NotCusumBuilder.create();
    
        switch (choice) {
            case 1:
               return factory.name("Cloth Armor")
                            .power(5)
                            .buildArmor();
            
            case 2:
                return factory.name("Leather Armor")
                            .power(10)
                            .buildArmor();
            
            case 3:
                return factory.name("Iron Armor")
                            .power(15)
                            .buildArmor();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");

        }

    }

    public static Gear baseGear(){
        Gear gear = new Gear();
        return gear;
    }
}
