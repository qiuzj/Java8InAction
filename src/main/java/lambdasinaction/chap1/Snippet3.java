package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.List;

public class Snippet3 {
public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
		if (apple.getWeight() > weight) {
			result.add(apple);
		}
	}
	return result;
}
}
