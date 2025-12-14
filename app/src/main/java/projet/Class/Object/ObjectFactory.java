package projet.Class.Object;


public class ObjectFactory {

    public static Weapon CreateSword(int choice){
    
        ObjectBuilder factory = ObjectBuilder.create();
    
        switch (choice) {
            case 0:
               return factory.name("Wooden Sword")
                            .power(5)
                            .buildWeapon();
            
            case 1:
                return factory.name("Iron Sword")
                            .power(10)
                            .buildWeapon();
            
            case 2:
                return factory.name("Diamond Sword")
                            .power(15)
                            .buildWeapon();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");
        }
    
    }


    public static Armor CreateArmor(int choice){
        ObjectBuilder factory = ObjectBuilder.create();
    
        switch (choice) {
            case 0:
               return factory.name("Cloth Armor")
                            .power(5)
                            .buildArmor();
            
            case 1:
                return factory.name("Leather Armor")
                            .power(10)
                            .buildArmor();
            
            case 2:
                return factory.name("Iron Armor")
                            .power(15)
                            .buildArmor();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");

        }

    }

    public static Potion createPotion(int choice){
        ObjectBuilder factory = ObjectBuilder.create();
    
        switch (choice) {
            case 0:
               return factory.name("Ligth Potion")
                            .power(35)
                            .nbOfUse(2)
                            .buildPotion();
            
            case 1:
                return factory.name("Normal Potion")
                            .power(55)
                            .nbOfUse(1)
                            .buildPotion();
            
            case 2:
                return factory.name("Heavy Potion")
                            .power(80)
                            .nbOfUse(2)
                            .buildPotion();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");

        }

    }

    public static Gear baseGear(){
        Gear gear = new Gear();
        return gear;
    }
}
