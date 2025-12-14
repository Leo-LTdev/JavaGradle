package projet.Class.Character;

public class AventurerFactory {
    
    public static Aventurer CreatAventurer(int choice){
        
        AventurerBuilder factory = AventurerBuilder.create();

        switch (choice) {
            case 1:
               return factory.life(100)
                            .gear()
                            .speed(25)
                            .armor(10)
                            .attack(35)
                            .level()
                            .buildHuman();
            
            case 2:
                return factory.life(80)
                                .gear()
                                .speed(40)
                                .armor(10)
                                .attack(40)
                                .level()
                                .buildEld();
            
            case 3:
                return factory.life(5555)
                            .gear()
                            .speed(20)
                            .armor(25)
                            .attack(35)
                            .level()
                            .buildDwarf();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");
        }
    }
}
