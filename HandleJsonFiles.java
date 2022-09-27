package TeachersAndSubjects;

import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author davidr
 * this class handles files of type JSON.
 * there are three methods residing in the class
 * 
 * LoadFile - loads the JSON file from where it's stored
 * SubjectMap - creates a Map of the subjects.
 * TeacherList - creates a list of teachers with the translation from subject id's to subject names per teacher.
 *
 */
public class HandleJsonFiles {
	
	/**
	 * method: LoadFile
	 * @throws ParseException 
	 * @throws IOException 
	 * 
	 * loads the JSON file from where it's stored.
	 * 
	 * returns a JSON object of the file loaded.
	 */
	public JSONObject LoadFile () throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
	    FileReader reader = new FileReader(".\\src\\TeachersAndSubjects\\db.json");
		JSONObject jObj = (JSONObject) jsonparser.parse (reader);
		return jObj;
	}
	/**
	 * method: SubjectMap
	 * creates a Map of all subjects based on id and name.
	 * due to the reason that there are identical id's.
	 * the key was the programming language, because they were unique, and the id's were the value.
	 * 
	 * returns a map of languages and id's.
	 *
	 */
	public Map < String, Long> SubjectMap (JSONObject jObj){
		Map <String, Long >subjects = new HashMap<String, Long> ();
	        JSONArray jsonArray = (JSONArray)jObj.get("Languages");
	        for (int i = 0; i< jsonArray.size(); i++) {
	        	JSONObject languages = (JSONObject) jsonArray.get(i);
	        	long id  = (long) languages.get("id");
	        	String name  = (String) languages.get("name");
	        	subjects.put(name, id);
	        }
	        return subjects;
		}
	/**
	 * method: TeacherList
	 * @throws ParseException 
	 * @throws IOException 
	 *
	 * creates a teachers list with language names instead of id's.
	 * 
	 * returns a teachers list.
	 *
	 */
	public List <Subjects> TeacherList () throws IOException, ParseException{
		
		//step 1 -- load json file object
		JSONObject jObj = LoadFile();
		
		//step 2 -- create programming language Map
		Map <String, Long> subjects = SubjectMap (jObj);
		
		//step 3 -- create and return a list of teachers
		
		List <Subjects> teachers = new ArrayList <Subjects>();
		List <String> teachingLanguages = new ArrayList <String> ();
		JSONArray jsonArray = (JSONArray)jObj.get("Lecturers");
		  for (int i = 0; i< jsonArray.size(); i++) { // handles Lecturers array
	        	if (i>0) {teachingLanguages.clear();}
	        	JSONObject lecturers = (JSONObject) jsonArray.get(i);
	        	String id  = (String) lecturers.get("id");
	        	String name  = (String) lecturers.get("name");
	        	String email  = (String) lecturers.get("email");
	        	JSONArray languageArray = (JSONArray)lecturers.get("languages"); //handles the sub array languages of Lecturers array.
	        	for (int j=0 ; j< languageArray.size(); j++) {// derives key by value from language map.
	        		Long subject = (Long) languageArray.get(j);
	        		for (Map.Entry <String, Long> entry : subjects.entrySet()) {
	        			if (subject == entry.getValue()) {
	        				String key = entry.getKey();
	        				teachingLanguages.add(key);
	        			}
	        		}
	        	}
	        	
	        	teachers.add(new  Subjects (id, name, email, teachingLanguages)); // adds new teacher to list.
	        }
	      
		return teachers;
		
	}
	
}
