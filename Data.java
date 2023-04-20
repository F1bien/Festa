import java.time.LocalDate;

public class Data {

	private String name;
	private String surname;
	private LocalDate date_born;
	private int age;
	
	public Data (
			String name,
			String surname,
			LocalDate date_born,
			int age
			) {
		this.name = name;
		this.surname = surname;
		this.date_born = date_born;
		this.age = age;
	}
	
	public Data (
			Data input
			) {
		this.name = input.getName();
		this.surname = input.getSurname();
		this.date_born = input.getDate_born();
		this.age = input.getAge();
	}

	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public LocalDate getDate_born() {
		return this.date_born;
	}
	
	public int getAge() {
		return this.age;
	}
	
	
}
