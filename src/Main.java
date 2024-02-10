public class Main {
    public static void main(String[] args) {
//        Teacher[] teachers = new Teacher[2];
//        teachers[0] = new Teacher(1,"Sza","male");
//        teachers[1] = new Teacher(2,"Justint","male");
        Teacher teacher = new Teacher(1,"Sza","male");
        Teacher teacher1 = new Teacher(2,"Justint","male");
        Teacher teacher2 = new Teacher(3,"Weeken","male");


        Teacher.check(4);
        System.out.println();
        Subject sub1=new Subject(12,"Java");
        Subject sub2=new Subject(13,".NET");
        Subject sub3=new Subject(14,"Statistic");
        Subject sub4=new Subject(15,"Network");
        Subject sub5=new Subject(16,"System Analysis");
        Subject.check(14);

    }
}
