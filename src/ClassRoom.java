import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class ClassRoom {
    private boolean assigned = false; // Track if the class is assigned
    private Teacher assignedTeacher; // Reference to the assigned teacher
    private Subject assignedSubject; // Reference to the assigned subject
    private int classNo;
    private String className;
    private static ArrayList<ClassRoom> classes = new ArrayList<>();

    public ClassRoom(int classNo, String className) {
        this.classNo = classNo;
        this.className = className;
        classes.add(this);
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public Subject getAssignedSubject() {
        return assignedSubject;
    }
    public static ClassRoom getClassRoomById(int id) {
        for (ClassRoom classroom : classes) {
            if (classroom.getClassNo() == id) {
                return classroom;
            }
        }
        return null;
    }
    public static boolean isAvailableClassRoom(int classNo) {
        for (ClassRoom classroom : classes) {
            if (classroom.getClassNo() == classNo && !classroom.isAssigned()) {
                return true;
            }
        }
        return false;
    }

    public static void assignTeacherToClass(Teacher teacher, Subject subject, int classNo, String shiftName) {
        ClassRoom classRoom = getClassRoomById(classNo);
        if (classRoom != null && !classRoom.isAssigned()) {
            classRoom.assignedTeacher = teacher;
            classRoom.assignedSubject = subject;
            classRoom.assigned = true;
        }
    }

    public static void displayAvailableAndUnavailableClasses() {
        HashSet<ClassRoom> uniqueClasses = new HashSet<>(classes);

        boolean availableExist = false;
        boolean unavailableExist = false;

        System.out.println("Available Classes:");
        for (ClassRoom classroom : uniqueClasses) {
            if (!classroom.isAssigned()) {
                System.out.println("Class ID: " + classroom.getClassNo() + ", Class Name: " + classroom.getClassName());
                availableExist = true;
            }
        }

        if (!availableExist) {
            System.out.println("No available classes.");
        }

        System.out.println("\nUnavailable Classes:");
        for (ClassRoom classroom : uniqueClasses) {
            if (classroom.isAssigned()) {
                Teacher teacher = classroom.getAssignedTeacher();
                Subject subject = classroom.getAssignedSubject();
                System.out.println("Class ID: " + classroom.getClassNo() + ", Class Name: " + classroom.getClassName() +
                        ", Assigned Teacher: " + teacher.getName() + " (ID: " + teacher.getId() + "), Assigned Subject: " + subject.getSubName() + " (ID: " + subject.getSubID() + ")");
                unavailableExist = true;
            }
        }

        if (!unavailableExist) {
            System.out.println("No unavailable classes.");
        }
    }

    // Other methods...
}
