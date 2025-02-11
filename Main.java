class Base {
	Base() {
		System.out.println("Base Class Constructor Called ");
	}
}

class Derived extends Base {
	Derived() {
		// System.out.println("before");
		// constructor call must be the first statement in a constructor
		super();
		System.out.println("Derived Class Constructor Called ");
	}
}

public class Main {
	public static void main(String[] args) {
		Derived d = new Derived();
	}
}
