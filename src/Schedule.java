import java.util.ArrayList;

public class Schedule {
    ArrayList<Teacher> t=Teacher.getTeachers();
    Schedule()
    {
        Teacher teacher = new Teacher(1,"Sza","male");
        Teacher teacher1 = new Teacher(2,"Justint","male");
        Teacher teacher2 = new Teacher(3,"Weeken","male");
        t.add(teacher);
    }

}
