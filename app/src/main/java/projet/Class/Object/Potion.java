package projet.Class.Object;

public class Potion extends Item {

    private int nbOfUse;

    public int getNbOfUse() {
        return nbOfUse;
    }

    protected void setNbOfUse(int nbOfUse) {
        this.nbOfUse = nbOfUse;
    }

    public void reduceUse() {
        setNbOfUse(getNbOfUse() - 1);
    }

    public Potion(ObjectBuilder builder) {
        this.setName(builder.getName());
        this.setPower(builder.getPower());
        this.setNbOfUse(builder.getNbOfUse());
    }

}
