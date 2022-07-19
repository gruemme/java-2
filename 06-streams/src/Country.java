
public class Country {
	private String name;
	private Continent contient;
	private Long population;
	private Long area;
	
	public Country(String name, Continent contient, Long population, Long area) {
		super();
		this.name = name;
		this.contient = contient;
		this.population = population;
		this.area = area;
	}
	
	public String getName() {
		return name;
	}
	public Continent getContient() {
		return contient;
	}
	public Long getPopulation() {
		return population;
	}
	public Long getArea() {
		return area;
	}
}
