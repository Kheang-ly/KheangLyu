import java.util.ArrayList;

public class Shift {

    String shiftName;
    //private ClassRoom classes=new ClassRoom();
    private ArrayList<ClassRoom> classRooms=new ArrayList<>();

    public Shift() {
    }

    public Shift(String shiftName) {
        this.shiftName=shiftName;
        if(shiftName.equals("Morning"))
        {
            ClassRoom classes1=new ClassRoom(101,"M150");
            ClassRoom classes2=new ClassRoom(102,"M160");
            ClassRoom classes3=new ClassRoom(103,"M170");
            ClassRoom classes4=new ClassRoom(104,"M180");
            ClassRoom classes5=new ClassRoom(105,"M190");
            classRooms.add(classes1);
            classRooms.add(classes2);
            classRooms.add(classes3);
            classRooms.add(classes4);
            classRooms.add(classes5);

        }
        else if(shiftName.equals("Afternoon"))
        {
            ClassRoom classes1=new ClassRoom(102,"A160");
            classRooms.add(classes1);
        }
        else if (shiftName.equals("Evening")) {
            ClassRoom classes1=new ClassRoom(101,"E150");
            classRooms.add(classes1);
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

    public static void display(Shift s) {
        System.out.println(" Shift Name: " + s.getShiftName());
        for (int i=0;i<s.getClassRooms().size();i++) {
            System.out.print( " Class Available \t Class Name: "+s.getClassRooms().get(i).getClassName()+"\t");
            System.out.println("Class No: " + s.getClassRooms().get(i).getClassNo());
        }
    }
}
