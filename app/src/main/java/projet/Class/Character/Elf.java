package projet.Class.Character;

public class Elf extends Aventurer {

    public Elf(){
        
    }

    public Elf(AventurerBuilder builder) {
        this.setLife(builder.getLife());
        this.setMaxLife(builder.getMaxLife());
        this.setSpeed(builder.getSpeed());
        this.setArmor(builder.getArmor());
        this.setAttack(builder.getAttack());
    }
}