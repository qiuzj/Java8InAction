package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.List;

public class Snippet7 {
public static <T> List<T> filter(List<T> list, Predicate<T> p) {
	List<T> result = new ArrayList<>();
	for (T e : list) {
		if (p.test(e)) {
			result.add(e);
		}
	}
	return result;
}

	public static void main(String[] args) {
List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
	}
}
