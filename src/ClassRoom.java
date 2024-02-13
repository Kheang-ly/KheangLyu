import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ClassRoom {
    private int classNo;
    private String className;
    private Teacher assignedTeacher;
    private Subject assignedSubject;
    private static final List<ClassRoom> availableClasses = new ArrayList<>();

    // Constructor
    public ClassRoom(int classNo, String className) {
        this.classNo = classNo;
        this.className = className;
        availableClasses.add(this);
    }

    // Getters and setters
    public int getClassNo() {
        return classNo;
    }

    public String getClassName() {
        return className;
    }
    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }
    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }
    public Subject getAssignedSubject() {
        return assignedSubject;
    }
    public void setAssignedSubject(Subject assignedSubject) {
        this.assignedSubject = assignedSubject;
    }
    // Check if a class is available
    public static boolean isAvailableClassRoom(int classNo) {
        for (ClassRoom room : availableClasses) {
            if (room.getClassNo() == classNo) {
                return true;
            }
        }
        return false;
    }
    public static boolean isClassTaken(int classNo) {
        for (ClassRoom room : availableClasses) {
            if (room.getClassNo() == classNo && room.getAssignedTeacher() != null) {
                return true; // Class is taken
            }
        }
        return false; // Class is not taken
    }

    // Display available and unavailable classes
    public static void displayAvailableAndUnavailableClasses() {
        Set<String> printedClasses = new HashSet<>();
        Set<String> unavailableClasses = new HashSet<>();
        Table taClass2 = new Table(5, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle2 = new CellStyle(CellStyle.HorizontalAlign.center);
        taClass2.addCell("Class ID ", cellStyle2);
        taClass2.addCell("Class Name", cellStyle2);
        taClass2.addCell("Teacher ID ", cellStyle2);
        taClass2.addCell("Teacher Name", cellStyle2);
        taClass2.addCell("Subject Name ", cellStyle2);
        taClass2.setColumnWidth(0, 20, 30);
        taClass2.setColumnWidth(1, 20, 30);
        taClass2.setColumnWidth(2, 20, 30);
        taClass2.setColumnWidth(3, 20, 30);
        taClass2.setColumnWidth(4, 20, 30);
        System.out.println("កាលវិភាគដែលមាននៅក្នុង System");
        for (ClassRoom room : availableClasses) {
            if (room.getAssignedTeacher() != null) {
                String classKey = room.getClassNo() + room.getClassName();
                unavailableClasses.add(classKey);
                taClass2.addCell(String.valueOf(room.getClassNo()), cellStyle2);
                taClass2.addCell(room.getClassName(), cellStyle2);
                taClass2.addCell(String.valueOf(room.getAssignedTeacher().getId()), cellStyle2);
                taClass2.addCell(room.getAssignedTeacher().getName(), cellStyle2);
                taClass2.addCell(room.getAssignedSubject().getSubName(), cellStyle2);
            }
        }
        System.out.println(taClass2.render());
        Table taClass = new Table(2, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        taClass.addCell("Class No ", cellStyle);
        taClass.addCell("Class Name", cellStyle);
        taClass.setColumnWidth(0, 20, 30);
        taClass.setColumnWidth(1, 20, 30);
        System.out.println("ថ្នាក់ដែលនៅសល់អាចដាក់គ្រូបង្តៀនបានបានបង្ហាញនៅខាងក្រោម..!:");
        for (ClassRoom room : availableClasses) {
            String classKey = room.getClassNo() + room.getClassName();
            if (room.getAssignedTeacher() == null && !unavailableClasses.contains(classKey) && !printedClasses.contains(classKey)) {
                taClass.addCell(String.valueOf(room.getClassNo()));
                taClass.addCell(room.getClassName());
                printedClasses.add(classKey);
            }
        }
        System.out.println(taClass.render());
    }
    public static void assignTeacherToClass(Teacher teacher, Subject subject, int classNo, String shiftName) {
        for (ClassRoom room : availableClasses) {
            if (room.getClassNo() == classNo) {
                if (room.getAssignedTeacher() != null) {
                    System.out.println("Class already has a teacher assigned ");
                    return; // Exit the method if the class already has a teacher assigned
                }
                room.setAssignedTeacher(teacher);
                room.setAssignedSubject(subject);
                System.out.println("Teacher assigned successfully to class " + classNo + " in " + shiftName + " shift.");
                System.out.println("Teacher " + teacher.getName() + " added to class " + classNo + " for subject " + subject.getSubName());
                return;
            }
        }
        System.out.println("Class not found ");
    }
}
