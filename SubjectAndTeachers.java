package TeachersAndSubjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

/**
 * @author davidr
 * class SubjectAndTeachers has two methods which handle data requested  regarding teachers and subjects.
 * 
 * ListOfTeachers - returns a list of the teachers present in the JSON file
 * ListOfTeachersPerSubject - returns a list of teachers per programming language. if no one teaches the language, an appropriate message is returned.
 */
public class SubjectAndTeachers {
	
	private final String ENDLINE = "\n";
	private final String ID = "id = ";
	private final String NAME = " ,name = ";
	private final String EMAIL = ", Email = ";
	private final String LANGUAGES = ", Languages = ";
	private final String DOT = ".";
	
	
	/**
	 * method: ListOfTeachers
	 * creates a list of teachers per the JSON source file.
	 */
	public String ListOfTeachers () throws IOException, ParseException {
		
		List <Subjects> teacherList = new ArrayList <Subjects> ();
		HandleJsonFiles handleJ = new HandleJsonFiles();
		StringBuilder sb = new StringBuilder();
		teacherList.addAll(handleJ.TeacherList());
		sb.append("List of teachers are").append(ENDLINE);
		for (Subjects s: teacherList) {
	    	sb.append(ID).append(s.getId()).append(NAME).append(s.getName()).append(EMAIL).append(s.getEmail()).append(LANGUAGES).append(s.getSubjects()).append(ENDLINE);
		}
		
		return sb.toString();
	}
	
	/**
	 * method: ListOfTeachersPerSubject
	 * accepts a language parameter, i.e. Java, .NET (case sensitive per JSON file, JAVA will not be recognized as a programming language.
	 * returns a list of teachers which teach the requested language,
	 */
	public String ListOfTeachersPerSubject(String language) throws IOException, ParseException {
		List <Subjects> teacherList = new ArrayList <Subjects> ();
		List <String> subjectList = new ArrayList <String>();
		HandleJsonFiles handleJ = new HandleJsonFiles();
		StringBuilder sb = new StringBuilder();
		boolean languageIsTaught = false;
		teacherList.addAll(handleJ.TeacherList());
		
		sb.append("List of teachers that are teaching ").append(language).append(" are:").append(ENDLINE);
		for (Subjects s: teacherList) { // teacher
			for (String t : s.getSubjects()) { // list of languages that he teaches.
				if(language.equals(t)) {
					sb.append(ID).append(s.getId()).append(NAME).append(s.getName()).append(EMAIL).append(s.getEmail()).append(ENDLINE);
					if (languageIsTaught == false) {
					    languageIsTaught = true;
					}
				}
			}
			
		}

		if (languageIsTaught) {
			return sb.toString();
		}
		return "no one teaches " + language;
	}

}
