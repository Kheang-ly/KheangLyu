import java.util.ArrayList;
import java.util.Objects;

public class Teacher {

    private Integer id;
    private String name;
    private String gender;
    private static ArrayList<Teacher> teachers = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        teachers.add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(ArrayList<Teacher> teachers) {
        Teacher.teachers = teachers;
    }

    public static boolean isAvailableId ( Teacher teacher , Integer id ){
        if(Objects.equals(teacher.id, id)){
            return true;
        }
        return false;
    }

    public static void check( Integer id ){
        for( int i=0 ; i< teachers.size() ; i++ ){
            if( isAvailableId(teachers.get(i),id))
            {
                System.out.print(" ID : " + teachers.get(i).getId());
                System.out.print("\t\t Name : " + teachers.get(i).getName());
                System.out.print("\t\t Gender : " + teachers.get(i).getGender());
                System.out.println();
                return;
            }
        }
        System.out.println("  Teacher ID not found !!!");
    }

}
