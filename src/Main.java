import javax.print.attribute.standard.SheetCollate;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1,"Sza","male");
        Teacher teacher1 = new Teacher(2,"Justint","male");
        Teacher teacher2 = new Teacher(3,"Weeken","male");

        Schedule schedule=new Schedule();
        Schedule.show(schedule);
    }
}
