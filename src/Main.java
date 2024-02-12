import javax.print.attribute.standard.SheetCollate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choosedOption;
        String ShiftName = "";

        Schedule schedule = new Schedule();
        Shift _shift = new Shift(ShiftName);
        Teacher teacher = new Teacher(1, "Sza", "male");
        Teacher teacher1 = new Teacher(2, "Justint", "male");
        Teacher teacher2 = new Teacher(3, "Weeken", "male");
        Teacher teacher4 = new Teacher(3, "Woko", "female");
        Teacher teacher5 = new Teacher(3, "ello", "female");

        do {
            System.out.println("check teacher");
            System.out.println("check shift");
            System.out.println("Add teacher to class");
            System.out.println("check all information");
            System.out.print("Choose Option above first bro:");
            choosedOption = sc.nextInt();
            System.out.println("===========================><=================================");
            switch (choosedOption) {
                case 1:
                    Schedule.showAllTeacher();
                    break;
                case 2:
                    int numberShift;
                    System.out.print("please choose shift that you want to check(" +
                            "\t1/Morning" +
                            "\t2/Afternoon" +
                            "\t3/Evening " +
                            "please choose option (1 , 2, 3))\t:");
                    numberShift = sc.nextInt();
                    switch (numberShift) {
                        case 1:
                            ShiftName = "";
                            ShiftName = "Morning";
                            Shift shiftMorning = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftMorning);
                            ShiftName = "";
                            break;
                        case 2:
                            ShiftName = "";
                            ShiftName = "Afternoon";
                            Shift shiftAfternoon = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftAfternoon);
                            ShiftName = "";
                            break;
                        case 3:
                            ShiftName = "";
                            ShiftName = "Evening";
                            Shift shiftEvening = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftEvening);
                            ShiftName = "";
                            break;
                        default:
                            ShiftName = "";
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Adding teacher to class:");
                    System.out.println("Enter teacher ID:");
                    int teacherId = sc.nextInt();
                    System.out.println("Choose shift:");
                    System.out.println("\t1. Morning");
                    System.out.println("\t2. Afternoon");
                    System.out.println("\t3. Evening");
                    int shiftChoice = sc.nextInt();
                    ShiftName = ""; // Reset ShiftName here
                    switch (shiftChoice) {
                        case 1:
                            ShiftName = "Morning";
                            break;
                        case 2:
                            ShiftName = "Afternoon";
                            break;
                        case 3:
                            ShiftName = "Evening";
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    if (!ShiftName.isEmpty()) {
                        Shift shift = new Shift(ShiftName);
                        System.out.println("Classes available in " + ShiftName + " shift:");
                        for (ClassRoom cr : shift.getClassRooms()) {
                            System.out.println("\t" + cr.getClassNo() + ". " + cr.getClassName());
                        }
                        System.out.println("Choose a class:");
                        int classChoice = sc.nextInt();
                        ClassRoom classRoom = null;
                        for (ClassRoom cr : shift.getClassRooms()) {
                            if (cr.getClassNo() == classChoice) {
                                classRoom = cr;
                                break;
                            }
                        }
                        if (classRoom != null) {
                            System.out.println("Class " + classRoom.getClassName() + " selected in " + ShiftName + " shift.");
                        } else {
                            System.out.println("Invalid class choice.");
                        }
                    }
                    System.out.println("Enter class ID:");
                    int classId = sc.nextInt();
                    System.out.println("Enter subject ID:");
                    int subjectId = sc.nextInt();
                    // Debug statements to check input values
                    System.out.println("Teacher ID: " + teacherId);
                    System.out.println("Class ID: " + classId);
                    System.out.println("Subject ID: " + subjectId);
                    // Find teacher, class, and subject objects
                    Teacher teacherToAdd = null;
                    for (Teacher t : Teacher.getTeachers()) {
                        if (t.getId() == teacherId) {
                            teacherToAdd = t;
                            System.out.println("Found teacher: " + teacherToAdd.getName());
                            break;
                        }
                    }
                    ClassRoom classRoom = null;
                    Shift shift = new Shift(ShiftName);
                    for (ClassRoom cr : shift.getClassRooms()) {
                        if (cr.getClassNo() == classId) {
                            classRoom = cr;
                            System.out.println("Found class: " + classRoom.getClassName());
                            break;
                        }
                    }
                    Subject subject = null;
                    for (Subject s : schedule.getSubjects()) {
                        if (s.getSubID() == subjectId) {
                            subject = s;
                            System.out.println("Found subject: " + subject.getSubName());
                            break;
                        }
                    }
                    // Add teacher to class if all objects are found
                    if (teacherToAdd != null && classRoom != null && subject != null) {
                        System.out.println("Teacher " + teacherToAdd.getName() + " added to class " + classRoom.getClassName() + " for subject " + subject.getSubName());
                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        } while (choosedOption != 0);
    }
}
