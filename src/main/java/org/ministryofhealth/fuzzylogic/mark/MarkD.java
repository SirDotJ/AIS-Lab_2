package org.ministryofhealth.fuzzylogic.mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkD extends Mark {
    // Выведено при помощи экспертной оценки терма "D" в файле "Экспертный анализ термов оценок.xlsx"
    private static final List<Double[]> markDNormalizedCoefficients = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 0.15165},
            new Double[] {3d, 0.35521},
            new Double[] {9d, 0.63123},
            new Double[] {15d, 1d},
            new Double[] {21d, 0.63823},
            new Double[] {27d, 0.31125},
            new Double[] {33d, 0.2788},
            new Double[] {39d, 0.12411},
            new Double[] {45d, 0.06244},
            new Double[] {51d, 0.02004},
            new Double[] {57d, 0.016621},
            new Double[] {63d, 0.012481},
            new Double[] {69d, 0.012011},
            new Double[] {75d, 0.01341},
            new Double[] {81d, 0.01261},
            new Double[] {87d, 0.01209},
            new Double[] {93d, 0.00691},
            new Double[] {100d, 0.00421}
    ));

    public MarkD() {
        super(markDNormalizedCoefficients);
    }

    @Override
    public String meaning() {
        return "D - Плохие знания";
    }
}
