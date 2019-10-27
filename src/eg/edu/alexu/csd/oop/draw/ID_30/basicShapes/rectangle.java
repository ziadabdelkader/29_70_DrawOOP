package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;

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

    @Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        canvas.setColor(this.getColor());

        ((Graphics2D)canvas).setStroke(new BasicStroke(10));
        canvas.drawRect(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
        canvas.setColor(this.getFillColor());
        canvas.fillRect(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
    }

}
