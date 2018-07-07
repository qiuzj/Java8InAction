package lambdasinaction.chap1;

public class AppleGreenColorPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}