<<<<<<< HEAD

=======
>>>>>>> origin/main
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

<<<<<<< HEAD
=======
import java.nio.file.attribute.AclEntry;
>>>>>>> origin/main
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
<<<<<<< HEAD
                System.out.println(green + "1.ពិនិត្យមើលព័ត៏មានរបស់គ្រូបង្រៀន");
                System.out.println("2.ពិនិត្យមើលព័ត៏មានវេនសិក្សានឹងថ្នាក់សិក្សា");
                System.out.println("3. ដាក់បញ្ចុលគ្រូទៅតាមថ្នាក់បង្រៀន");
                System.out.println("4.ពិនិត្យមើលព័ត៏មានថ្នាក់ដែលបង្រៀនបាននឹងបង្រៀនមិនបាន");
                System.out.println("5.ចាកចេញ");
                System.out.print("ជ្រើសរើសជម្រើស(1-4)ខាងលើ : " + reset);
=======
                System.out.println(green + "1. Check teachers");
                System.out.println("2. Check shift");
                System.out.println("3. Add teacher to class");
                System.out.println("4. Check all information");
                System.out.print("Choose an option above : " + reset);
>>>>>>> origin/main
                choosedOption = sc.nextInt();
                System.out.println(HORIZONTAL_BORDER.repeat(60) + "\n");
                switch (choosedOption) {
                    case 1:
                        Schedule.showAllTeacher();
                        break;
                    case 2:
                        int numberShift;
<<<<<<< HEAD
                        System.out.print("ជាដំបូងសូមជ្រើសរើសយកវេនសិក្សាជាមុនសិន(1/ព្រឹក, 2/រសៀល, 3/ល្ងាច): ");
=======
                        System.out.print("Please choose a shift to check (1/Morning, 2/Afternoon, 3/Evening): ");
>>>>>>> origin/main
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
<<<<<<< HEAD
                                System.out.println("សូមអធ្យាស្រ័យ!សូមពិនិត្យមើលការជ្រើសរើសរបស់អ្នកសារជាថ្មី។\n" +
                                        "Sorry you choosed invalid option please check you option again..");
=======
                                System.out.println("Invalid option.");
>>>>>>> origin/main
                                break;
                        }
                        break;
                    case 3:
