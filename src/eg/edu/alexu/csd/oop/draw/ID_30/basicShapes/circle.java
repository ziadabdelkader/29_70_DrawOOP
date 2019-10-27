package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.*;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;

public class circle extends ShapeImp{
	public circle(int x,int y,double radius) {
        super(new Point(x,y), new HashMap<String, Double>()
        {
            {
                put("radius",radius);
            }
        });
	}
	@Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        canvas.setColor(this.getColor());

        ((Graphics2D)canvas).setStroke(new BasicStroke(10));
        canvas.drawOval(this.getPosition().x, this.getPosition().y, t.get("radius").intValue(), t.get("radius").intValue());
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x, this.getPosition().y, t.get("radius").intValue(), t.get("radius").intValue());

    }
}
