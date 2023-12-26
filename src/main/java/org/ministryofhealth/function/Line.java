package org.ministryofhealth.function;

public class Line {
	private final Point start;
	private final Point end;

	public Line(Point start, Point end) {
		if (start.getX() > end.getX()) {
			this.start = end;
			this.end = start;
		} else {
			this.start = start;
			this.end = end;
		}
	}

	public Line(double xStart, double yStart, double xEnd, double yEnd) {
		if (xStart > xEnd) {
			double temp = xStart;
			xStart = xEnd;
			xEnd = temp;

			temp = yStart;
			yStart = yEnd;
			yEnd = temp;
		}

		this.start = new Point(xStart, yStart);
		this.end = new Point(xEnd, yEnd);
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public boolean checkX(double x) {
		return(x >= this.start.getX() && x <= this.end.getX());
	}

	public boolean checkY(double y) {
		return(y >= this.start.getY() && y <= this.end.getY());
	}

	public Point getByX(double x) {
		if (x < this.start.getX() || x > this.end.getX())
			return null;

		double x1 = this.start.getX();
		double x2 = this.end.getX();
		double y1 = this.start.getY();
		double y2 = this.end.getY();

		double xValue = x;
		double yValue = ((y2 - y1) / (x2 - x1)) * (x - x1) + y1;

		return new Point(xValue, yValue);
	}

	public Point getByY(double y) {
		if (y < this.start.getY() || y > this.end.getY())
			return null;

		double x1 = this.start.getX();
		double x2 = this.end.getX();
		double y1 = this.start.getY();
		double y2 = this.end.getY();

		double xValue = ((y - y1) * (x2 - x1)) / (y2 - y1) + x1;
		double yValue = y;

		return new Point(xValue, yValue);
	}
}
