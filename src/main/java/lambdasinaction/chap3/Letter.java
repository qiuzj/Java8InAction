package lambdasinaction.chap3;

import java.util.function.Function;

public class Letter {
	public static String addHeader(String text) {
		return "labda From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		return text + "labda Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String... args) {
		Function<String, String> addHeader = Letter::addHeader; // 注意是静态方法，而不是实例方法
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		// lambda From Raoul, Mario and Alan: lambda stay away from me ! labda Kind regards
		System.out.println(transformationPipeline.apply("labda stay away from me ! "));
		
		Function<String, String> transformationPipeline1 = addHeader.andThen(Letter::addFooter);
		// labda From Raoul, Mario and Alan: labda stay away from me ! labda Kind regards
		System.out.println(transformationPipeline1.apply("labda stay away from me ! "));
	}

}
