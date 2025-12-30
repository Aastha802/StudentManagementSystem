package marks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MarksDAO marksDAO = new MarksDAOImpl();
        GradeService gradeService = new GradeService();

        // Adding marks
        Marks m1 = new Marks(1, 101, 201, 85);
        gradeService.assignGrade(m1);
        marksDAO.addMarks(m1);

        Marks m2 = new Marks(2, 101, 202, 72);
        gradeService.assignGrade(m2);
        marksDAO.addMarks(m2);

        Marks m3 = new Marks(3, 102, 201, 48);
        gradeService.assignGrade(m3);
        marksDAO.addMarks(m3);

        // Fetch marks for a student
        List<Marks> student101Marks = marksDAO.getMarksByStudent(101);
        System.out.println("Marks of Student 101:");
        for (Marks m : student101Marks) {
            System.out.println(m);
        }

        // Update marks
        Marks updatedM1 = new Marks(1, 101, 201, 92);
        gradeService.assignGrade(updatedM1);
        marksDAO.updateMarks(updatedM1);

        // Fetch updated marks
        Marks m = marksDAO.getMarks(101, 201);
        System.out.println("\nUpdated Marks of Student 101 in Course 201:");
        System.out.println(m);
    }
}
