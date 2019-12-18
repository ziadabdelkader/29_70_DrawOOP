package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;
import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class rectangle extends ShapeImp {

    public rectangle(int x,int y,double width , double height) {
        super(new Point(x,y), new HashMap<String, Double>()
        {
            {
                put("width",width);
                put("height",height);
            }
        });
    }
    public rectangle(){
        this(0,0,0.0,0.0);
    }

    @Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        ((Graphics2D)canvas).setStroke(new BasicStroke(3));
        canvas.setColor(this.getColor());
        canvas.drawRect(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
        if(this.getFillColor()!=null){
            canvas.setColor(this.getFillColor());
            canvas.fillRect(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
        }
    }

    @Override
    public boolean isInside(int x, int y) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        int TcornerX=this.getPosition().x;
        int TcornerY=this.getPosition().y;
        double BcornerX=this.getPosition().x+t.get("width");
        double BcornerY=this.getPosition().y+t.get("height");
        if(x>=TcornerX && x<=BcornerX && y>=TcornerY && y<=BcornerY){
            return true;
        }
        return false;
    }

    @Override
    public Shape resize(int x, int y) {
        Point start=this.getPosition();
        if(x<start.x || y<start.y)
            return this;

        return new rectangle(start.x,start.y,(x-start.x),(y-start.y));
    }
}
