1) i did the exercise on the server side, because i offered myself as an instructor for programming language Java, as i was told to do.

2) the Json file i took from you,  hase duplicate id's for the Languages array (id = 5, id = 7). therefore if a teacher instructed language 7, i added 2 languages to the list.

3) the db.json file was loaded from a pre determined folder in 'HandleJsonFiles.LoadFile'. i did not execute file search logic.

4) there are 5 classes uploaded:
   a) Person   
   b) Subjects
       a+b combine the teacher + langauge structure
   c) HandleJsonFiles - load, parse and create a list of teachers from the Json file
   d) SubjectAndTeachers (API class)- provide the methods for retrieving a list of teachers, and filter by subject.
note:
 i also provided the main class, for executing purposes.

5) SubjectAndTeachers  (API class)
   contains 2 methods:
   a) ListOfTeachers()
       receives: no parameters
       returns: a string object,  listing of all teachers presented in the Json file

    b) ListOfTeachersPerSubject (String language)
        receives: a language parameter
        returns: a String object, listing all of the teachers that teach that language.
                     if no techers instructs the language, an appropriate message is returned.

    exceptions: IOException, ParseException (generated in the 'HandleJsonFiles' class).
      



   