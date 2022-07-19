import java.util.List;
import java.util.stream.Collectors;

public class StreamsMain {

	public static void main(String[] args) {
		List<Country> countries = List.of(new Country("USA", Continent.AMERICA, 300000000L, 9500000L),
				new Country("Germany", Continent.EUROPE, 82000000L, 357000L),
				new Country("England", Continent.EUROPE, 5600000L, 130000L),
				new Country("Monaco", Continent.EUROPE, 40000L, 2L),
				new Country("Japan", Continent.ASIA, 126000000L, 378000L),
				new Country(null, Continent.ASIA, 0L, 0L),
				new Country("Togo", Continent.AFRICA, 8000000L, 56000L));
		
		countries.stream()
			.filter(c-> c != null) // Stream<Country>
			.map(country -> country.getContient()) // Stream<Continent>
			.distinct()  // Stream<Continent>
			.forEach(continent -> System.out.println(continent));
		
		countries.stream() // Stream<Country>
			.filter(c-> c != null) // Stream<Country>
			.map(country -> country.getName()) // Stream<String>
			.filter(element -> element != null) // Stream<String>
			.map(name -> name.length()) // Stream<Integer> / IntStream
			.forEach(System.out::println);
		
		List<String> nameOfCountriesInEurope = countries.stream()
				.filter(c -> Continent.EUROPE.equals(c.getContient()))
				.map(country -> country.getName())
				.collect(Collectors.toList());
		
		System.out.println(nameOfCountriesInEurope.size());
		
		Long numberOfCountriesWithPopulationOver1Million = 
				countries.stream()
				.filter(c -> c.getPopulation() > 1000000L)
				.count();
		
		System.out.println("numberOfCountriesWithPopulationOver1Million = " + numberOfCountriesWithPopulationOver1Million);
		
	}

}
