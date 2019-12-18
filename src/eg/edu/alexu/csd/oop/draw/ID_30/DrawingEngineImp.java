package eg.edu.alexu.csd.oop.draw.ID_30;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.*;
import eg.edu.alexu.csd.oop.draw.RoundRectangle;
import eg.edu.alexu.csd.oop.draw.Shape;
//import sun.font.CreatedFontTracker;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrawingEngineImp implements DrawingEngine {

    private ArrayList<operation> history;
    private ArrayList<Shape> nowShapes;
    private int historyIndex;
    public DrawingEngineImp(){

        history=new ArrayList<operation>();
        nowShapes=new ArrayList<Shape>();
        historyIndex=-1;
    }
    @Override
    public void refresh(Graphics canvas) {
        //System.out.println("how many shapes ? " +nowShapes.size());
        for(int i=0;i<nowShapes.size();i++){
            nowShapes.get(i).draw(canvas);
        }
    }

    @Override
    public void addShape(Shape shape) {
        nowShapes.add(shape);
        this.DeltHistory();
        history.add(new operation(1,shape,null));
    }

    @Override
    public void removeShape(Shape shape) {
        nowShapes.remove(shape);
        this.DeltHistory();
        history.add(new operation(2,shape,null));
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        if(oldShape==newShape)
            return;
        nowShapes.remove(oldShape);
        nowShapes.add(newShape);
        this.DeltHistory();
        history.add(new operation(3,oldShape,newShape));
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
        List<Class<? extends Shape>> li=new ArrayList<Class<? extends Shape>>();
        li.add(RoundRectangle.class);
        li.add(circle.class);
        li.add(rectangle.class);
        li.add(square.class);
        li.add(ellipse.class);
        li.add(triangle.class);
        li.add(line.class);

        return li;
    }

    @Override
    public void undo() {
        if(historyIndex == -1){
            //System.out.println("No undo to do");
            return;
        }
        operation req=history.get(historyIndex);
        //System.out.println("Inside undo with type "+req.getType());
        if(req.getType()==1){
            //System.out.println("size before undo = "+nowShapes.size() );
            nowShapes.remove(req.getS1());
            //System.out.println("shape removed "+req.getS1()+" nowShapes size = "+nowShapes.size());
        }else if(req.getType()==2){
            nowShapes.add(req.getS1());
        }else{
            nowShapes.remove(req.getS2());
            nowShapes.add(req.getS1());
        }
        historyIndex--;
    }

    @Override
    public void redo() {
        if(!(historyIndex < history.size()-1)){
            //System.out.println("No redo to do history index = "+historyIndex+" history size = "+history.size());
            return;
        }
        historyIndex++;
        operation req=history.get(historyIndex);
        if(req.getType()==1){
            nowShapes.add(req.getS1());
        }else if(req.getType()==2){
            nowShapes.remove(req.getS1());
        }else{
            nowShapes.remove(req.getS1());
            nowShapes.add(req.getS2());
        }
    }

    @Override
    public void save(String path) {

        if(path.contains(".json")) {

        }else {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(nowShapes);
            encoder.close();
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void load(String path) {
        if(path.contains(".json")) {

        }else {
            InputStream fos = null;
            try {
                fos = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            XMLDecoder decoder = new XMLDecoder(fos);
            nowShapes = (ArrayList<Shape>) decoder.readObject();
            decoder.close();
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private void DeltHistory(){
        int siz=history.size();
        for(int i=historyIndex+1;i<siz;i++){
            history.remove(historyIndex+1);
        }
        historyIndex++;
        if(history.size()==20) {
            historyIndex--;
            history.remove(0);
        }
    }
    public Shape select(int x,int y){
        for(int i=nowShapes.size()-1;i>=0;i--){
            if((nowShapes.get(i)) instanceof RoundRectangle)
                continue;
            if(((ShapeImp)(nowShapes.get(i))).isInside(x,y))
                return nowShapes.get(i);
        }
        return null;
    }
    public RoundRectangle makeRR(int x,int y,double Width,double Length){
        RoundRectangle neo=new RoundRectangle();
        neo.setPosition(new Point(x,y));
        neo.setProperties(new HashMap<String, Double>()
        {
            {
                put("Width", Width);
                put("Length",Length);
                put("ArcWidth", 13.0);
                put("ArcLength", 13.0);
            }
        });
        neo.setColor(Color.BLACK);
        neo.setFillColor(Color.white);
        return neo;
    }
}
