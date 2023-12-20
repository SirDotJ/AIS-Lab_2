package org.ministryofhealth;

import org.ministryofhealth.marks.*;

public class Main {
	public static void main(String[] args) {
		int counter = 1;



		for (String value : args) {
			try {
				double studentResult = Double.parseDouble(value);
				JudgementResult judgementResult = new JudgementResult(studentResult);
				System.out.println("Студент №" + counter + ":");
				System.out.println("\tБаллы: " + studentResult);
				System.out.println("\tПодходящая оценка: " + judgementResult.getMostLikelyVerdict());
				System.out.println("\tХороший студент: " + (judgementResult.isGoodStudent() ? "Да" : "Нет"));
				System.out.println("\tСредний студент: " + (judgementResult.isFineStudent() ? "Да" : "Нет"));
				System.out.println("\tПлохой студент: " + (judgementResult.isBadStudent() ? "Да" : "Нет"));
			} catch (NumberFormatException ignore) {}
			counter++;
		}
	}
}