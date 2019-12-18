package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.draw.ID_30.ShapeImp;
import eg.edu.alexu.csd.oop.draw.Shape;

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
    public triangle(){
        this(0,0,0,0,0,0);
    }

    @Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        Polygon tri=new Polygon();
        tri.addPoint(this.getPosition().x,this.getPosition().y);
        tri.addPoint(t.get("x2").intValue(),t.get("y2").intValue());
        tri.addPoint(t.get("x3").intValue(),t.get("y3").intValue());
        ((Graphics2D)canvas).setStroke(new BasicStroke(3));
        canvas.setColor(this.getColor());
        canvas.drawPolygon(tri);
        if(this.getFillColor()!=null){
            canvas.setColor(this.getFillColor());
            canvas.fillPolygon(tri);
        }
    }

    @Override
    public boolean isInside(int x, int y) {
        int x1=this.getPosition().x;
        int y1=this.getPosition().y;
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        int x2=t.get("x2").intValue();
        int y2=t.get("y2").intValue();
        int x3=t.get("x3").intValue();
        int y3=t.get("y3").intValue();

        double A = area (x1, y1, x2, y2, x3, y3);
        double A1 = area (x, y, x2, y2, x3, y3);
        double A2 = area (x1, y1, x, y, x3, y3);
        double A3 = area (x1, y1, x2, y2, x, y);
        if(Math.abs(A1+A2+A3-A)<Math.pow(10,-1))
            return true;
        return false;
    }

    @Override
    public Shape resize(int x, int y) {
        double cons=Math.pow(10,-1);

        Point start=this.getPosition();
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        int x2=t.get("x2").intValue();
        int y2=t.get("y2").intValue();
        int x3=t.get("x3").intValue();
        int y3=t.get("y3").intValue();
        double L1= Point2D.distance(x,y,start.x,start.y);
        double L2= Point2D.distance(x,y,x2,y2);
        double L3= Point2D.distance(x,y,x3,y3);
        double minL=Math.min(L1,Math.min(L2,L3));
        if(Math.abs(L1-minL)<cons){
            return new triangle(x,y,x2,y2,x3,y3);
        }else if(Math.abs(L2-minL)<cons){
            return new triangle(start.x,start.y,x,y,x3,y3);
        }else{

            return new triangle(start.x,start.y,x2,y2,x,y);
        }
    }

    @Override
    public Shape move(int x1, int y1, int x2, int y2) {
        Point start=this.getPosition();
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        int Ox2=t.get("x2").intValue();
        int Oy2=t.get("y2").intValue();
        int Ox3=t.get("x3").intValue();
        int Oy3=t.get("y3").intValue();
        return new triangle(start.x+(x2-x1),start.y+(y2-y1),Ox2+(x2-x1),Oy2+(y2-y1),Ox3+(x2-x1),Oy3+(y2-y1));
    }

    private double area(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
}
