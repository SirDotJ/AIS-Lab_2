package org.ministryofhealth.structure;

public class RestrictedPoint extends Point {
	private final Range xRestriction;
	private final Range yRestriction;
	public RestrictedPoint(double x, double y) {
		super(x, y);
		this.xRestriction = null;
		this.yRestriction = null;
	}
	public RestrictedPoint(double x, double y, Range xRestriction, Range yRestriction) throws IllegalArgumentException {
		super(x, y);

		if (!xRestriction.check(this.x))
			throw new IllegalArgumentException("Provided x value is outside provided x restrictions");
		if (!yRestriction.check(this.y))
			throw new IllegalArgumentException("Provided y value is outside provided y restrictions");

		this.xRestriction = xRestriction;
		this.yRestriction = yRestriction;
	}

	@Override
	public void setX(double x) throws IllegalArgumentException {
		if (this.xRestriction != null && !this.xRestriction.check(x))
				throw new IllegalArgumentException("Provided x value is outside of x restrictions");
		super.setX(x);
	}

	@Override
	public void setY(double y) throws IllegalArgumentException {
		if (yRestriction != null && !this.yRestriction.check(y))
				throw new IllegalArgumentException("Provided y value is outside of y restrictions");
		super.setY(y);
	}
}