<<<<<<< HEAD
                        System.out.println("ដាក់បញ្ចុលគ្រូទៅកាន់ថ្នាក់បង្រៀន");
                        int teacherId;
                        boolean checkID = true;
                        do {
                            System.out.print("សូមបញ្ចូលលេខសម្គាល់របស់គ្រូ : ");
                            teacherId = sc.nextInt();
                            for (Teacher t : Teacher.getTeachers()) {
                                if (t.getId() == teacherId) {
                                    checkID = false;
                                }
                            }
                            if (checkID)
                                System.out.println("អត់មានគ្រូដែលអ្នកបញ្ចូលនោះទេ....! ");
                        } while (checkID);
                        System.out.println("សូមជ្រើសរើសវេនសិក្សាដែលបានបង្ហាញនៅខាងក្រោម :");
                        System.out.print("""
                                1/ព្រឹក
                                2/រសៀល
                                3/ល្ងាច
                                 """);
                        System.out.print("ជម្រើសរបស់អ្នក: ");
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
                                System.out.println("សូមជ្រើសរើសម្តងទៀត។");
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
                            System.out.println("ថ្នាក់ដែលអាចបញ្ចលនៅវេន(" + shiftName + ")ត្រូវបានបង្ហាញនៅខាងក្រោម");
                            ta.addCell("Class No ", cellStyle);
                            ta.addCell("Class Name " , cellStyle);
                            for (ClassRoom cr : shift.getClassRooms()) {
                                ta.addCell(String.valueOf(cr.getClassNo()) , cellStyle);
                                ta.addCell(cr.getClassName() , cellStyle);
                            }
                            System.out.println(ta.render());
                            int classChoice;
                            boolean validClassChoice;
                            boolean classTaken;
                            ClassRoom classRoom = null;
                            do {
                                validClassChoice = false;
                                classTaken = false;
                                System.out.print("សូមជ្រើសរើសថ្នាក់ដែលលោកអ្នកចង់បង្រៀន: ");
                                classChoice = sc.nextInt();
                                if (ClassRoom.isClassTaken(classChoice)) {
                                    System.out.println("ថ្នាក់ដែលអ្នកបានជ្រើសរើសគឺមានគ្រូបង្រៀនរួចហោះយ");
                                    classTaken = true;
                                }
                                for (ClassRoom cr : shift.getClassRooms()) {
                                    if (cr.getClassNo() == classChoice) {
                                        classRoom = cr;
                                        validClassChoice = true;
                                        break;
                                    }
                                }
                            } while (classTaken);
                            if (validClassChoice) {
                                System.out.println("ពួកយើងបានបញ្ចុលគ្រូបង្រៀនចូលទៅថ្នាក់ " + classRoom.getClassName() + "  នៅក្នុងេវេន( " + shiftName + ") បានជោគជ័យ ។");
                                int subjectId;
                                boolean checkSubject = true;
                                do {
                                    System.out.print("សូមបញ្ចូលលេខសម្កាល់របស់មុខវិទ្យា : : ");
                                    subjectId = sc.nextInt();
                                    for (Subject s : schedule.getSubjects()) {
                                        if (s.getSubID() == subjectId)
                                            checkSubject = false;
                                    }
                                    if (checkSubject)
                                        System.out.println("មិនមានលេខសម្កាល់របស់មុខវិទ្យាដែលលោកអ្នកបញ្ចុលនោះទេ។ ");
                                } while (checkSubject);
                                // Debug statements to check input values
//                                System.out.println("Teacher ID : " + teacherId);
//                                System.out.println("Class ID :   " + classChoice);
//                                System.out.println("Subject ID : " + subjectId);
=======
                        Table table = new Table(1, BorderStyle.UNICODE_BOX, ShownBorders.SURROUND);
                        table.setColumnWidth(0,30,40);
                        System.out.println(blue + "Adding teacher to class:");
                        System.out.print("Enter teacher ID : ");
                        int teacherId = sc.nextInt();
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
                            ta.addCell("Class No" , cellStyle);
                            ta.addCell("Class Name " , cellStyle);
                            for (ClassRoom cr : shift.getClassRooms()) {
                                ta.addCell(String.valueOf(cr.getClassNo()) , cellStyle);
                                ta.addCell(cr.getClassName() , cellStyle);
//                                System.out.println("\t" + cr.getClassNo() + ". " + cr.getClassName());
                            }
                            System.out.println(ta.render());
                            System.out.print("Choose a class : ");
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
                                System.out.print("Enter subject ID : ");
                                int subjectId = sc.nextInt();
                                // Debug statements to check input values
                                System.out.println("Teacher ID : " + teacherId);
                                System.out.println("Class ID :   " + classChoice);
                                System.out.println("Subject ID : " + subjectId);
>>>>>>> origin/main
                                // Find teacher, class, and subject objects
                                Teacher teacherToAdd = null;
                                for (Teacher t : Teacher.getTeachers()) {
                                    if (t.getId() == teacherId) {
                                        teacherToAdd = t;
<<<<<<< HEAD
                                        //System.out.println("Found teacher: " + teacherToAdd.getName());
=======
                                        System.out.println("Found teacher: " + teacherToAdd.getName());
>>>>>>> origin/main
                                        break;
                                    }
                                }
                                Subject subjectToAdd = null;
                                for (Subject s : schedule.getSubjects()) {
                                    if (s.getSubID() == subjectId) {
                                        subjectToAdd = s;
<<<<<<< HEAD
                                       // System.out.println("Found subject: " + subjectToAdd.getSubName());
=======
                                        System.out.println("Found subject: " + subjectToAdd.getSubName());
>>>>>>> origin/main
                                        break;
                                    }
                                }
                                // Add teacher to class if all objects are found
                                if (teacherToAdd != null && subjectToAdd != null) {
                                    ClassRoom.assignTeacherToClass(teacherToAdd, subjectToAdd, classChoice, shiftName);
<<<<<<< HEAD
                                    System.out.println("ួកយើងបានបញ្ចុលគ្រូបង្រៀនចូលទៅថ្នាក់  " + classChoice + "នៅក្នុងេវេន( " + shiftName + " ) បានជោគជ័យ ។");
                                    System.out.println("លោកគ្រូ/អ្នកគ្រូឈ្មោះ : " + teacherToAdd.getName() + " បានបញ្ចូលទៅក្នុងថ្នាក់  " + classRoom.getClassName() + " for subject " + subjectToAdd.getSubName());
                                    if (!ClassRoom.isAvailableClassRoom(classChoice)) {
                                        System.out.println("ថ្នាក់ដែលបានជ្រើសរើសមិនមានក្នុងជម្រើសលើយ៕ សូមពិនិត្យមើលការជ្រើសរើសសារជាថ្មី។");
=======
                                    System.out.println("Teacher assigned successfully to class " + classChoice + " in " + shiftName + " shift.");
                                    System.out.println("Teacher " + teacherToAdd.getName() + " added to class " + classRoom.getClassName() + " for subject " + subjectToAdd.getSubName());
                                    if (!ClassRoom.isAvailableClassRoom(classChoice)) {
                                        System.out.println("Invalid class choice. Class not available.");
>>>>>>> origin/main
                                        break;
                                    }
                                    // Adding allocation
                                    TimeSlot timeSlot = new TimeSlot("", "", ""); // Placeholder values for day, start time, and end time
                                    schedule.addAllocation(teacherToAdd, subjectToAdd, classRoom, timeSlot);
                                } else {
<<<<<<< HEAD
                                    System.out.println("មានបញ្ចុលព័តមានរបស់លោកង្នកមានបញ្ហា។ សូមធ្វើការបំពេញព័ត៏មានសារជាថ្មិ៕");
                                }
                            } else {
                                System.out.println("្នាក់ដែលបានជ្រើសរើសមិនមានក្នុងជម្រើសលើយ៕ សូមពិនិត្យមើលការជ្រើសរើសសារជាថ្មី។");
=======
                                    System.out.println("Something went wrong.");
                                }
                            } else {
                                System.out.println("Invalid class choice.");
>>>>>>> origin/main
                            }
                        }
                        break;

                    case 4:
<<<<<<< HEAD
                        System.out.println("ព័ត៏មានរបស់កាលវិភាគ");
                        System.out.println("Shifts:");
                        for (Shift shift : new Shift[]{new Shift("Morning"), new Shift("Afternoon"), new Shift("Evening")}) {
                            // Shift.display(shift);
                            System.out.print("");
                        }
                        System.out.println("ថ្នាក់រៀនដេលមាននៅក្នុងការគ្រប់គ្រង");
                        ClassRoom.displayAvailableAndUnavailableClasses();
                        break;
                    case 0:
                        System.out.println("កំពុងចាកចេញ.........!");
                        break;
                    default:
                        System.out.println("សូមព្យាយាមម្តងទៀត.....!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("សូមព្យាយាមម្តងទៀត.....!");
=======
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
>>>>>>> origin/main
                // Clear the input buffer
                sc.nextLine();
                choosedOption = -1; // Reset the option to force the loop to continue
            }
        } while (choosedOption != 0);
    }
}
