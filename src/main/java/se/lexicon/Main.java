package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

//create
        Student student2 = studentManagement.create();
        //save
        Student student1 = studentManagement.save(new Student(100, "Botond"));
        //findAll
        studentManagement.findAll();
        //edit
        student1 = studentManagement.edit(student1);
        //find
        studentManagement.find(student1.getId());
        //remove
        studentManagement.remove(student1.getId());
        studentManagement.findAll();



    }
}