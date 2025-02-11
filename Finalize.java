//Depreciated
class InnerFinalize {
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

}

public class Finalize {
	public static void main(String[] args) {
		InnerFinalize fin = new InnerFinalize();
	}
}
