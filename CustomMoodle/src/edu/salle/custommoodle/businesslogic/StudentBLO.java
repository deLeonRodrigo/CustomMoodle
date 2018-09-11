package edu.salle.custommoodle.businesslogic;

import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.dataacess.imple.StudentDAOLisImple;
import edu.salle.custommoodle.model.Student;
import edu.salle.custommoodle.model.Subject;
import java.util.List;

/**
 * Rodrigo Eugenio de León Castilla | Mat. 66330
 * Universidad de La Salle Bajío
 */
public class StudentBLO {
    private StudentDAO studentDAO;

    public StudentBLO() {
        studentDAO = new StudentDAOLisImple();
    }
    public List<Student> searchStudentsSubject(int id){
        return studentDAO.searchStudentsSubject(id);
    }
    public void removeSubject(int idS, int id){
        studentDAO.subjectRemove(idS, id);
    }
    
    public void addSubject(String idS, int id){
        studentDAO.addSubject(idS, id);
    }
    public Student save(Student student)
    {
     return   studentDAO.save(student); 
    }
    
    public List<Student> findAll()
    {
        return studentDAO.findAll();
    }
    
    public Student find(String id)
    {
        return studentDAO.find(id);
    }
    public List<Student> findByLastName(String lastName){
        return studentDAO.findByLastName(lastName);
    }
    
    public void delete(Student student){
        studentDAO.delete(student);
    }
    
    public void update(Student student){
        studentDAO.update(student);
    }

    public void load() {
        studentDAO.load();
    }

    public void commitChanges() {
        studentDAO.commitChanges();
    }
    public List<Subject> getStudentSubjects(String id) {
        return studentDAO.getStudentSubjects(id);
    }
}
