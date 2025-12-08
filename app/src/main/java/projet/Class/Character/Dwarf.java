package projet.Class.Character;

public class Dwarf extends Aventurer {
    
    public Dwarf(){
        
    }

    public Dwarf(AventurerBuilder builder) {
        this.setLife(builder.getLife());
        this.setMaxLife(builder.getMaxLife());
        this.setSpeed(builder.getSpeed());
        this.setArmor(builder.getArmor());
        this.setAttack(builder.getAttack());
    }

}
