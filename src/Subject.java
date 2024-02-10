import java.util.ArrayList;
import java.util.Objects;

public class Subject {
    private int subID;
    private String subName;
    private static ArrayList<Subject> subjects=new ArrayList<>();
    public Subject (int subID,String subName)
    {
        this.subID=subID;
        this.subName=subName;
    }
    public int getSubID() {
        return subID;
    }

    public void setSubID(int subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public static ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public static void setSubjects(ArrayList<Subject> subjects) {
        Subject.subjects = subjects;
    }
    public static boolean is_SubjectID_Available(Subject subject,int id)
    {
        if(Objects.equals(subject.subID,id))
            return true;
        return false;
    }
    public static void check(int id)
    {
        for(int i=0;i<subjects.size();i++)
        {
            if(is_SubjectID_Available(subjects.get(i),id))
            {
                System.out.print(" Subject ID: ".concat(subjects.get(i).subID+""));
                System.out.println(" subject Name: ".concat(subjects.get(i).subName));
                return;
            }
        }
        System.out.println(" Subject not found ");
    }
}
