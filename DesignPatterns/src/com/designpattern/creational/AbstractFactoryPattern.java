package com.designpattern.creational;

public class AbstractFactoryPattern {
	public static void main(String[] args) {
		AbstractFactory abstractFactory = FactoryTypeGetter.getShape(false);
		
		abstractFactory.getShape("rectangle").draw();
		abstractFactory.getShape("circle").draw();
		abstractFactory.getShape("triangle").draw();
		
		AbstractFactory abstractFactory2 = FactoryTypeGetter.getShape(true);
		
		abstractFactory2.getShape("rectangle").draw();
		abstractFactory2.getShape("circle").draw();
		abstractFactory2.getShape("triangle").draw();
		
	}
}


abstract class AbstractFactory {
	abstract Shape getShape(String shape);
}

class FactoryTypeGetter {
	public static AbstractFactory getShape(boolean isColored) {
		if (isColored) {
			return new ShapeTypeFactory();
		} else {
			return new ShapeFactory2();
		}
	}
}

class ShapeFactory2 extends AbstractFactory{

	@Override
	Shape getShape(String shape) {
		if ("rectangle".equalsIgnoreCase(shape)) {
			return new Rectangle();
		} else if ("triangle".equalsIgnoreCase(shape)) {
			return new Triangle();
		} else if ("circle".equalsIgnoreCase(shape)) {
			return new Circle();
		}
		return null;
	}
	
}

class ShapeTypeFactory extends AbstractFactory{

	@Override
	Shape getShape(String shape) {
		if ("rectangle".equalsIgnoreCase(shape)) {
			return new ColoredRectangle();
		} else if ("triangle".equalsIgnoreCase(shape)) {
			return new ColoredTriangle();
		} else if ("circle".equalsIgnoreCase(shape)) {
			return new ColoredCircle();
		}
		return null;
	}
	
}

class ColoredRectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Colored rectangle");
	}
}

class ColoredTriangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Colored triangle");
	}
}

class ColoredCircle implements Shape{

	@Override
	public void draw() {
		System.out.println("Colored circle");
	}
}