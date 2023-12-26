package org.ministryofhealth.fuzzylogic.attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceBad extends Attendance {
	// Выведено при помощи экспертной оценки терма "Плохая" в файле "Экспертный анализ термов посещаемости.xlsx"
	private static final List<Double[]> attendanceBadNormalizedCoefficients = new ArrayList<>(Arrays.asList(
		new Double[] {0d, 0.0134d},
		new Double[] {1d, 0.0254d},
		new Double[] {3d, 0.0485d},
		new Double[] {5d, 0.1156d},
		new Double[] {7d, 0.1568d},
		new Double[] {9d, 0.1856d},
		new Double[] {11d, 0.2956d},
		new Double[] {13d, 0.3756d},
		new Double[] {15d, 0.468d},
		new Double[] {17d, 0.514d},
		new Double[] {19d, 0.6154d},
		new Double[] {21d, 0.6958d},
		new Double[] {23d, 0.748d},
		new Double[] {25d, 0.826d},
		new Double[] {27d, 0.8765d},
		new Double[] {29d, 1d},
		new Double[] {31d, 0.932d},
		new Double[] {33d, 0.832d},
		new Double[] {34d, 0.798d}
	));

	public AttendanceBad() {
		super(attendanceBadNormalizedCoefficients);
	}

	@Override
	public String meaning() {
		return "Плохая - Посещает занятия по минимуму";
	}
}
