package eg.edu.alexu.csd.oop.draw.ID_30;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.circle;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.*;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.rectangle;
import eg.edu.alexu.csd.oop.draw.Shape;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.lang.Math;


public class Main {
	
	static String clicked = "";
	public static void main(String args[]){
        
    	JFrame newFrame = new JFrame();
        int newFrameWidth = 200;
        int newFrameHeight = 200;
        newFrame.setSize(newFrameWidth, newFrameHeight);
        newFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        newFrame.setVisible(false);
        
    	
    	// Create a frame
    	
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBounds(140, 10, 800, 750);
		frame.getContentPane().add(panel);
        
        JButton btnLine = new JButton("LINE");
        btnLine.addMouseListener(new MouseAdapter() {
    		int x1, y1, x2, y2;
    		boolean firstClick = true;
        	@Override
        	public void mouseClicked(MouseEvent e1) {
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent el) {
        	    		clicked = "LINE";
        				if(firstClick) {
	        				x1 = el.getX();
	                		y1 = el.getY();
	                		firstClick = false;
        				}else {
        					x2 = el.getX();
	                		y2 = el.getY();
	                		panel.removeMouseListener(this);
	                		if(clicked == "LINE") {
		                		line newShape = new line(x1, y1, x2, y2);
		                		newShape.draw(panel.getGraphics());
		                		firstClick = true;
	                		}
        				}
                	}
                });
        		}
        });

        	
        
        btnLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLine.setBounds(10, 10, 119, 21);
        frame.getContentPane().add(btnLine);
        
        JButton btnSquare = new JButton("SQUARE");
        btnSquare.addMouseListener(new MouseAdapter() {
        	int x1, y1, x2, y2;
    		boolean firstClick = true;
        	@Override
        	public void mouseClicked(MouseEvent e2) {
        		clicked = "SQUARE";
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent es) {
        				if(firstClick) {
	        				x1 = es.getX();
	                		y1 = es.getY();
	                		firstClick = false;
        				}else {
        					x2 = es.getX();
	                		y2 = es.getY();
	                		panel.removeMouseListener(this);
	                		if(clicked == "SQUARE") {
		                		square newShape = new square(x1 , y1, Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)));
		                		newShape.draw(panel.getGraphics());
	                		}
	                		firstClick = true;
        				}
                	}
                });
        		}
        });
        btnSquare.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSquare.setBounds(10, 41, 119, 21);
        frame.getContentPane().add(btnSquare);
        
        JButton btnRectangle = new JButton("RECTANGLE");
        btnRectangle.addMouseListener(new MouseAdapter() {
        	int x1, y1, x2, y2;
    		boolean firstClick = true;
        	@Override
        	public void mouseClicked(MouseEvent e3) {
        		clicked = "RECTANGLE";
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent er) {
        				if(firstClick) {
	        				x1 = er.getX();
	                		y1 = er.getY();
	                		firstClick = false;
        				}else {
        					x2 = er.getX();
	                		y2 = er.getY();
	                		panel.removeMouseListener(this);
	                		if(clicked == "RECTANGLE") {
		                		rectangle newShape = new rectangle(x1 , y1, x2 - x1, y2 - y1);
		                		newShape.draw(panel.getGraphics());
	                		}
	                		firstClick = true;
        				}
                	}
                });
        		}
        });
        btnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRectangle.setBounds(10, 72, 119, 21);
        frame.getContentPane().add(btnRectangle);
        
        JButton btnTriangle = new JButton("TRIANGLE");
        btnTriangle.addMouseListener(new MouseAdapter() {
        	int x1, y1, x2, y2, x3, y3;
    		String Click = "first";
        	@Override
        	public void mouseClicked(MouseEvent e4) {
        		clicked = "TRIANGLE";
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent et) {
        				if(Click == "first") {
	        				x1 = et.getX();
	                		y1 = et.getY();
	                		Click = "second";
        				}else if (Click == "second") {
        					x2 = et.getX();
	                		y2 = et.getY();
	                		Click = "third";
        				}else {
        					x3 = et.getX();
	                		y3 = et.getY();
	                		if(clicked == "TRIANGLE") {
		                		triangle newShape = new triangle(x1 , y1, x2, y2, x3, y3);
		                		newShape.draw(panel.getGraphics());
        				}
	                		Click = "first";
	                		panel.removeMouseListener(this);
        				}
                	}
                });
        		}
        });
        btnTriangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnTriangle.setBounds(10, 103, 119, 21);
        frame.getContentPane().add(btnTriangle);
        
        JButton btnCircle = new JButton("CIRCLE");
        btnCircle.addMouseListener(new MouseAdapter() {
        	int x1, y1, x2, y2;
    		boolean firstClick = true;
        	@Override
        	public void mouseClicked(MouseEvent e5) {
        		clicked = "CIRCLE";
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent ec) {
        				if(firstClick) {
	        				x1 = ec.getX();
	                		y1 = ec.getY();
	                		firstClick = false;
        				}else {
        					x2 = ec.getX();
	                		y2 = ec.getY();
	                		panel.removeMouseListener(this);
		                		if(clicked == "CIRCLE") {
		                		circle newShape = new circle(x1 , y1, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		                		newShape.draw(panel.getGraphics());
		                	}
	                		firstClick = true;
        				}
                	}
                });
        		}
        });
        btnCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCircle.setBounds(10, 134, 119, 21);
        frame.getContentPane().add(btnCircle);
        
        JButton btnEllipse = new JButton("ELLIPSE");
        btnEllipse.addMouseListener(new MouseAdapter() {
        	int x1, y1, x2, y3;
    		String Click = "first";
        	@Override
        	public void mouseClicked(MouseEvent e6) {
        		clicked = "ELLIPSE";
        		panel.addMouseListener(new MouseAdapter() {
        			public void mouseClicked(MouseEvent ee) {
        				if(Click == "first") {
	        				x1 = ee.getX();
	                		y1 = ee.getY();
	                		Click = "second";
        				}else if (Click == "second") {
        					x2 = ee.getX();
	                		ee.getY();
	                		Click = "third";
        				}else {
        					ee.getX();
	                		y3 = ee.getY();
	                		if(clicked == "ELLIPSE") {
		                		ellipse newShape = new ellipse(x1 - Math.abs(x1 - x2), y1 - Math.abs(y1 - y3), 2 * Math.abs(x1 - x2), 2 * Math.abs(y1 - y3));
		                		newShape.draw(panel.getGraphics());
	                		}
	                		Click = "first";
	                		panel.removeMouseListener(this);
        				}
                	}
                });
        	}
        });
        btnEllipse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEllipse.setBounds(10, 165, 119, 21);
        frame.getContentPane().add(btnEllipse);

// Display the frame

        frame.setTitle("DRAW");
        
        int frameWidth = 1000;
        int frameHeight = 900;

        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);



    }
    static class CustomPaintComponent extends Component {

        public void paint(Graphics g) {

            // Retrieve the graphics context; this object is used to paint shapes

        }
    }
}
