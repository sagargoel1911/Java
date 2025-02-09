import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Cat {
	private final String name;
	private int age;

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void meow() {
		System.out.println("Meow!");
	}

	private void secretMethod() {
		System.out.println("This is a private method.");
	}

	public static void staticMethod() {
		System.out.println("This is a public static method.");
	}

	private static void privateStaticMethod() {
		System.out.println("This is a private static method.");
	}
}

public class Reflection {
	public static void main(String[] args) {

		try {
			Cat myCat = new Cat("Stella", 4);

			Class<?> catClass = myCat.getClass();
			System.out.println(catClass.getName());

			Field[] fields = catClass.getDeclaredFields();
			for (Field field : fields) {
				System.out.println("Field: " + field.getName());
			}

			// We can also edit private fields by setting different accessibility
			for (Field field : fields) {
				if (field.getName().equals("name")) {
					field.setAccessible(true);
					field.set(myCat, "Kella");
				}
			}
			System.out.println(myCat.getName());

			// Similarly for all methods
			Method[] methods = catClass.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("Mathod: " + method.getName());
			}

			// We can invoke public and private methods in here
			for (Method method : methods) {
				if (method.getName().equals("meow")) {
					method.invoke(myCat);
				}

				if (method.getName().equals("secretMethod")) {
					method.setAccessible(true);
					method.invoke(myCat);
				}
			}

			// static methods can also be invoked using null as an argument
			for (Method method : methods) {
				if (method.getName().equals("staticMethod")) {
					method.invoke(myCat);
					method.invoke(null);
				}

				if (method.getName().equals("privateStaticMethod")) {
					method.setAccessible(true);
					method.invoke(null);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
