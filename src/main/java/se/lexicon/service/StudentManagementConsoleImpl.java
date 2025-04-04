package se.lexicon.service;

import org.springframework.stereotype.Service;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.unit.UserInputService;

import java.util.List;

@Service
public class StudentManagementConsoleImpl implements StudentManagement{

private final UserInputService userInputService;
private  final StudentDao studentDao;
// constrouctor
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Creating new Student");

        System.out.println("Enter Student ID: ");
        int id = userInputService.getInt();

        System.out.println("Enter Student Name: ");
        String name = userInputService.getString();

        return studentDao.save(new Student(id, name));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        Student student = studentDao.findById(id);
        if(student != null){
            System.out.println("Found student: " + student);
        } else {
            System.out.println("No student found with ID: " + id);
        }
        return student;
    }

    @Override
    public Student remove(int id) {
        Student student = studentDao.findById(id);
        if(student != null){
            studentDao.deleteById(id);
            System.out.println("Removed student: " + student);
        } else {
            System.out.println("No student found with ID: " + id);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.findAll();
        if(students.isEmpty())
            System.out.println("No students found.");
        else {
            System.out.println("All students:");
            students.forEach(System.out::println);
        }
        return students;
    }

    @Override
    public Student edit(Student student) {
        System.out.println("Editing student: " + student);
        System.out.println("Enter a new name (leave blank to keep current): ");
        String name = userInputService.getString();
        if(!name.isEmpty())
            student.setName(name);
        return student;
    }
}
