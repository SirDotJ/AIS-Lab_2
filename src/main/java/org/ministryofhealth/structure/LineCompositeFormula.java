package org.ministryofhealth.structure;

import java.util.ArrayList;
import java.util.List;

public class LineCompositeFormula {
	private final List<Line> lines;
	public LineCompositeFormula(List<Point> points) {
		this.lines = new ArrayList<>();

		for (int i = 0; i < points.size() - 1; i++) {
			Point start = points.get(i);
			Point end = points.get(i + 1);
			this.lines.add(new Line(start, end));
		}
	}

	public double get(double x) throws IllegalArgumentException {
		for (Line line : this.lines) {
			if (line.checkX(x))
				return line.getByX(x).getY();
		}
		throw new IllegalArgumentException("Provided value x is out of range");
	}
}
