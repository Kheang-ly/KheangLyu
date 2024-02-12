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

    // Display available and unavailable classes
    public static void displayAvailableAndUnavailableClasses() {
        Set<String> printedClasses = new HashSet<>();
        Set<String> unavailableClasses = new HashSet<>();

        System.out.println("Unavailable Classes:");
        for (ClassRoom room : availableClasses) {
            if (room.getAssignedTeacher() != null) {
                String classKey = room.getClassNo() + room.getClassName();
                unavailableClasses.add(classKey);
                System.out.println("Class ID: " + room.getClassNo() + ", Class Name: " + room.getClassName() +
                        ", Assigned Teacher: " + room.getAssignedTeacher().getName() + " (ID: " + room.getAssignedTeacher().getId() +
                        "), Assigned Subject: " + room.getAssignedSubject().getSubName() + " (ID: " + room.getAssignedSubject().getSubID() + ")");
            }
        }
        System.out.println("Available Classes:");
        for (ClassRoom room : availableClasses) {
            String classKey = room.getClassNo() + room.getClassName();
            if (room.getAssignedTeacher() == null && !unavailableClasses.contains(classKey) && !printedClasses.contains(classKey)) {
                System.out.println("Class ID: " + room.getClassNo() + ", Class Name: " + room.getClassName());
                printedClasses.add(classKey);
            }
        }
    }


    // Assign teacher to class
    public static void assignTeacherToClass(Teacher teacher, Subject subject,int classNo,String shiftname) {
        for (ClassRoom room : availableClasses) {
            if (room.getClassNo() == classNo) {
                room.setAssignedTeacher(teacher);
                room.setAssignedSubject(subject);
                break;
            }
        }
    }
}
