
public class TestApple {
	Apple[] apple = new Apple[2];
	{
		for (Apple a : apple) {
			a = new Apple();
		}
	}
	public static void main(String[] args) {
		TestApple ta = new TestApple();
		for (int i = 0; i < 2; i++) {
			System.out.println(ta.apple[i]);
		}
	}
}
