package eg.edu.alexu.csd.oop.draw.ID_30;

import eg.edu.alexu.csd.oop.draw.Shape;

public class operation {
    private int type;
    private Shape s1;
    private Shape s2;
    public operation(int type,Shape s1,Shape s2){
        this.type=type;
        this.s1=s1;
        if(s2!=null) this.s2=s2;
    }

    public int getType() {
        return type;
    }

    public Shape getS1() {
        return s1;
    }

    public Shape getS2() {
        return s2;
    }
}
