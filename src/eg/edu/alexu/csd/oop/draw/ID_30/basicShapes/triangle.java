package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;

public class triangle extends ShapeImp{
	public triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super(new Point(x1,y1), new HashMap<String, Double>()
        {
            {
                put("x2",(double)x2);
                put("y2",(double)y2);
                put("x3",(double)x3);
                put("y3",(double)y3);
            }
        });
    }

    @Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        canvas.drawLine(this.getPosition().x,this.getPosition().y,t.get("x2").intValue(),t.get("y2").intValue());
        canvas.drawLine(this.getPosition().x,this.getPosition().y,t.get("x3").intValue(),t.get("y3").intValue());
        canvas.drawLine(t.get("x3").intValue(),t.get("y3").intValue(),t.get("x2").intValue(),t.get("y2").intValue());
    }
}
