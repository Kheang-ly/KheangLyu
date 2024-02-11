import java.util.ArrayList;
import java.util.Objects;

public class ClassRoom {

    private int classNo;
    private String className;
    private static ArrayList<ClassRoom> classRooms = new ArrayList<>();

    public ClassRoom() {
    }

    public ClassRoom(int classNo, String className ) {
        this.classNo = classNo;
        this.className = className;
        classRooms.add(this);
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

    public static ArrayList<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public static void setClassRooms(ArrayList<ClassRoom> classRooms) {
        ClassRoom.classRooms = classRooms;
    }



    public static boolean isAvailableClassRoom (ClassRoom classRoom , int id ){
        if(Objects.equals(classRoom.classNo,id)){
            return true;
        }
        return false;
    }


    public static void checkClassRoom ( int id ){
        for( int i=0 ; i<classRooms.size() ; i++ ){
            if(isAvailableClassRoom(classRooms.get(i),id)){
                System.out.println(" Class Name : ".concat(classRooms.get(i).getClassName()));
                return;
            }
        }
        System.out.println(" Class number not found ");

    }

}
