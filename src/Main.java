import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choosedOption;
        String shiftName = "";
        Schedule schedule = new Schedule();
        Shift _shift = new Shift(shiftName);
        Teacher teacher = new Teacher(1, "Gola", "male");
        Teacher teacher1 = new Teacher(2, "John Wick", "male");
        Teacher teacher2 = new Teacher(3, "Ratha", "male");
        Teacher teacher4 = new Teacher(4, "Dara", "female");
        Teacher teacher5 = new Teacher(5, "Niza", "female");
        do {
            System.out.println("1. Check teachers");
            System.out.println("2. Check shift");
            System.out.println("3. Add teacher to class");
            System.out.println("4. Check all information");
            System.out.print("Choose an option above: ");
            choosedOption = sc.nextInt();
            System.out.println("===========================><=================================");
            switch (choosedOption) {
                case 1:
                    Schedule.showAllTeacher();
                    break;
                case 2:
                    int numberShift;
                    System.out.print("Please choose a shift to check (1/Morning, 2/Afternoon, 3/Evening): ");
                    numberShift = sc.nextInt();
                    switch (numberShift) {
                        /// must input number
                        case 1:
                            shiftName = "Morning";
                            Shift shiftMorning = new Shift(shiftName);
                            Schedule.showShiftCheck(shiftMorning);
                            break;
                        case 2:
                            shiftName = "Afternoon";
                            Shift shiftAfternoon = new Shift(shiftName);
                            Schedule.showShiftCheck(shiftAfternoon);
                            break;
                        case 3:
                            shiftName = "Evening";
                            Shift shiftEvening = new Shift(shiftName);
                            Schedule.showShiftCheck(shiftEvening);
                            break;
                        default:
                            System.out.println("Invalid option.");
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
                    switch (shiftChoice) {
                        case 1:
                            shiftName = "Morning";
                            break;
                        case 2:
                            shiftName = "Afternoon";
                            break;
                        case 3:
                            shiftName = "Evening";
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    if (!shiftName.isEmpty()) {
                        Shift shift = new Shift(shiftName);
                        System.out.println("Classes available in " + shiftName + " shift:");
                        for (ClassRoom cr : shift.getClassRooms()) {
                            System.out.println("\t" + cr.getClassNo() + ". " + cr.getClassName());
                        }
                        System.out.println("Choose a class:");
                        int classChoice = sc.nextInt();
                        boolean validClassChoice = false;
                        ClassRoom classRoom = null;
                        for (ClassRoom cr : shift.getClassRooms()) {
                            if (cr.getClassNo() == classChoice) {
                                classRoom = cr;
                                validClassChoice = true;
                                break;
                            }
                        }
                        if (validClassChoice) {
                            System.out.println("Class " + classRoom.getClassName() + " selected in " + shiftName + " shift.");
                            System.out.println("Enter subject ID:");
                            int subjectId = sc.nextInt();
                            // Debug statements to check input values
                            System.out.println("Teacher ID: " + teacherId);
                            System.out.println("Class ID: " + classChoice);
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
                            Subject subjectToAdd = null;
                            for (Subject s : schedule.getSubjects()) {
                                if (s.getSubID() == subjectId) {
                                    subjectToAdd = s;
                                    System.out.println("Found subject: " + subjectToAdd.getSubName());
                                    break;
                                }
                            }
                            // Add teacher to class if all objects are found
                            if (teacherToAdd != null && subjectToAdd != null) {
                                ClassRoom.assignTeacherToClass(teacherToAdd, subjectToAdd, classChoice, shiftName);
                                System.out.println("Teacher assigned successfully to class " + classChoice + " in " + shiftName + " shift.");
                                System.out.println("Teacher " + teacherToAdd.getName() + " added to class " + classRoom.getClassName() + " for subject " + subjectToAdd.getSubName());
                                if (!ClassRoom.isAvailableClassRoom(classChoice)) {
                                    System.out.println("Invalid class choice. Class not available.");
                                    break;
                                }
                                // Adding allocation
                                TimeSlot timeSlot = new TimeSlot("", "", ""); // Placeholder values for day, start time, and end time
                                schedule.addAllocation(teacherToAdd, subjectToAdd, classRoom, timeSlot);
                            } else {
                                System.out.println("Something went wrong.");
                            }
                        } else {
                            System.out.println("Invalid class choice.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("All Information:");
                    System.out.println("Shifts:");
                    for (Shift shiftt : new Shift[]{new Shift("Morning"), new Shift("Afternoon"), new Shift("Evening")}) {
                        Shift.display(shiftt);
                    }
                    System.out.println("Classrooms:");
                    ClassRoom.displayAvailableAndUnavailableClasses();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        } while (choosedOption != 0);
    }
}