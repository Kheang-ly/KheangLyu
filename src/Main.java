import javax.print.attribute.standard.SheetCollate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1,"Sza","male");
        Teacher teacher1 = new Teacher(2,"Justint","male");
        Teacher teacher2 = new Teacher(3,"Weeken","male");
        ClassRoom classRoom = new ClassRoom();

        ClassRoom classRoom1 = new ClassRoom(101,"M1");
        ClassRoom classRoom2 = new ClassRoom(102,"M2");
//        ClassRoom.checkClassRoom(102);


        Schedule schedule = new Schedule();
        Schedule.show(schedule);



    }
}
