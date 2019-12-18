package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;
import eg.edu.alexu.csd.oop.draw.Shape;

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
	    public line(){
			this(0,0,0,0);
		}

	 @Override
	    public void draw(Graphics canvas) {
	        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
		 ((Graphics2D)canvas).setStroke(new BasicStroke(3));
		 canvas.setColor(this.getColor());
		 canvas.drawLine(this.getPosition().x,this.getPosition().y,t.get("x2").intValue(),t.get("y2").intValue());
	    }

	@Override
	public boolean isInside(int x, int y) {
		int x1=this.getPosition().x;
		int y1=this.getPosition().y;
		HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
		int x2=t.get("x2").intValue();
		int y2=t.get("y2").intValue();
	 	if(Math.abs(Point2D.distance(x1,y1,x2,y2)-Point2D.distance(x,y,x2,y2)-Point2D.distance(x1,y1,x,y))<3) {
			return true;
		}
		return false;
	}

	@Override
	public Shape resize(int x, int y) {
		Point start=this.getPosition();
		return new line(start.x,start.y,x,y);
	}

	@Override
	public Shape move(int x1, int y1, int x2, int y2) {
		Point start=this.getPosition();
		HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
		int Ox2=t.get("x2").intValue();
		int Oy2=t.get("y2").intValue();

		return new line(start.x+(x2-x1),start.y+(y2-y1),Ox2+(x2-x1),Oy2+(y2-y1));
	}
}
