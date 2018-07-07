package lambdasinaction.chap1;

import java.util.List;

public class Snippet6 {
List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor());
	}
});
}
