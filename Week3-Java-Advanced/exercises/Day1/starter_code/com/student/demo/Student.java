package com.student.demo;
import java.util.Objects;

/**
 * Lab 2 — Student. Replace UnsupportedOperationException bodies with real logic.
 * See ../README.md
 */
public class Student {

    private static int nextId, instanceCount;
    private final int id;
    private String name, program;

    public Student(String name, String program) {
        this.name = name;
        this.program = program;
        nextId = instanceCount;
        this.id = nextId;
        instanceCount++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public static int getEnrollmentCount() {
        return instanceCount;
    }
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", program=" + program + "]";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;

        Student other = (Student) o;

        return Integer.compare(id, other.getId()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,program,id);
    }
}