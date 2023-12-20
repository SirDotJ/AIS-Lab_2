package org.ministryofhealth.marks;

import org.ministryofhealth.factory.PointListFactory;
import org.ministryofhealth.structure.LineCompositeFormula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkA extends Mark {
    private static final List<Double[]> points = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 0.01},
            new Double[] {3d, 0.02},
            new Double[] {9d, 0.04},
            new Double[] {15d, 0.06},
            new Double[] {21d, 0.07},
            new Double[] {27d, 0.08},
            new Double[] {33d, 0.085},
            new Double[] {39d, 0.09},
            new Double[] {45d, 0.094},
            new Double[] {51d, 0.1},
            new Double[] {57d, 0.2},
            new Double[] {63d, 0.4},
            new Double[] {69d, 0.6},
            new Double[] {75d, 0.75},
            new Double[] {81d, 1d},
            new Double[] {87d, 0.8},
            new Double[] {93d, 0.6},
            new Double[] {100d, 0.4}
    ));
    private static LineCompositeFormula formula = new LineCompositeFormula(PointListFactory.makeList(points));

    public static double judge(double points) {
        return formula.get(points);
    }
    public static String resultStr() {
        return "A - Отличные знания";
    }
    public static double deservedBonus() {
        return 2500;
    }
}
