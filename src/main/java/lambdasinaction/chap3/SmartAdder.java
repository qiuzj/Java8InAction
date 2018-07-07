package lambdasinaction.chap3;

/**
 * 因为定义了两个抽象方法，所以不是函数式接口
 */
public interface SmartAdder extends Adder {
	int add(double a, double b);
}
