package TeachersAndSubjects;

import java.util.ArrayList;
import java.util.List;

public class Subjects extends Person {
	
	List <String> subjects = new ArrayList <String>();

	public Subjects(String id, String name, String email, List <String> languages) {
		super(id, name, email);
		this.subjects.addAll(languages);
		
	}

	public List<String> getSubjects() {
		return subjects;
	}
}
