import javax.print.attribute.standard.SheetCollate;
import java.util.Scanner;

public class Main {
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int choosedOption;
        String ShiftName = "";
        Schedule schedule=new Schedule();

        Shift _shift=new Shift(ShiftName);
        Teacher teacher = new Teacher(1,"Sza","male");
        Teacher teacher1 = new Teacher(2,"Justint","male");
        Teacher teacher2 = new Teacher(3,"Weeken","male");
        Teacher teacher4 = new Teacher(3,"Woko","female");
        Teacher teacher5 = new Teacher(3,"ello","female");

        // Schedule.show(schedule);
        /// check teacher fist
        System.out.println("check teacher");
        System.out.println("check shift");
        System.out.println("Add teacher to class");
        System.out.println("check all information");
        System.out.print("Choose Option above first bro:");choosedOption=sc.nextInt();
        System.out.println("===========================><=================================");
        switch (choosedOption){
            case 1:
                Schedule.showAllTeacher();
                break;
            case 2:
                int numberShift;
                System.out.print("please choouse shift that you want to check(" +
                        "\t1/Morning" +
                        "\t2/Afternoon" +
                        "\t3/Evening " +
                        "please choose option (1 , 2, 3))\t:");
                numberShift=sc.nextInt();
                    switch (numberShift){
                        case 1:
                            ShiftName="Morning";
                            Shift shiftMorning = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftMorning);
                            break;
                        case 2:
                            ShiftName="Afternoon";
                            Shift shiftAfternoon = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftAfternoon);
                            break;
                        case 3:
                            ShiftName="Evening";
                            Shift shiftEvening = new Shift(ShiftName);
                            Schedule.showShiftCheck(shiftEvening);
                            break;
                        default:
                            ShiftName="";
                            break;
                    }

                break;
        }











    }
}
