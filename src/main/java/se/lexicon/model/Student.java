package se.lexicon.model;

public class Student {
    private int id;
    private String name;

// contructor
    public Student(int id, String name) {
       setId(id);
        setName(name);
    }

    // getter  and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
