package cs355.model.drawing;

import java.util.ArrayList;
import java.util.List;

import cs355.GUIFunctions;

public class MyModel extends CS355Drawing{

	ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	@Override
	public Shape getShape(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addShape(Shape s) {
		// TODO Auto-generated method stub
		shapeList.add(s);
		String t = s.getClass().getName();
		GUIFunctions.printf(t);
		return (shapeList.size()-1);
	}

	@Override
	public void deleteShape(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveToFront(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movetoBack(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveForward(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveBackward(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Shape> getShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shape> getShapesReversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShapes(List<Shape> shapes) {
		// TODO Auto-generated method stub
		
	}

}
