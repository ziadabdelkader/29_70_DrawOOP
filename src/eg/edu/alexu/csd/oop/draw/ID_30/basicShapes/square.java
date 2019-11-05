package eg.edu.alexu.csd.oop.draw.ID_30.basicShapes;

import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;
import java.util.HashMap;

public class square extends rectangle{

	public square(int x, int y, double length) {
		super(x, y, length, length);
		// TODO Auto-generated constructor stub
	}
	public square(){
		super(0, 0, 0.0, 0.0);
	}
	@Override
	public Shape resize(int x, int y) {
		Point start=this.getPosition();
		if(x<start.x || y<start.y)
			return this;
		Shape update=null;
		try {
			update=(Shape)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		double len=Math.max((x-start.x),(y-start.y));
		update.setProperties(new HashMap<String, Double>()
		{
			{
				put("width", len );
				put("height",len);
			}
		});
		return update;
	}
}
