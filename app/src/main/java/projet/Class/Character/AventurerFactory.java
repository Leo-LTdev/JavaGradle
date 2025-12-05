package projet.Class.Character;

public class AventurerFactory {
    
    public static Aventurer CreatAventurer(int choice){
        switch (choice) {
            case 1:
               return new Human.Builder();
            
            case 2:
                return new Elf();
            
            case 3:
                return new Dwarf();
        
            default:
                throw new IllegalArgumentException("erreur vous n'avez pas choisi un aventurier");
        }
    }
}
