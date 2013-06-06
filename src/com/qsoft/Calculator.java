package com.qsoft;

import java.util.regex.Pattern;

public class Calculator {

	public static int add(String str) {

		String delimiter = "";
		if (str == null) {
			return 0;
		}
		if (str.isEmpty()) {
			return 0;
		}
		if (str.contains("//") && str.contains("][")) {
			do {
				str = str.replace("//", "");
				str = str.replace("\n", "");
				String delimiter1 = str.substring(str.indexOf("[") + 1,
						str.indexOf("]"));
				String rep = str.substring(str.indexOf("["),
						str.indexOf("]") + 1);
				str = str.replaceAll(Pattern.quote(rep), ",");
				str = str.replaceAll(Pattern.quote(delimiter1), ",");

				System.out.println("rep=" + rep);
				System.out.println("str=" + str);
				System.out.println("delimiter1=" + delimiter1);
			} while (str.contains("["));
			String[] strTemp = str.split(",");
			return sum(strTemp);
		} else if (str.contains("//[")) {
			delimiter = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
			str = str.replace("//[", "");
			str = str.replace("]\n", "");
			String[] strTemp = str.split(Pattern.quote(delimiter));

			return sum(strTemp);
		} else if (str.contains("//")) {

			delimiter = str.substring(2, 3);
			str = str.replace("//", "");
			str = str.replace("\n", "");
			String[] strTemp = str.split(delimiter);

			return sum(strTemp);
		}

		else if (str.contains("\n")) {
			str = str.replace("\n", "");
			String[] strTemp = str.split(",");

			return sum(strTemp);
		} else {
			String[] strTemp = str.split(",");

			return sum(strTemp);
		}

	}

	public static int sum(String[] str) {
		int sum = 0;
		int strTempSize = str.length;
		for (int i = 0; i < strTempSize; i++) {
			String str1 = str[i];
			if (str1.isEmpty()) {
				continue;
			}
			sum += Integer.parseInt(str1);
		}
		return sum;
	}
}
