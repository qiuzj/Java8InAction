package lambdasinaction.chap3;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import lambdasinaction.chap1.Apple;

/**
 * 有效的Lambda表达式
 * 
 * @author qiuzj
 *
 */
public class ValidLambdaTester {

	@Test
	public void validLambda() {
		Function<String, Integer> function1 = (String s) -> s.length();
		System.out.println(function1.apply("zhong国")); // 6
		
		Predicate<Apple> predicate1 = (Apple a) -> a.getWeight() > 150;
		System.out.println(predicate1.test(new Apple(200, "yellow")) + " " + predicate1.test(new Apple(150, "red"))); // true false
		
		TwoIntConsumer twoIntConsumer1 = (int x, int y) -> {
			System.out.print("Result: ");
			System.out.println(x + y);
		};
		twoIntConsumer1.accept(1, 2); // Result: 3
		TwoIntConsumer twoIntConsumer2 = (x, y) -> {
			System.out.print("Result: ");
			System.out.println(x + y);
		};
		twoIntConsumer2.accept(1, 2); // Result: 3
		
		Supplier<Integer> supplier1 = () -> 42;
		System.out.println(supplier1.get()); // 42
		
		Supplier<String> supplier2 = () -> "Raoul";
		System.out.println(supplier2.get()); // Raoul
		Supplier<String> supplier3 = () -> {return "Raoul";};
		System.out.println(supplier3.get()); // Raoul
		
		VoidConsumer voidConsumer1 = () -> {};
		voidConsumer1.accept(); // do nothing
		VoidConsumer voidConsumer2 = () -> {System.out.println("I found interface not @FunctionalInterface annotation also can use lambda");};
		voidConsumer2.accept(); // I found interface not @FunctionalInterface annotation also can use lambda
		
		// The target type of this expression must be a functional interface
//		SmartAdder smartAdder1 = (x, y) -> x + y;
	}
	
}
