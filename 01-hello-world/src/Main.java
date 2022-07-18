
/**
 *
 * @author Bredex_User
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Hallo Welt");

		Person christian = new Person("Christian");

		int plz = christian.getPlz(); // Methode
		String n = christian.name;

		int j = Person.standardAlter;
		Person.klassenMethode();

		Person anna = new Person("Anna");
		if (anna == null) {
			System.out.println("Anna nicht da");
		}
		int b = 3;
	}
}