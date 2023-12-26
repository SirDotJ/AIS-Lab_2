package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceExcellent extends Attendance {
	// Выведено при помощи экспертной оценки терма "Отличная" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendanceExcellentNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 0.4569d},
		new Double[] {1d, 0.5986d},
		new Double[] {3d, 0.7159d},
		new Double[] {5d, 0.8652d},
		new Double[] {7d, 1d},
		new Double[] {9d, 0.9265d},
		new Double[] {11d, 0.8655d},
		new Double[] {13d, 0.7145d},
		new Double[] {15d, 0.6859d},
		new Double[] {17d, 0.5984d},
		new Double[] {19d, 0.4985d},
		new Double[] {21d, 0.3845d},
		new Double[] {23d, 0.3548d},
		new Double[] {25d, 0.2356d},
		new Double[] {27d, 0.1548d},
		new Double[] {29d, 0.1123d},
		new Double[] {31d, 0.0578d},
		new Double[] {33d, 0.0248d},
		new Double[] {34d, 0.0126d}
	));

	public AttendanceExcellent() {
		super(attendanceExcellentNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Отличная - Очень редко пропускает занятия";
	}
}
