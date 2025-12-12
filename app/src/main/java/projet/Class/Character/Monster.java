package projet.Class.Character;

import projet.Class.Interface.Ideal_damage;

public abstract class Monster extends Character implements Ideal_damage {

    private int xpValue;
    private int level;

    public Monster() {
        super();
        this.xpValue = 15;
        this.level = 2;
    }

    public Monster(int life, int speed, int armor, int attack, int xpValue, int level) {
        super(life, speed, armor, attack);
        this.xpValue = xpValue;
        this.level = level;
    }

    @Override
    public void dealDamage(Character target) {
        int damage = this.getAttack() - damageReduction(target);
        if (damage < 0) {
            damage = 0;
        }
        target.setLife(target.getLife() - damage);

        if (target.isDead()) {
            System.out.println("Le monstre vous a tué : " + damage);
        } else {
            System.out.println("Le monstre vous a infligé " + damage + " dégats");
            System.out.println("Il vous reste " + target.getLife() + " PV");
        }
    }

    public int getXpvalue() {
        return xpValue;
    }
}
