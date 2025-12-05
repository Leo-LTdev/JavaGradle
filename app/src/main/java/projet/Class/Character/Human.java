package projet.Class.Character;

public class Human extends Aventurer {
    

    public Human(){
        super();
    }



    private Human(Builder builder) {
        this.setLife(builder.life);
        this.setMaxLife(builder.maxLife);
        this.setSpeed(builder.speed);
        this.setArmor(builder.armor);
        this.setAttack(builder.attack);
    }


    public static class Builder {
        private int life;
        private int maxLife;
        private int speed;
        private int armor;
        private int attack;

        public Builder life(int value) {
            this.life = value;
            this.maxLife = value;
            return this;
        }

        public Builder speed(int value) {
            this.speed = value;
            return this;
        }

        public Builder armor(int value) {
            this.armor = value;
            return this;
        }

        public Builder attack(int value) {
            this.attack = value;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }


}
