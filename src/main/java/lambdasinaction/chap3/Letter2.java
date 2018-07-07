package lambdasinaction.chap3;

import java.util.function.Function;

public class Letter2 {
	public String addHeader(String text) {
		return "labda From Raoul, Mario and Alan: " + text;
	}

	public String addFooter(String text) {
		return text + "labda Kind regards";
	}

	public String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String... args) {
		new Letter2().test();
	}
	
	public interface Three<T, U, R> {
		R apply(T a, U b);
	}
	
	private void test() {
		Three<Letter2, String, String> a = Letter2::addHeader; // Yes
		// No. Cannot make a static reference to the non-static method addHeader(String) from the type Letter2
//		Function<String, String> addHeader = Letter2::addHeader;
	}

}
