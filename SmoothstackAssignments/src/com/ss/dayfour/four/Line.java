package com.ss.dayfour.four;

public class Line {

	private double x1, x2, y1, y2;
	
	public Line(double x1, double x2, double y1, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public double getSlope() {
		if (x1 == x2) {
			throw new ArithmeticException();
		}
		
		return (y2 - y1)/(x2 - x1);
	}
	
	public double getDistance() {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public boolean paralletlTo(Line l) {
		return (Math.abs(getSlope()) - l.getSlope() < 0.0001);
	} 
}
