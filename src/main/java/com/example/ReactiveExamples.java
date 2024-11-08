package com.example;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

class Student {
    private final String name;
    private final String subject;
    private final double grade;

    public Student(String name, String subject, double grade) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }
}

public class ReactiveExamples {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "Math", 85.5),
                new Student("Bob", "Science", 92.0),
                new Student("Charlie", "Math", 76.5),
                new Student("Diana", "History", 88.0),
                new Student("Eve", "Math", 91.0)
        );

        // Operador map: Calcula si el estudiante aprobó o no
        Observable.fromIterable(students)
                .map(student -> student.getName() + " passed: " + (student.getGrade() >= 80))
                .subscribe(result -> System.out.println("Map Result: " + result));

        // Operador filter: Filtra los estudiantes que aprobaron "Math"
        Observable.fromIterable(students)
                .filter(student -> "Math".equals(student.getSubject()) && student.getGrade() >= 80)
                .subscribe(student -> System.out.println("Filter Result: " + student));

        // Operador flatMap: Genera un flujo de las calificaciones con un mensaje específico para cada estudiante
        Observable.fromIterable(students)
                .flatMap(student -> Observable.just(student.getName() + " got a grade of " + student.getGrade() + " in " + student.getSubject()))
                .subscribe(message -> System.out.println("FlatMap Result: " + message));

        // Operador merge: Combina dos flujos, uno con los nombres de los estudiantes y otro con sus asignaturas
        Observable<String> studentNames = Observable.fromIterable(students).map(Student::getName);
        Observable<String> subjects = Observable.fromIterable(students).map(Student::getSubject);

        Observable.merge(studentNames, subjects)
                .subscribe(result -> System.out.println("Merge Result: " + result));

        // Operador zip: Combina el nombre del estudiante con su calificación
        Observable<String> studentNamesZip = Observable.fromIterable(students).map(Student::getName);
        Observable<Double> gradesZip = Observable.fromIterable(students).map(Student::getGrade);

        Observable.zip(studentNamesZip, gradesZip, (name, grade) -> name + " - Grade: " + grade)
                .subscribe(result -> System.out.println("Zip Result: " + result));
    }
}
