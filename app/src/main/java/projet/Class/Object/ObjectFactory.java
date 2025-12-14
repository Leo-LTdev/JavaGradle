package projet.Class.Object;


public class ObjectFactory {

    public static Weapon CreateSword(int choice){
    
        ObjectBuilder factory = ObjectBuilder.create();
    
        switch (choice) {
            case 0:
               return factory.name("Wooden Sword")
                            .power(10)
                            .buildWeapon();
            
            case 1:
                return factory.name("Iron Sword")
                            .power(20)
                            .buildWeapon();
            
            case 2:
                return factory.name("Diamond Sword")
                            .power(30)
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
                            .power(10)
                            .buildArmor();
            
            case 1:
                return factory.name("Leather Armor")
                            .power(20)
                            .buildArmor();
            
            case 2:
                return factory.name("Iron Armor")
                            .power(30)
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
                            .power(30)
                            .nbOfUse(3)
                            .buildPotion();
            
            case 1:
                return factory.name("Normal Potion")
                            .power(60)
                            .nbOfUse(2)
                            .buildPotion();
            
            case 2:
                return factory.name("Heavy Potion")
                            .power(100)
                            .nbOfUse(1)
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
