package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;

public class line extends ShapeImp{
	 public line(int x1,int y1,int x2,int y2) {
	        super(new Point(x1,y1), new HashMap<String, Double>()
	        {
	            {
	                put("x2",(double)x2);
	                put("y2",(double)y2);
	            }
	        });
	    }
	 @Override
	    public void draw(Graphics canvas) {
	        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
	        canvas.drawLine(this.getPosition().x,this.getPosition().y,t.get("x2").intValue(),t.get("y2").intValue());
	    }
}
