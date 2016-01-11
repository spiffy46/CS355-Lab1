package cs355.view;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import cs355.GUIFunctions;
import cs355.model.drawing.Ellipse;
import cs355.model.drawing.Line;
import cs355.model.drawing.MyModel;
import cs355.model.drawing.Rectangle;
import cs355.model.drawing.Shape;

public class MyView implements ViewRefresher{

	private MyModel modelUpdate;
	List<Shape> shapeList = new ArrayList<Shape>();
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		modelUpdate = (MyModel) o;
		shapeList = modelUpdate.getShapes();
		GUIFunctions.refresh();
		System.out.println("Update called");
	}

	@Override
	public void refreshView(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Graphics2D toDrawOn = (Graphics2D) g2d;
		for(int i = 0; i < shapeList.size(); i++){
			Shape s = shapeList.get(i);
			String name = s.getClass().getName();
			if(name == "cs355.model.drawing.Line"){
				Line l = (Line) s;
				toDrawOn.setColor(l.getColor());
				toDrawOn.drawLine((int)l.getStart().getX(), (int)l.getStart().getY(), (int)l.getEnd().getX(), (int)l.getEnd().getY());
			} else if(name == "cs355.model.drawing.Rectangle"){
				Rectangle r = (Rectangle) s;
				toDrawOn.setColor(r.getColor());
				toDrawOn.fillRect((int)r.getUpperLeft().getX(), (int)r.getUpperLeft().getY(), (int)r.getWidth(), (int)r.getHeight());
			} else if(name == "cs355.model.drawing.Ellipse"){
				Ellipse el = (Ellipse) s;
				toDrawOn.setColor(el.getColor());
				int w = (int)el.getWidth();
				int h = (int)el.getHeight();
				
				toDrawOn.fillOval((int)el.getCenter().getX() - w/2, (int)el.getCenter().getY() - h/2, w, h);
			}
			System.out.println(s.getClass().getName());
		}
	}

	public void setModel(MyModel model) {
		modelUpdate = model;
		modelUpdate.addObserver(this);
	}

}
