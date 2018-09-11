/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.dataacess.imple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.salle.custommoodle.businesslogic.SubjectBLO;
import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.model.Student;
import edu.salle.custommoodle.model.Subject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class StudentDAOLisImple implements StudentDAO
{
  public static List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student find(String id) {
        for(Student student : studentList)
        {
            if(student.getId().equals(id))
            {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        List<Student> resStudentList = new ArrayList<>();
        lastName = lastName.toLowerCase().trim();
        Student res = null;
        for(Student student : studentList) if(student.getLastName().toLowerCase().contains(lastName) || student.getName().toLowerCase().contains(lastName)) resStudentList.add(student);
        return resStudentList;
    }
    

    @Override
    public void delete(Student student) {
        studentList.remove(student);
    }

    @Override
    public void update(Student student) {
        studentList.set(studentList.indexOf(student), student);
    }

    @Override
    public void load() {
      try {
          Gson gson = new Gson();
          BufferedReader br = new BufferedReader(new FileReader("students.JSON"));
          studentList = gson.fromJson(br, new TypeToken<List<Student>>() {
        }.getType());
        br.close();
        if(studentList == null){
            studentList = new ArrayList<>();
        }
      } catch (Exception ex) {
          ex.printStackTrace();
      }
    }

    @Override
    public void commitChanges() {
        try{
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("students.JSON");
            writer.write(gson.toJson(studentList));
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> searchStudentsSubject(int id) {
        List<Student> studentsSub = new ArrayList<>();
        studentList.stream().filter((student) -> (student.subjectList.contains(id))).forEachOrdered((student) -> {
            studentsSub.add(student);
      });
        return studentsSub;
    }

    @Override
    public void addSubject(String idS, int id) {
        int idI = -1;
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getId().equals(idS))  idI = i;
        }
        if(!studentList.get(idI).subjectList.contains(id)) studentList.get(idI).subjectList.add(id);
    }

    @Override
    public void subjectRemove(int idS, int id) {
        for(int i = 0; i < studentList.get(idS).subjectList.size(); i++){
            if(studentList.get(idS).subjectList.get(i) == id) studentList.get(idS).subjectList.remove(i);
        }
    }

    @Override
    public List<Subject> getStudentSubjects(String id) {
        int idI = -1;
        SubjectBLO subjectBLO = new SubjectBLO();
        List<Subject> subjects = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++) if(studentList.get(i).getId().equals(id)){ idI = i; break;}
        for(int i = 0; i < studentList.get(idI).subjectList.size(); i++) 
            subjects.add(subjectBLO.findAll().get(studentList.get(idI).subjectList.get(i)));
        return subjects;
    }
    
}
