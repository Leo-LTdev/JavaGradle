package projet.Class.Object;

public abstract class Object {
    private String name;
    private int power;


    public Object(){};

    public Object(String name,int power){
        this.name = name;
        this.power = power;
    }

    public String getName(){return name;}
    public int getPower(){return power;}

    protected void setName(String name){this.name = name;}
    protected void setPower(int power){this.power = power;}
    
}
