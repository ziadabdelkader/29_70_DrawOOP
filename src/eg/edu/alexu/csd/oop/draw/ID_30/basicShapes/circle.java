package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.*;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;
import eg.edu.alexu.csd.oop.draw.Shape;

public class circle extends ShapeImp{
	// take center point and radius
    public circle(int x,int y,double radius) {
        super(new Point(x,y), new HashMap<String, Double>()
        {
            {
                put("radius",radius);
            }
        });
	}
	public circle(){
        this(0,0,0.0);
    }
	@Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        int r=t.get("radius").intValue();
        ((Graphics2D)canvas).setStroke(new BasicStroke(3));
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x-r, this.getPosition().y-r, 2*r, 2*r);
        if(this.getFillColor()!=null){
            canvas.setColor(this.getFillColor());
            canvas.fillOval(this.getPosition().x-r, this.getPosition().y-r, 2*r, 2*r);
        }
    }

    @Override
    public boolean isInside(int x, int y) {
        int centerX=this.getPosition().x;
        int centerY=this.getPosition().y;
        int r=this.getProperties().get("radius").intValue();
        if(Math.pow(x-centerX,2)+Math.pow(y-centerY,2) <= Math.pow(r,2))
            return true;
        return false;
    }

    @Override
    public Shape resize(int x, int y) {

        Point start=this.getPosition();
        return new circle(start.x,start.y,Math.sqrt(Math.pow(start.x-x,2)+Math.pow(start.y-y,2)));
    }
}
