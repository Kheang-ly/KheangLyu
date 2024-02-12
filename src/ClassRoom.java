
import java.util.Objects;

public class ClassRoom {

    private int classNo;
    private String className;
//    private static ArrayList<ClassRoom> classes=new ArrayList<>();

    public ClassRoom() {
    }

    public ClassRoom(int classNo, String className ) {
        this.classNo = classNo;
        this.className = className;
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


//    public static ArrayList<ClassRoom> getClasses() {
//        return classes;
//    }
//
//    public static void setClasses(ArrayList<ClassRoom> classes) {
//        ClassRoom.classes = classes;
//    }

    public static boolean isAvailableClassRoom (ClassRoom classRoom , int id ){
        if(Objects.equals(classRoom.classNo,id)){
            return true;
        }
        return false;
    }


    public static void checkClassRoom (ClassRoom c, int id ){
        System.out.print(" ClassName : "+c.getClassName());
        System.out.println(" Class No "+c.getClassNo());
    }
}
