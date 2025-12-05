package projet.Class.Character;

public abstract class Monster extends Character {
    private int xpValue;
    private int level;


    public Monster() {
        super();
        this.xpValue = 15;
        this.level = 2;
    }

    public Monster(int life, int speed, int armor, int attack, int xpValue, int level) {
        super(life,speed,armor,attack);
        this.xpValue = xpValue;
        this.level = level;
    }

}
