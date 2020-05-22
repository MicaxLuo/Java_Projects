import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcess {

	public static List<Student> gradeRange(List<Student> stdList, double lowerGrade, double higherGrade) {
		return stdList.stream().filter(std -> 
			std.getGrade() >= lowerGrade && std.getGrade() <= higherGrade).collect(Collectors.toList());
	}

	public static List<String> uniqueLastName(List<Student> stdList) {
		return stdList.stream().map(std -> std.getLastName()).distinct().collect(Collectors.toList());
	}
	
	public static List<String> fullName(List<Student> stdList) {
		return stdList.stream().map(std -> std.getName()).collect(Collectors.toList());
	}
	
	public static List<Student> DepartmentSort(List<Student> stdList, String dpt) {
		return stdList.stream().filter(std ->
			std.getDepartment() == dpt).collect(Collectors.toList());
	}

	public static Comparator<Student> StudentGradeComparator = (std1, std2) -> 
		(int)(std1.getGrade() - std2.getGrade());

    public static Comparator<Student> StudentFullNameComparator = (std1, std2) -> {  	
    	int rc = std1.getLastName().compareTo(std2.getLastName()) * 100 + std1.getFirstName().compareTo(std2.getFirstName());
    	
    	return rc;
    };


}