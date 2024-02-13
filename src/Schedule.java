import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.Map;

import static java.awt.Color.green;
import static java.awt.Color.magenta;

public class Schedule {
    private ArrayList<TimeSlot> timeSlots= new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();
    private static ArrayList<Shift> shifts;
    private Map<ClassRoom, Allocation> classAllocations; // Assuming Allocation class exists





    public Allocation getAllocationByClass(ClassRoom classRoom) {
        return classAllocations.get(classRoom);
    }


    public boolean isClassOccupied(ClassRoom classRoom) {
        return classAllocations.containsKey(classRoom);
    }
    // Constructor, getters, setters, etc.

    public static ArrayList<Shift> getShifts() {
        return shifts;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
   public Schedule()
    {
        Subject sub1=new Subject(12,"Java");
        Subject sub2=new Subject(13,".NET");
        Subject sub3=new Subject(14,"Statistic");
        Subject sub4=new Subject(15,"Network");
        Subject sub5=new Subject(16,"System Analysis");
        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);
        subjects.add(sub5);
    }
    public static void showShiftCheck(Shift shift) {
        Shift.display(shift);
    }
    public static void showAllTeacher() {
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        System.out.println("ព័ត៏មានរបស់គ្រូបង្រៀនត្រូវបានបង្ហាញខាងក្រោម");
        Table ta = new Table(3, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        ta.addCell("Teacher ID", cellStyle);
        ta.addCell("Teacher Name", cellStyle);
        ta.addCell("Teacher Gender", cellStyle);
        ta.setColumnWidth(0, 20, 30);
        ta.setColumnWidth(1, 20, 30);
        ta.setColumnWidth(2, 20, 30);
        for (Teacher teacher : teachers) {
            ta.addCell(teacher.getId().toString(), cellStyle);
            ta.addCell(teacher.getName(), cellStyle);
            ta.addCell(teacher.getGender(), cellStyle);
        }
        String greenColorCode = "\u001B[32m";
        String resetColorCode = "\u001B[0m";
        System.out.println(greenColorCode + ta.render() + resetColorCode);
    }
    public void addAllocation(Teacher teacher, Subject subject, ClassRoom room, TimeSlot timeSlot) {
        // Check for conflicts before adding the allocation
        if (!isConflicting(teacher, room, timeSlot)) {
            Allocation allocation = new Allocation(teacher, subject, room, timeSlot);
            timeSlot.addAllocation(allocation);
            timeSlots.add(timeSlot);
            System.out.println("សូមអរគុណ......!");
        } else {
            System.out.println("Conflict detected. Allocation cannot be added.");
        }
    }

    public void displaySchedule() {
        for (TimeSlot timeSlot : timeSlots) {
            System.out.println("Time Slot: " + timeSlot);
            for (Allocation allocation : timeSlot.getAllocations()) {
                System.out.println("\t" + allocation);
            }
        }
    }
    private boolean isConflicting(Teacher teacher, ClassRoom room, TimeSlot timeSlot) {
        for (TimeSlot existingTimeSlot : timeSlots) {
            if (existingTimeSlot.overlaps(timeSlot)) {
                for (Allocation allocation : existingTimeSlot.getAllocations()) {
                    if (allocation.getTeacher().equals(teacher) || allocation.getRoom().equals(room)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

