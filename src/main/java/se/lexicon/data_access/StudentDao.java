package se.lexicon.data_access;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentDao {
    Student save (Student student);
    Student findById(int id);
    List<Student> findAll();
    void deleteById(int id);

}
