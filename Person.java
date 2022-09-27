package TeachersAndSubjects;

public class Person {
	
	public String id = null;
	public String name = null;
	public String email = null;
	
	public Person (String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}
	

}
