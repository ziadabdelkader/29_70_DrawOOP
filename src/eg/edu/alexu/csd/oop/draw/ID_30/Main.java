package eg.edu.alexu.csd.oop.draw.ID_30;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.circle;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.rectangle;
import eg.edu.alexu.csd.oop.draw.Shape;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]){
        // Create a frame

        JFrame frame = new JFrame();

// Add a component with a custom paint method

        frame.add(new CustomPaintComponent());

// Display the frame

        int frameWidth = 1000;

        int frameHeight = 1000;

        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);



    }
    static class CustomPaintComponent extends Component {

        public void paint(Graphics g) {

            // Retrieve the graphics context; this object is used to paint shapes

            Graphics2D g2d = (Graphics2D)g;
            DrawingEngine a=new DrawingEngineImp();
            Shape s1=new rectangle(100,100,400,600);
            s1.setColor(Color.RED);
            s1.setFillColor(Color.BLUE);
            Shape s2=new circle(100,100,50);
            s2.setFillColor(Color.yellow);
            s2.setColor(Color.green);
            a.addShape(s1);
            a.addShape(s2);
            a.refresh(g2d);

        }
    }
}
