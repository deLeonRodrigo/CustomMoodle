package edu.salle.custommoodle.dataacess.imple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.salle.custommoodle.businesslogic.StudentBLO;
import edu.salle.custommoodle.dataacess.SubjectDAO;
import edu.salle.custommoodle.model.Student;
import edu.salle.custommoodle.model.Subject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Rodrigo Eugenio de León Castilla | Mat. 66330
 * Universidad de La Salle Bajío
 */
public class SubjectDAOLisImple implements SubjectDAO {
    private static List<Subject> subjectList = new ArrayList<>();
    
    @Override
    public Subject save(Subject subject) {
        subjectList.add(subject);
        return subject;
    }
    
    @Override
    public List<Subject> findAll() {
        return subjectList;
    }
    
    @Override
     public List<Student> findStudents(int id) {
        StudentBLO studentBLO = new StudentBLO();
        List<Student> studentList = new ArrayList<>();
        studentBLO.findAll().stream().filter((student) -> (student.subjectList.contains(id))).forEachOrdered((student) -> {
            studentList.add(student);
        });
        return studentList;
    }
    
    @Override
     public void load() {
      try {
          Gson gson = new Gson();
          BufferedReader br = new BufferedReader(new FileReader("subjects.JSON"));
          subjectList = gson.fromJson(br, new TypeToken<List<Subject>>() {
        }.getType());
        br.close();
        if(subjectList == null){
            subjectList = new ArrayList<>();
        }
      } catch (Exception ex) {
          ex.printStackTrace();
      }
    }

    @Override
    public void commitChanges() {
        try{
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("subjects.JSON");
            writer.write(gson.toJson(subjectList));
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
