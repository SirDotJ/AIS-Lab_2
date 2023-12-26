package org.ministryofhealth.fuzzylogic.mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkF extends Mark {
    // Выведено при помощи экспертной оценки терма "F" в файле "Экспертный анализ термов оценок.xlsx"
    private static final List<Double[]> markFNormalizedCoefficients = new ArrayList<>(Arrays.asList(
            new Double[] {0d, 1d},
            new Double[] {3d, 0.9313},
            new Double[] {9d, 0.6173},
            new Double[] {15d, 0.2231},
            new Double[] {21d, 0.1662},
            new Double[] {27d, 0.0911},
            new Double[] {33d, 0.0523},
            new Double[] {39d, 0.035},
            new Double[] {45d, 0.015},
            new Double[] {51d, 0.0111},
            new Double[] {57d, 0.012},
            new Double[] {63d, 0.01},
            new Double[] {69d, 0.001},
            new Double[] {75d, 0.001},
            new Double[] {81d, 0.001},
            new Double[] {87d, 0.001},
            new Double[] {93d, 0.001},
            new Double[] {100d, 0.001}
    ));

    public MarkF() {
        super(markFNormalizedCoefficients);
    }

    @Override
    public String meaning() {
        return "F - Нет знаний";
    }
}
