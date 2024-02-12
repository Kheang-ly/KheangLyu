import java.util.ArrayList;
import java.util.Objects;

public class Subject {
    private int subID;
    private String subName;
   // private static ArrayList<Subject> subjects=new ArrayList<>();
    public Subject (int subID,String subName)
    {
        this.subID=subID;
        this.subName=subName;
      //  subjects.add(this);
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
    public static boolean is_SubjectID_Available(Subject subject,int id)
    {
        if(Objects.equals(subject.subID,id))
            return true;
        return false;
    }
    public static void check(Subject subject,int id)
    {
            if(is_SubjectID_Available(subject,id))
            {
                System.out.print(" Subject ID: ".concat(subject.getSubID()+""));
                System.out.println(" subject Name: ".concat(subject.getSubName()));
                return;
            }
        System.out.println(" Subject not found ");
    }
}
