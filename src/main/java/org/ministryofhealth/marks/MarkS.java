package org.ministryofhealth.marks;

import org.ministryofhealth.factory.PointListFactory;
import org.ministryofhealth.structure.LineCompositeFormula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkS extends Mark {
    private static final List<Double[]> points = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 0.03895283},
            new Double[] {3d, 0.03895283},
            new Double[] {9d, 0.046171988},
            new Double[] {15d, 0.05566311},
            new Double[] {21d, 0.068250479},
            new Double[] {27d, 0.103150532},
            new Double[] {33d, 0.127144917},
            new Double[] {39d, 0.158410606},
            new Double[] {45d, 0.197364713},
            new Double[] {51d, 0.245897866},
            new Double[] {57d, 0.306365609},
            new Double[] {63d, 0.377630918},
            new Double[] {69d, 0.465473623},
            new Double[] {75d, 0.570733428},
            new Double[] {81d, 0.699796143},
            new Double[] {87d, 0.699796143},
            new Double[] {93d, 0.843646367},
            new Double[] {100d, 1d}
    ));
    private static LineCompositeFormula formula = new LineCompositeFormula(PointListFactory.makeList(points));

    public static double judge(double points) {
        return formula.get(points);
    }
    public static String resultStr() {
        return "S - Экспертные знания";
    }
    public static double deservedBonus() {
        return 5000;
    }
}
