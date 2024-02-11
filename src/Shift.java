import java.util.ArrayList;

public class Shift {

    String shiftName;
    private ClassRoom classes=new ClassRoom();

    public Shift(String shiftName) {
        this.shiftName=shiftName;
        if(shiftName.equals("Morning"))
        {
            classes=new ClassRoom(101,"M150");
            classes=new ClassRoom(102,"M160");
            classes=new ClassRoom(103,"M170");
            classes=new ClassRoom(104,"M180");
            classes=new ClassRoom(105,"M190");
        }
        else if(shiftName.equals("Afternoon"))
        {
            classes=new ClassRoom(102,"A160");
        }
        else if (shiftName.equals("Evening")) {
            classes=new ClassRoom(101,"E150");
        }

    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public ClassRoom getClasses() {
        return classes;
    }

    public void setClasses(ClassRoom classes) {
        this.classes = classes;
    }

    public ClassRoom getClassess() {
        return classes;
    }

    public void setClassess(ClassRoom classess) {
        this.classes = classess;
    }

    public static void display(Shift s) {
        System.out.println(" Shift Name: " + s.getShiftName());
        for (int i=0;i<s.getClassess().getClasses().size();i++) {
            System.out.print( " Class Available \t Class Name: "+s.getClassess().getClasses().get(i).getClassName()+"\t");
            System.out.println("Class No: " + s.getClassess().getClasses().get(i).getClassNo());
        }
    }
}
