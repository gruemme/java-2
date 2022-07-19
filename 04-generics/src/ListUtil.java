import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListUtil {
	public static <T> void fill(List<? super T> list, T obj) {
		list.add(obj);
	}
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		fill(persons, new Person());
		fill(persons, new Child());
		
		List<Child> children = new ArrayList<>();		
		// Not possible: fill(children, new Person());
		
		
		Comparator<Child> byHeight = new Comparator<Child>() {
			@Override
			public int compare(Child o1, Child o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		}; 
		
		Comparator<Person> byAge = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		}; 
		
		// Comparator<Person> ist kein Obertyp von  Comparator<Child>
		
		// Wenn A ist Obertyp von B
		// Dann ist C<A> kein Obertyp von C<B>
		// Deswegen um C<A> einsetzen zu können, wo ich C<B> einsetzen kann
		// C<? super B>
		// Deswegen um C<B> einsetzen zu, können wo ich C<A> einsetzen kann
		// C<? extends A>				
		children.sort(byAge);
		
		System.out.println("Success");
	}
}
