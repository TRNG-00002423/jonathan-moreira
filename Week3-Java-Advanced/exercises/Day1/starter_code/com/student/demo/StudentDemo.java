/** Lab 2 driver — run after Student is implemented. */
package com.student.demo;
public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("John", "Java");
        Student s2 = new Student("Alex", "Python");
        Student s3 = new Student("Mike", "C++");
        Student s4 = s1;

        System.out.println("Enrollment count: " + Student.getEnrollmentCount());

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s4.equals(s1));
        System.out.println(s4 == s1);

    }
}