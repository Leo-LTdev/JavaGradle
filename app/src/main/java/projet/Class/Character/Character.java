package projet.Class.Character;

public abstract class Character {

    private int life;
    private int maxLife;
    private int speed;
    private int armor;
    private int attack;


    public Character(){
        this.life = 100;
        this.maxLife = 100;
        this.speed = 25;
        this.armor = 30;
        this.attack = 40;
    }

    public Character(int life, int speed, int armor, int attack){
        this.life = life;
        this.maxLife = life;
        this.speed = speed;
        this.armor = armor;
        this.attack = attack;
    }
    
    //All get
    public int getLife(){
        return life;
    }

    public int getmaxLife(){
        return maxLife;
    }

    public int getSpeed(){
        return speed;
    }

    public int getArmor(){
        return armor;
    }

    public int getAttack(){
        return attack;
    }


    //All set
    protected void setLife(int life){
        this.life = life;
    }

    protected void setMaxLife(int life){
        this.maxLife = life;
    }

    protected void setSpeed(int speed){
        this.speed = speed;
    }

    protected void setArmor(int armor){
        this.armor = armor;
    }

    protected void setAttack(int attack){
        this.attack = attack;
    }


    // Méthode
    public int damageReduction(Character target){
        return Math.round((this.getAttack() * target.getArmor()) / 100);
    }
    
    public abstract void dealDamage(Character target);
        // int damage = this.getAttack() - damageReduction(target);
        // if (damage < 0) {
        //     damage = 0;
        // }
        // target.setLife(target.getLife() - damage);

        // if (target.isDead()){
        //     System.out.println("Vous avez tuer votre énemie en infligent : " + damage);
        // } else {
        //     System.out.println("Vous avez infligé " + damage + " degat");
        //     System.out.println("Il reste " + target.getLife() + " PV");
        // }

    public void takeDamage(int damage){
        this.setLife(getLife() - damage);
    }
    

    public void showStats() {
        System.out.println("Vie : " + getLife());
        System.out.println("Armure : " + getArmor());
        System.out.println("Vitesse : " + getSpeed());
        System.out.println("Attaque : " + getAttack());
    }

    public boolean isDead(){
        if (getLife() <= 0) {
            return true;
        }
        return false;
    }

}
