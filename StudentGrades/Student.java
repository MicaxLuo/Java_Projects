public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    Student(String fname, String lname, double grade, String dpt) {
        firstName = fname;
        lastName = lname;
        this.grade = grade;
        department = dpt;
    }
    
    public void setFirstName(String fname) {
    	firstName = fname;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public void setLastName(String lname) {
    	lastName = lname;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getName() {
        return (firstName + ' ' + lastName);
    }
    
    public void setGrade(double grade) {
    	this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
    
    public void setDepartment(String dpt) {
    	department = dpt;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() { // what's the use of this?
        return String.format("%-12s", getFirstName()) +
        String.format("%-12s", getLastName()) +
        String.format("%-7.2f", getGrade())+
        String.format("%-12s", getDepartment());
        // If the string has less than 12 characters, the output will be padded on the right.
    }

    @Override
    public int compareTo(Student std) {
        double compareGrade = std.getGrade();
        return (int)(Math.round(this.grade - compareGrade));
    }
}