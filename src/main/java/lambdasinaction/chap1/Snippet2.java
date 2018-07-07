package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.List;

public class Snippet2 {
public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
		if (apple.getColor().equals(color)) {
			result.add(apple);
		}
	}
	return result;
}
}
