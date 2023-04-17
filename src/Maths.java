
public class Maths {

	int res = 0;

	public void add(int a, int b) {

		res = a + b;
		System.out.println("Addition result: " + res);
	}

	public void mul(int a, int b) {

		res = a * b;
		System.out.println("Multiplication result: " + res);
	}

	public void sub(int a, int b) {

		res = a - b;
		System.out.println("Substraction result: " + res);
	}

	public void square(int a) {

		res = a * a;
		System.out.println("Square result: " + res);
	}

	public void cube(int a) {

		res = a * a * a;
		System.out.println("Cube result: " + res);
	}

}
