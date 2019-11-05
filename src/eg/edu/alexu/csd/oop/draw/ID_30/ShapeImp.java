package eg.edu.alexu.csd.oop.draw.ID_30;
import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.Map;

abstract public class ShapeImp implements Shape,Cloneable {
    private Point startPoint;
    private Map<String, Double> shapeProperties;
    private Color shapeColor;
    private Color shapeFillColor;
    public  ShapeImp(Point startPoint,Map<String, Double> shapeProperties){
        this.startPoint=startPoint;
        this.shapeProperties=shapeProperties;
        this.shapeColor=Color.black;
    }
    public  ShapeImp(){

    }
    @Override
    public void setPosition(Point position) {
        startPoint=position;
    }

    @Override
    public Point getPosition() {
        return startPoint;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        shapeProperties=properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return shapeProperties;
    }

    @Override
    public void setColor(Color color) {
        shapeColor=color;
    }

    @Override
    public Color getColor() {
        return shapeColor;
    }

    @Override
    public void setFillColor(Color color) {
        shapeFillColor=color;
    }

    @Override
    public Color getFillColor() {
        return shapeFillColor;
    }

    @Override
    abstract public void draw(Graphics canvas);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    abstract public boolean isInside(int x, int y);

    abstract public Shape resize(int x, int y);

    public Shape move(int x1, int y1, int x2, int y2) {
        Shape update=null;
        try {
            update=(Shape) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Point start=this.getPosition();
        update.setPosition(new Point(start.x+(x2-x1),start.y+(y2-y1)));
        return update;
    }

}
