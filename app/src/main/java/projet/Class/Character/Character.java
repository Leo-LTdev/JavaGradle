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
    public void dealDamage(Character target){
        int totalDmg = this.attack - target.armor; 
        target.setLife(target.life - totalDmg);

        if (target.isDead()){
            System.out.println("Vous avez tuer votre énemie");
        } else {
            System.out.println("Vous avez infligé " + totalDmg + " degat");
            System.out.println("Il reste " + target.getLife() + " PV");
        }
    }

    protected boolean isDead(){
        if (this.life <= 0) {
            return true;
        }
        return false;
    }


}
