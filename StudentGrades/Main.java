import java.util.*;

public class Main {

    public static void main(String[] args) {
        Student[] students = {
                new Student("Jack", "Smith", 50.00, "IT"),
                new Student("Aaron", "Johnson", 76.00, "IT"),
                new Student("Maaria", "White", 35.80, "Business"),
                new Student("John", "White", 47.00, "Media"),
                new Student("Laney", "White", 62.00, "IT"),
                new Student("Jack", "Jones", 32.90, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media"),
        };

        List<Student> studentsList = new ArrayList<Student>(Arrays.asList(students)); // will change order
        List<Student> studentsListCopy = new ArrayList<Student>(Arrays.asList(students)); // unmodified

        System.out.println("Task 1:\n");
        System.out.println("Complete Student list:");
        studentsList.forEach(System.out::println);

        System.out.println("\n\nTask 2:\n");
        System.out.println("Students who got 50% - 100% sorted by grade:");
        studentsList.sort(StudentProcess.StudentGradeComparator);
        StudentProcess.gradeRange(studentsList, 50, 100).forEach(System.out::println);
        
        System.out.println("\n\nTask 3:\n");
        System.out.println("First student who got 50% - 100%:");
        System.out.println(StudentProcess.gradeRange(studentsList, 50, 100).get(0));

        System.out.println("\n\nTask 4:\n");
        System.out.println("Student in ascending order by last name then first: ");
        studentsList.sort(StudentProcess.StudentFullNameComparator);
        studentsList.forEach(System.out::println);

        System.out.println("\nStudent in descending order by last name then first: ");
        studentsList.sort((StudentProcess.StudentFullNameComparator.reversed()));
        studentsList.forEach(System.out::println);

        System.out.println("\n\nTask 5:\n");
        System.out.println("Unique student last names: ");
        studentsList.sort(StudentProcess.StudentFullNameComparator);
        StudentProcess.uniqueLastName(studentsList).forEach(System.out::println);      
        
        System.out.println("\n\nTask 6:\n");
        System.out.println("Student names in order by last name then first name:");
        studentsList.sort(StudentProcess.StudentFullNameComparator);
        StudentProcess.fullName(studentsList).forEach(System.out::println);
        
        System.out.println("\n\nTask 7:\n");
        System.out.println("Students by department:");
        System.out.println("Media");
        StudentProcess.DepartmentSort(studentsListCopy, "Media").forEach(std -> System.out.println("   " + std.toString()));
        System.out.println("IT");
        StudentProcess.DepartmentSort(studentsListCopy, "IT").forEach(std -> System.out.println("   " + std.toString()));
        System.out.println("Business");
        StudentProcess.DepartmentSort(studentsListCopy, "Business").forEach(std -> System.out.println("   " + std.toString()));
               
        System.out.println("\n\nTask 8:\n");
        System.out.println("Count of Students by department:");
        int count = StudentProcess.DepartmentSort(studentsListCopy, "Business").size();
        System.out.println("Business has " + count + " Student(s)");
        count = StudentProcess.DepartmentSort(studentsListCopy, "IT").size();
        System.out.println("IT has " + count + " Student(s)");
        count = StudentProcess.DepartmentSort(studentsListCopy, "Media").size();
        System.out.println("Media has " + count + " Student(s)");
        
        System.out.println("\n\nTask 9:\n");       
        double sumGrade = studentsList.stream().mapToDouble(std -> std.getGrade()).sum();
        System.out.printf("Sum of Students' grades: %.2f", sumGrade);       
        
        System.out.println("\n\n\nTask 10:\n");
        System.out.printf("Average of Students' grades: %.2f", (sumGrade / studentsList.size()));
    }
}