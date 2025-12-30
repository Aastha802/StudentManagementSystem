package marks;

import java.util.ArrayList;
import java.util.List;

public class MarksDAOImpl implements MarksDAO {

    private List<Marks> marksList = new ArrayList<>();

    @Override
    public boolean addMarks(Marks marks) {
        return marksList.add(marks);
    }

    @Override
    public boolean updateMarks(Marks marks) {
        for (int i = 0; i < marksList.size(); i++) {
            Marks m = marksList.get(i);
            if (m.getStudentId() == marks.getStudentId() && m.getCourseId() == marks.getCourseId()) {
                marksList.set(i, marks);
                return true;
            }
        }
        return false;
    }

    @Override
    public Marks getMarks(int studentId, int courseId) {
        for (Marks m : marksList) {
            if (m.getStudentId() == studentId && m.getCourseId() == courseId) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Marks> getMarksByStudent(int studentId) {
        List<Marks> studentMarks = new ArrayList<>();
        for (Marks m : marksList) {
            if (m.getStudentId() == studentId) {
                studentMarks.add(m);
            }
        }
        return studentMarks;
    }
}
