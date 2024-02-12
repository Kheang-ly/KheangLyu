import java.util.ArrayList;

public class Schedule {
    static ArrayList<Teacher> t=Teacher.getTeachers();
    ArrayList<Subject> subjects=new ArrayList<>();

    // chnage this line to class main line 10
     private  Shift shift=new Shift();

    Schedule()
    {
        Subject sub1=new Subject(12,"Java");
        Subject sub2=new Subject(13,".NET");
        Subject sub3=new Subject(14,"Statistic");
        Subject sub4=new Subject(15,"Network");
        Subject sub5=new Subject(16,"System Analysis");
        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);
        subjects.add(sub5);
    }

    public ArrayList<Teacher> getT() {
        return t;
    }

    public void setT(ArrayList<Teacher> t) {
        this.t = t;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }


    public  Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


//    public static void show(Schedule schedule)
//    {
//        Subject.check(schedule.getSubjects().get(3),15);
//        Teacher.check(t.get(0).getId());
//        Shift.display(schedule.getShift());
//    }




    public  static void showAllTeacher(){
       for(int i=0; i<Teacher.getTeachers().size(); i++)
       {
           Teacher.check(t.get(i).getId());
       }
    }
    public  static void  showShiftCheck(Shift s){
        Shift.display(s);

    }




}
