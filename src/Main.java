import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.nio.file.attribute.AclEntry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements BoxBorder{
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
            try {
                System.out.println(HORIZONTAL_BORDER.repeat(60));
                System.out.println(green + "1. Check teachers");
                System.out.println("2. Check shift");
                System.out.println("3. Add teacher to class");
                System.out.println("4. Check all information");
                System.out.print("Choose an option above : " + reset);
                choosedOption = sc.nextInt();
                System.out.println(HORIZONTAL_BORDER.repeat(60) + "\n");
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
                        Table table = new Table(1, BorderStyle.UNICODE_BOX, ShownBorders.SURROUND);
                        table.setColumnWidth(0,30,40);
                        System.out.println(blue + "Adding teacher to class");
                        int teacherId;
                        boolean checkID=true;
                        do
                        {
                            System.out.print("Enter teacher ID : ");
                            teacherId = sc.nextInt();
                            for(Teacher t:Teacher.getTeachers())
                            {
                                if(t.getId()==teacherId)
                                {
                                    checkID=false;
                                }
                            }
                            if(checkID)
                                System.out.println("អត់មានគ្រូ ");
                        }while(checkID);

                        table.addCell(" ".repeat(7) + "1. Morning");
                        table.addCell(" ".repeat(7) + "2. Afternoon");
                        table.addCell(" ".repeat(7) + "3. Evening");
                        System.out.println(table.render());
                        System.out.print("Choose shift : " + reset);
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
                            Table ta = new Table(2, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
                            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
                            ta.setColumnWidth(0,20,30);
                            ta.setColumnWidth(1,20,30);
                            System.out.println();
                            System.out.println(HORIZONTAL_BORDER.repeat(60));
                            Shift shift = new Shift(shiftName);
                            System.out.println(magenta + "Classes available in " + shiftName + " shift:");
                            ta.addCell("Class No " , cellStyle);
                            ta.addCell("Class Name " , cellStyle);
                            for (ClassRoom cr : shift.getClassRooms()) {
                                ta.addCell(String.valueOf(cr.getClassNo()) , cellStyle);
                                ta.addCell(cr.getClassName() , cellStyle);
//                                System.out.println("\t" + cr.getClassNo() + ". " + cr.getClassName());
                            }
                            System.out.println(ta.render());
                            int classChoice;
                            boolean validClassChoice;
                            boolean classTaken;
                            ClassRoom classRoom = null;
                            do
                            {
                                validClassChoice = false;
                                classTaken=false;
                                System.out.print("Choose a class : ");
                                classChoice = sc.nextInt();
                                if(ClassRoom.isClassTaken(classChoice))
                                {
                                    System.out.println("Class already taken! ");
                                    classTaken=true;
                                }
                                for (ClassRoom cr : shift.getClassRooms()) {
                                    if (cr.getClassNo() == classChoice) {
                                        classRoom = cr;
                                        validClassChoice = true;
                                        break;
                                    }
                                }
                            }while(classTaken);
                            if (validClassChoice) {
                                System.out.println("Class " + classRoom.getClassName() + " selected in " + shiftName + " shift.");
                                int subjectId;
                                boolean checkSubject=true;
                                do
                                {
                                    System.out.print("Enter subject ID : ");
                                    subjectId = sc.nextInt();
                                    for(Subject s:schedule.getSubjects())
                                    {
                                        if(s.getSubID()==subjectId)
                                            checkSubject=false;
                                    }
                                    if(checkSubject)
                                        System.out.println("Subject ID not found! ");
                                }while(checkSubject);
                                // Debug statements to check input values
                                System.out.println("Teacher ID : " + teacherId);
                                System.out.println("Class ID :   " + classChoice);
                                System.out.println("Subject ID : " + subjectId);
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
                        for (Shift shift : new Shift[]{new Shift("Morning"), new Shift("Afternoon"), new Shift("Evening")}) {
                            Shift.display(shift);
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                // Clear the input buffer
                sc.nextLine();
                choosedOption = -1; // Reset the option to force the loop to continue
            }
        } while (choosedOption != 0);
    }
}