import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;

public class Shift {

    String shiftName;
    private ArrayList<ClassRoom> classRooms=new ArrayList<>();

    public Shift() {
    }
    public Shift(String shiftName) {
        this.shiftName=shiftName;
        switch (shiftName) {
            case "Morning" -> {
                ClassRoom classes1 = new ClassRoom(101, "M150");
                ClassRoom classes2 = new ClassRoom(102, "M160");
                ClassRoom classes3 = new ClassRoom(103, "M170");
                ClassRoom classes4 = new ClassRoom(104, "M180");
                ClassRoom classes5 = new ClassRoom(105, "M190");
                classRooms.add(classes1);
                classRooms.add(classes2);
                classRooms.add(classes3);
                classRooms.add(classes4);
                classRooms.add(classes5);
            }
            case "Afternoon" -> {
                ClassRoom classes1 = new ClassRoom(201, "A150");
                ClassRoom classes2 = new ClassRoom(202, "A160");
                ClassRoom classes3 = new ClassRoom(203, "A170");
                ClassRoom classes4 = new ClassRoom(204, "A180");
                ClassRoom classes5 = new ClassRoom(205, "A190");
                classRooms.add(classes1);
                classRooms.add(classes2);
                classRooms.add(classes3);
                classRooms.add(classes4);
                classRooms.add(classes5);
            }
            case "Evening" -> {
                ClassRoom classes1 = new ClassRoom(301, "E150");
                ClassRoom classes2 = new ClassRoom(302, "E160");
                ClassRoom classes3 = new ClassRoom(303, "E170");
                ClassRoom classes4 = new ClassRoom(304, "E180");
                ClassRoom classes5 = new ClassRoom(305, "E190");
                classRooms.add(classes1);
                classRooms.add(classes2);
                classRooms.add(classes3);
                classRooms.add(classes4);
                classRooms.add(classes5);
            }
        }
    }
    public String getShiftName() {
        return shiftName;
    }
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
    public ArrayList<ClassRoom> getClassRooms() {
        return classRooms;
    }
    public void setClassRooms(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }
    //check in class schetdule line 6
    public static void display(Shift s) {
        Table taShift = new Table(2, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        taShift.addCell("Class No ", cellStyle);
        taShift.addCell("Class Name", cellStyle);
        taShift.setColumnWidth(0, 20, 30);
        taShift.setColumnWidth(1, 20, 30);
        System.out.println(s.getShiftName());
        for (int i = 0; i < s.getClassRooms().size(); i++) {
            taShift.addCell(s.getClassRooms().get(i).getClassName(), cellStyle);
            taShift.addCell(String.valueOf(s.getClassRooms().get(i).getClassNo()), cellStyle);
        }
        System.out.println(taShift.render());
    }

}