package projet.Class.Character;

public class Human extends Aventurer {
    

    public Human(){
        super();
    }



    public Human(AventurerBuilder builder) {
        this.setLife(builder.getLife());
        this.setMaxLife(builder.getMaxLife());
        this.setSpeed(builder.getSpeed());
        this.setArmor(builder.getArmor());
        this.setAttack(builder.getAttack());
    }


}
