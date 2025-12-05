package projet.Class.Character;

public class Tyranide extends Monster {

    private int claws;

    public Tyranide() {
        super(50, 50, 5, 20, 20, 3);
        this.claws = 0;
    }

    public int getClaws() {
        return claws;
    }

    @Override
    public void dealDamage(Character target) {
        int damage = this.getAttack() - target.getArmor() + this.claws;
        if (damage < 0) {
            damage = 0;
        }
        target.setLife(target.getLife() - damage);

        if (target.isDead()) {
            System.out.println("Le tyrannide vous a tué !");
        } else {
            System.out.println("Le tyrannide vous attaque et vous inflige " + damage + " points de dégâts.");
            System.out.println("Il vous reste " + target.getLife() + " PV");
        }
    }
}