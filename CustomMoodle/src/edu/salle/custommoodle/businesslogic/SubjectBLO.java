package edu.salle.custommoodle.businesslogic;

import edu.salle.custommoodle.dataacess.SubjectDAO;
import edu.salle.custommoodle.dataacess.imple.SubjectDAOLisImple;
import edu.salle.custommoodle.model.Student;
import edu.salle.custommoodle.model.Subject;
import java.util.List;

/**
 * Rodrigo Eugenio de León Castilla | Mat. 66330
 * Universidad de La Salle Bajío
 */
public class SubjectBLO implements SubjectDAO {
    private SubjectDAO subjectDAO;
    
    public SubjectBLO(){
        subjectDAO = new SubjectDAOLisImple();
    }
    
    @Override
    public Subject save(Subject subject) {
        return subjectDAO.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDAO.findAll();
    }
    
    @Override
    public void load() {
        subjectDAO.load();
    }
    
    @Override
    public List<Student> findStudents(int id) {
        return subjectDAO.findStudents(id);
    }

    @Override
    public void commitChanges() {
        subjectDAO.commitChanges();
    }

    @Override
    public void update(Subject subject) {
        subjectDAO.update(subject);
    }

}
