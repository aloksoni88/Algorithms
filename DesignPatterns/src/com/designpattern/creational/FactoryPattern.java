package com.designpattern.creational;

public class FactoryPattern {
	
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		factory.getShape("triangle").draw();
		factory.getShape("rectangle").draw();
		factory.getShape("circle").draw();
	}

}

class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("triangle")) {
			return new Triangle();
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		return null;
	}
}

interface Shape{
	void draw();
}


class Triangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Triangle shape");
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle shape");
	}
	
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle shape");
	}
	
}

