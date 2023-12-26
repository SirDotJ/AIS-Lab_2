package org.ministryofhealth;

import org.ministryofhealth.fuzzylogic.attendance.OverallAttendance;

public class Main {
	public static void main(String[] args) {

		for (int i = 0; i < 35; i++) {
			System.out.println("Количество пропусков: " + i);
			System.out.println("Посещаемость: " + (new OverallAttendance(i)).getResultTerm());
		}
	}
}