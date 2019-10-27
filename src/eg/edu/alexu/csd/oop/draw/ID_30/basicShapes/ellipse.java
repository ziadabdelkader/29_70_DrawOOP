package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import java.awt.Graphics;
import java.util.HashMap;

public class ellipse extends rectangle{

	public ellipse(int x, int y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void draw(Graphics canvas) {
        HashMap<String,Double> t= (HashMap<String, Double>) this.getProperties();
        canvas.drawOval(this.getPosition().x,this.getPosition().y,t.get("width").intValue(),t.get("height").intValue());
	}
}
