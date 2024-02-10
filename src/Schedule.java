import java.util.ArrayList;

public class Schedule {
    ArrayList<Teacher> t=Teacher.getTeachers();
    ArrayList<Subject> subjects=new ArrayList<>();
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

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
    public static void show(Schedule schedule)
    {
        Subject.check(schedule.getSubjects().get(3),15);
    }
}
