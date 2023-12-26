package org.ministryofhealth.fuzzylogic;

import org.ministryofhealth.factory.PointListFactory;
import org.ministryofhealth.function.type.LineCompositeFormula;

import java.util.ArrayList;
import java.util.List;

public abstract class Term {
	private final List<Double[]> points;
	protected final LineCompositeFormula formula;
	public Term(List<Double[]> points) {
		this.points = points;
		this.formula = new LineCompositeFormula(PointListFactory.makeList(this.points));
	}

	public double judge(double point) {
		return formula.get(point);
	}
	public abstract String meaning();

	private Term constructTerm(List<Double[]> points) {
		return new Term(points) {
				@Override
				public String meaning() {
					return "Undefined";
				}
			};
	}

	public boolean moreProminentThan(List<Term> terms, double point) {
		Term ultimateTerm = terms.get(0);
		for (int i = 1; i < terms.size(); i++) {
			ultimateTerm = ultimateTerm.unification(terms.get(i));
		}
		return this.judge(point) >= ultimateTerm.judge(point);
	}
	public boolean moreProminentThan(Term[] terms, double point) {
		Term ultimateTerm = terms[0];
		for (int i = 1; i < terms.length; i++) {
			ultimateTerm = ultimateTerm.unification(terms[i]);
		}
		return this.judge(point) >= ultimateTerm.judge(point);
	}

	public Term unification(Term other) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = Math.max(this.judge(point[0]), other.judge(point[0]));
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term interference(Term other) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = Math.min(this.judge(point[0]), other.judge(point[0]));
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term difference(Term other) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = Math.max(this.judge(point[0]) - other.judge(point[0]), 0);
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term negation() {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = 1 - this.judge(point[0]);
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term sum(Term other) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = Math.min(1, this.judge(point[0]) + other.judge(point[0]));
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term multiplication(Term other) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = this.judge(point[1]) * other.judge(point[0]);
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term power(double power) {
		List<Double[]> newPoints = new ArrayList<>();
		for (Double[] point : this.points) {
			Double[] newPoint = new Double[2];
			newPoint[0] = point[0];
			newPoint[1] = Math.pow(this.judge(point[0]), power);
			newPoints.add(newPoint);
		}
		return this.constructTerm(newPoints);
	}
	public Term narrow() {
		return this.power(2);
	}
	public Term broad() {
		return this.power(0.5);
	}
}
