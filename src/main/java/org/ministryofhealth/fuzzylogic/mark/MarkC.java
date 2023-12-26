package org.ministryofhealth.fuzzylogic.mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkC extends Mark {
    // Выведено при помощи экспертной оценки терма "C" в файле "Экспертный анализ термов оценок.xlsx"
    private static final List<Double[]> markCNormalizedCoefficients = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 0.02},
            new Double[] {3d, 0.04},
            new Double[] {9d, 0.06},
            new Double[] {15d, 0.08},
            new Double[] {21d, 0.11},
            new Double[] {27d, 0.15},
            new Double[] {33d, 0.35},
            new Double[] {39d, 0.65},
            new Double[] {45d, 1d},
            new Double[] {51d, 0.7},
            new Double[] {57d, 0.5},
            new Double[] {63d, 0.3},
            new Double[] {69d, 0.25},
            new Double[] {75d, 0.18},
            new Double[] {81d, 0.15},
            new Double[] {87d, 0.12},
            new Double[] {93d, 0.08},
            new Double[] {100d, 0.01}
    ));
    public MarkC() {
        super(markCNormalizedCoefficients);
    }

    @Override
    public String meaning() {
        return "С - Средние знания";
    }
}
