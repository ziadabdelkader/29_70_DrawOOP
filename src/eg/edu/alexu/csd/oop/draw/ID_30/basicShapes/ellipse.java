package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.HashMap;

public class ellipse extends rectangle {
	//top left corner , width and height
	public ellipse(int x, int y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public ellipse(){
		super(0,0,0.0,0.0);
	}
	@Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
		((Graphics2D)canvas).setStroke(new BasicStroke(3));

		canvas.setColor(this.getColor());
		canvas.drawOval(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
		if(this.getFillColor()!=null){
			canvas.setColor(this.getFillColor());
			canvas.fillOval(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
		}
	}
	@Override
	public boolean isInside(int x, int y) {
		HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
		int TcornerX=this.getPosition().x;
		int TcornerY=this.getPosition().y;
		int BcornerX= (int) (this.getPosition().x+t.get("width"));
		int BcornerY= (int) (this.getPosition().y+t.get("height"));
		int centerX=(TcornerX+BcornerX)/2;
		int centerY=(TcornerY+BcornerY)/2;
		int rx=Math.abs(BcornerX-TcornerX)/2;
		int ry=Math.abs(BcornerY-TcornerY)/2;
		if(Math.pow(x-centerX,2)/Math.pow(rx,2)+Math.pow(y-centerY,2)/Math.pow(ry,2) <=1)
			return true;
		return false;
	}
}
