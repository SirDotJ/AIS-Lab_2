package org.ministryofhealth.factory;

import org.ministryofhealth.structure.Point;

import java.util.ArrayList;
import java.util.List;

public class PointListFactory {
	public static List<Point> makeList(List<Double[]> points) throws IllegalArgumentException {
		List<Point> result = new ArrayList<>();

		int counter = 0;
		for (Double[] point : points) {
			if (point.length != 2)
				throw new IllegalArgumentException("Provided points list is invalid: element under index " + counter + " is not of size 2");
			result.add(new Point(point[0], point[1]));
			counter++;
		}

		return result;
	}
}
