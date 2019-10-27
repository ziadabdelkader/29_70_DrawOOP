package eg.edu.alexu.csd.oop.draw.ID_30;
import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.Map;

public abstract class ShapeImp implements Shape,Cloneable {
    private Point startPoint;
    private Map<String, Double> shapeProperties;
    private Color shapeColor;
    private Color shapeFillColor;
    public  ShapeImp(Point startPoint,Map<String, Double> shapeProperties){
        this.startPoint=startPoint;
        this.shapeProperties=shapeProperties;
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
        return this.clone();
    }
}
