package lambdasinaction.chap3;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import lambdasinaction.chap3.Sorting.Apple;

public class ComposeTester {

	private List<Apple> inventory;
	
	@Before
	public void init() {
		inventory = new ArrayList<>();
		inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"), new Apple(120, "black")));
		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}, Apple{color='red', weight=120}, Apple{color='black', weight=120}]
		System.out.println(inventory);
		System.out.println();
	}
	
	/**
	 * 比较器复合
	 */
	@Test
	public void testComposedComparator() {
		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='black', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);

		// 逆序
		// [Apple{color='green', weight=155}, Apple{color='red', weight=120}, Apple{color='black', weight=120}, Apple{color='green', weight=80}]
		inventory.sort(comparing(Apple::getWeight).reversed());
		System.out.println(inventory);
		
		// 比较器链
		// [Apple{color='green', weight=155}, Apple{color='black', weight=120}, Apple{color='red', weight=120}, Apple{color='green', weight=80}]
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		System.out.println(inventory);
	}
	
	/**
	 * 谓词复合
	 */
	@Test
	public void testComposedPredicate() {
		Predicate<Apple> redPredicate = a -> "red".equals(a.getColor());
		System.out.println(redPredicate.test(new Apple(120, "red")) + " " + redPredicate.test(new Apple(120, "green"))); // true false
		System.out.println(((Predicate<Apple>)(a -> "red".equals(a.getColor()))).test(new Apple(120, "red"))); // true
		
		// 非
		Predicate<Apple> notRedPredicate = redPredicate.negate();
		System.out.println(notRedPredicate.test(new Apple(120, "red")) + " " + notRedPredicate.test(new Apple(120, "green"))); // false true
		
		// and
		Predicate<Apple> redAnd120Predicate = redPredicate.and(a -> 120 == a.getWeight());
		System.out.println(redAnd120Predicate.test(new Apple(120, "red")) + " " + redAnd120Predicate.test(new Apple(20, "red"))); // true false

		// or
		Predicate<Apple> redOr20Predicate = redPredicate.or(a -> 20 == a.getWeight());
		System.out.println(redOr20Predicate.test(new Apple(120, "red")) + " " + redOr20Predicate.test(new Apple(20, "green"))); // true true
	}
	
	/**
	 * 函数复合
	 */
	@Test
	public void testComposedFunction() {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1);
		System.out.println(result); // 4

		Function<Integer, Integer> f1 = x -> x + 1;
		Function<Integer, Integer> g1 = x -> x * 2;
		Function<Integer, Integer> h1 = f1.compose(g1);
		int result1 = h1.apply(1);
		System.out.println(result1); // 3
	}
	
}
