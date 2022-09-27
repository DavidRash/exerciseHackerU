package TeachersAndSubjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {

		// retrieve a list of all teachers
		SubjectAndTeachers sat = new SubjectAndTeachers();
		String listOfTeachers = sat.ListOfTeachers();
		System.out.println(listOfTeachers);
		
		//retrieve a list of teachers per subject.
		String teachersWhoTeachSubjects = sat.ListOfTeachersPerSubject("NoeJS");
		System.out.println(teachersWhoTeachSubjects);
	}
   }

