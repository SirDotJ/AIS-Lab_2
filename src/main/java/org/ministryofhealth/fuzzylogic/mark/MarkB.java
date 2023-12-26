package org.ministryofhealth.fuzzylogic.mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkB extends Mark {
    // Выведено при помощи экспертной оценки терма "B" в файле "Экспертный анализ термов оценок.xlsx"
    private static final List<Double[]> markBNormalizedCoefficients = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 0.05},
            new Double[] {3d, 0.07},
            new Double[] {9d, 0.08},
            new Double[] {15d, 0.1},
            new Double[] {21d, 0.12},
            new Double[] {27d, 0.15},
            new Double[] {33d, 0.18},
            new Double[] {39d, 0.25},
            new Double[] {45d, 0.35},
            new Double[] {51d, 0.46},
            new Double[] {57d, 0.62},
            new Double[] {63d, 0.8},
            new Double[] {69d, 1d},
            new Double[] {75d, 0.75},
            new Double[] {81d, 0.55},
            new Double[] {87d, 0.4},
            new Double[] {93d, 0.25},
            new Double[] {100d, 0.1d}
    ));
    public MarkB() {
        super(markBNormalizedCoefficients);
    }

    @Override
    public String meaning() {
        return "B - Хорошие знания";
    }
}
