package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.List;

public class Snippet1 {
public static List<Apple> filterGreenApples(List<Apple> inventory) {
	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
		if ("green".equals(apple.getColor())) {
			result.add(apple);
		}
	}
	return result;
}
}
