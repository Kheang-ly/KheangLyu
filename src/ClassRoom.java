import java.util.ArrayList;
import java.util.Objects;

public class ClassRoom {

    private int classNo;
    private String className;
    private static ArrayList<ClassRoom> classes=new ArrayList<>();

    public ClassRoom() {
    }

    public ClassRoom(int classNo, String className ) {
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


    public static ArrayList<ClassRoom> getClasses() {
        return classes;
    }

    public static void setClasses(ArrayList<ClassRoom> classes) {
        ClassRoom.classes = classes;
    }

    public static boolean isAvailableClassRoom (ClassRoom classRoom , int id ){
        if(Objects.equals(classRoom.classNo,id)){
            return true;
        }
        return false;
    }


    public static void checkClassRoom ( int id ){
        for(int i=0;i<classes.size();i++)
        {
            if(isAvailableClassRoom(classes.get(i),id ))
            {
                System.out.println(" Class ID: ".concat(classes.get(i).classNo+"  "));
                System.out.println(" Class Name: ".concat(classes.get(i).className));
            }
        }
    }
}
