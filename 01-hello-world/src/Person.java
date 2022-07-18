
// Person ist eine Klasse/Type
public class Person {
	// [<Sichtbarkeit>] [<Modifizierer>] <DatenType> <Namen>
	final String name; // Attribute eines Objektes
	private int alter;
	public static int standardAlter = 0;  // Klassenattribut


	// Konstruktor, Methode mit der ein Objekt dieser
	// Klasse initialisiert wird
	public Person(String n) {
		name = n;
	}

	// Definition einer Methode
	// [<Sichtbarkeit>] [<Modifizierer>] <Rueckhabetype>
	//      <Methodenname>
	//        ([<Typ Parameter1> <Name Parameter1>,
	//          <Typ Parameter2> <Name Parameter2>, ... ] ) {
	// ...
	int getPlz() {
		return 0;
	}

	// Sichtbarkeiten:
	//  - public: von Ueberall aus zugreifbar
	//  - protected: Innerhalb des Package und von Unterklassen
	//  - package (ohne Angabe): Innerhalb des Package
	//  - private: Nur innerhalb der Klasse

	// Modifizierer:
	//  - static: Kennzeichnung Klassenmethode
	//  - final: Kennzeichung, dass die Methode nicht mehr
	//           Ueberschreibar ist
	public final void nichtUeberSchreibareMethode() {
		System.out.println("Hallo");
	}

	public static void klassenMethode() {
		System.out.println("Hallo");
	}
}
