package org.sg.util;

import java.util.List;

public class SGUtil {
	public static void printArray(String[] arr) {
		final String separator = ", ";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + separator);
			}
		}
		System.out.println();
	}
	
	public static String getArrayAsString(String[] arr) {
		final String separator = ", ";
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				 s = s + arr[i];
			} else {
				 s =  s + arr[i] + separator ;
			}
		}
		return s;
	}
	
	public static <E> void printList(List<E> list) {
		final String separator = "\n";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				System.out.print(list.get(i));
			} else {
				System.out.print(list.get(i) + separator);
			}
		}
		System.out.println();
	}
}
