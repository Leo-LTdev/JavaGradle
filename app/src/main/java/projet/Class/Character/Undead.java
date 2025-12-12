package projet.Class.Character;

public class Undead extends Monster {

    private double resurractionRate;

    private Undead(int life, int speed, int armor, int attack, int xpValue, int level, double resurractionRate) {
        super(life,speed,armor,attack,xpValue,level);
        this.resurractionRate = resurractionRate;
    }

    public double getResurractionRate() {
        return resurractionRate;
    }

    public boolean isDead() {
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


    public static class UndeadBuilder {

        private int life;
        private int speed;
        private int armor;
        private int attack;
        private int xpValue;
        private int level;
        private double resurractionRate;

        public UndeadBuilder life(int life) {
            this.life = life;
            return this;
        }

        public UndeadBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public UndeadBuilder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public UndeadBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public UndeadBuilder xpValue(int xpValue) {
            this.xpValue = xpValue;
            return this;
        }

        public UndeadBuilder level(int level) {
            this.level = level;
            return this;
        }

        public UndeadBuilder resurractionRate(double resurractionRate) {
            this.resurractionRate = resurractionRate;
            return this;
        }

        public Undead build() {
            return new Undead(life, speed, armor, attack, xpValue, level, resurractionRate);
        }
    }

}