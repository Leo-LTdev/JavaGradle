package projet.Class.Character;

public class Undead extends Monster {

    private double resurractionRate;

    public Undead() {
        super(100, 100, 20, 10, 15, 1);
        this.resurractionRate = 0.5;
    }

    public double getResurractionRate() {
        return resurractionRate;
    }

    @Override
    protected boolean isDead() {
        if (Math.random() < this.resurractionRate) {
            resurrect();
            return false;
        } else {
            return super.isDead();
        }
    }

    private void resurrect() {
        System.out.println("The undead is reviving, you need to kill him again !");
        int curentLife = getLife();
        int maxLife = getmaxLife();
        curentLife = maxLife / 2;
        setLife(curentLife);
    }

}