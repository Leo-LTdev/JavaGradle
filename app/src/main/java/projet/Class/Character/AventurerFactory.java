package projet.Class.Character;

public class AventurerFactory {
    
    public static Aventurer CreatAventurer(int choice){
        
        AventurerBuilder factory = AventurerBuilder.create();

        switch (choice) {
            case 1:
               return factory.life(100)
                            .gear()
                            .speed(15)
                            .armor(10)
                            .attack(12)
                            .level()
                            .buildHuman();
            
            case 2:
                return factory.life(80)
                                .gear()
                                .speed(20)
                                .armor(5)
                                .attack(15)
                                .level()
                                .buildEld();
            
            case 3:
                return factory.life(120)
                            .gear()
                            .speed(10)
                            .armor(15)
                            .attack(10)
                            .level()
                            .buildDwarf();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");
        }
    }
}
