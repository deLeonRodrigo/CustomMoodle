/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.dataacess;

import edu.salle.custommoodle.model.Student;
import edu.salle.custommoodle.model.Subject;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface SubjectDAO {
    public Subject save(Subject subject);
    
    public List<Subject> findAll();
    
    public List<Student> findStudents(int id);
    
    public void load();

    public void commitChanges();
    
    public void update(Subject subject);
}
