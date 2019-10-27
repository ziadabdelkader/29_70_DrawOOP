package eg.edu.alexu.csd.oop.draw.ID_30;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingEngineImp implements DrawingEngine {

    private ArrayList<Shape> nowShapes;
    public DrawingEngineImp(){
        nowShapes=new ArrayList<Shape>();
    }
    @Override
    public void refresh(Graphics canvas) {
        System.out.println("how many shapes ? " +nowShapes.size());
        for(int i=0;i<nowShapes.size();i++){
            nowShapes.get(i).draw(canvas);
        }
    }

    @Override
    public void addShape(Shape shape) {
        nowShapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        nowShapes.remove(shape);
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        nowShapes.remove(oldShape);
        nowShapes.add(newShape);
    }

    @Override
    public Shape[] getShapes() {
        Shape [] now=new Shape[nowShapes.size()];
        for(int i=0;i<nowShapes.size();i++){
            now[i]=nowShapes.get(i);
        }
        return now;
    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        return null;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void save(String path) {

    }

    @Override
    public void load(String path) {

    }
}
