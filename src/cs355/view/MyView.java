package cs355.view;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import cs355.GUIFunctions;
import cs355.controller.MyController;
import cs355.model.drawing.Circle;
import cs355.model.drawing.Ellipse;
import cs355.model.drawing.Line;
import cs355.model.drawing.MyModel;
import cs355.model.drawing.Rectangle;
import cs355.model.drawing.Shape;
import cs355.model.drawing.Square;
import cs355.model.drawing.Triangle;

public class MyView implements ViewRefresher{

	private MyModel modelUpdate;
	private MyController controllerUpdate;
	private Shape currentShape;
	List<Shape> shapeList = new ArrayList<Shape>();
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof MyModel){
			modelUpdate = (MyModel) o;
			shapeList = modelUpdate.getShapes();
			currentShape = null;
		} else if(o instanceof MyController){
			controllerUpdate = (MyController) o;
			shapeList = modelUpdate.getShapes();
			currentShape = controllerUpdate.getShape();
		}
		GUIFunctions.refresh();
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
			} else if(name == "cs355.model.drawing.Square"){
				Square sq =(Square) s;
				toDrawOn.setColor(sq.getColor());
				toDrawOn.fillRect((int)sq.getUpperLeft().getX(), (int)sq.getUpperLeft().getY(), (int)sq.getSize(), (int)sq.getSize());
			} else if(name == "cs355.model.drawing.Rectangle"){
				Rectangle r = (Rectangle) s;
				toDrawOn.setColor(r.getColor());
				toDrawOn.fillRect((int)r.getUpperLeft().getX(), (int)r.getUpperLeft().getY(), (int)r.getWidth(), (int)r.getHeight());
			} else if(name == "cs355.model.drawing.Circle"){
				Circle c = (Circle) s;
				toDrawOn.setColor(c.getColor());
				Double radius = c.getRadius();
				toDrawOn.fillOval((int)(c.getCenter().getX() - radius), (int)(c.getCenter().getY() - radius), (int)(radius*2), (int)(radius*2));
			}else if(name == "cs355.model.drawing.Ellipse"){
				Ellipse el = (Ellipse) s;
				toDrawOn.setColor(el.getColor());
				int w = (int)el.getWidth();
				int h = (int)el.getHeight();
				toDrawOn.fillOval((int)el.getCenter().getX() - w/2, (int)el.getCenter().getY() - h/2, w, h);
			}else if(name == "cs355.model.drawing.Triangle"){
				Triangle t = (Triangle) s;
				toDrawOn.setColor(t.getColor());
				int[] x = {(int)t.getA().x,(int)t.getB().x,(int)t.getC().x};
				int[] y = {(int)t.getA().y,(int)t.getB().y,(int)t.getC().y};
				toDrawOn.fillPolygon(x, y, 3);
			}
		}
		
		Shape s = currentShape;
		if(s != null){
			String name = s.getClass().getName();
			if(name == "cs355.model.drawing.Line"){
				Line l = (Line) s;
				toDrawOn.setColor(l.getColor());
				toDrawOn.drawLine((int)l.getStart().getX(), (int)l.getStart().getY(), (int)l.getEnd().getX(), (int)l.getEnd().getY());
			} else if(name == "cs355.model.drawing.Square"){
				Square sq =(Square) s;
				toDrawOn.setColor(sq.getColor());
				toDrawOn.fillRect((int)sq.getUpperLeft().getX(), (int)sq.getUpperLeft().getY(), (int)sq.getSize(), (int)sq.getSize());
			} else if(name == "cs355.model.drawing.Rectangle"){
				Rectangle r = (Rectangle) s;
				toDrawOn.setColor(r.getColor());
				toDrawOn.fillRect((int)r.getUpperLeft().getX(), (int)r.getUpperLeft().getY(), (int)r.getWidth(), (int)r.getHeight());
			} else if(name == "cs355.model.drawing.Circle"){
				Circle c = (Circle) s;
				toDrawOn.setColor(c.getColor());
				Double radius = c.getRadius();
				toDrawOn.fillOval((int)(c.getCenter().getX() - radius), (int)(c.getCenter().getY() - radius), (int)(radius*2), (int)(radius*2));
			}else if(name == "cs355.model.drawing.Ellipse"){
				Ellipse el = (Ellipse) s;
				toDrawOn.setColor(el.getColor());
				int w = (int)el.getWidth();
				int h = (int)el.getHeight();
				toDrawOn.fillOval((int)el.getCenter().getX() - w/2, (int)el.getCenter().getY() - h/2, w, h);
			}
		}
		
	}

	public void setModel(MyModel model) {
		modelUpdate = model;
		modelUpdate.addObserver(this);
	}
	
	public void setController(MyController controller){
		controllerUpdate = controller;
		controllerUpdate.addObserver(this);
	}

}
