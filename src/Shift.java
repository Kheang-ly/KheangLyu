public class Shift {
    private String morning1;
    private String morning2;
    private String afternoon1;
    private String afternoon2;
    private String evening1;
    private String evening2;
    private ClassRoom classRoom;

    public Shift(String morning1, String morning2, String afternoon1, String afternoon2, String evening1, String evening2, ClassRoom classRoom) {
        this.morning1 = morning1;
        this.morning2 = morning2;
        this.afternoon1 = afternoon1;
        this.afternoon2 = afternoon2;
        this.evening1 = evening1;
        this.evening2 = evening2;
        this.classRoom = classRoom;
    }

    // Constructor for morning shift only
    public Shift(String morning1, String morning2, ClassRoom classRoom) {
        this.morning1 = morning1;
        this.morning2 = morning2;
    }

    // Getters and setters for all properties
    public String getMorning1() {
        return morning1;
    }

    public void setMorning1(String morning1) {
        this.morning1 = morning1;
    }

    public String getMorning2() {
        return morning2;
    }

    public void setMorning2(String morning2) {
        this.morning2 = morning2;
    }

    public String getAfternoon1() {
        return afternoon1;
    }

    public void setAfternoon1(String afternoon1) {
        this.afternoon1 = afternoon1;
    }

    public String getAfternoon2() {
        return afternoon2;
    }

    public void setAfternoon2(String afternoon2) {
        this.afternoon2 = afternoon2;
    }

    public String getEvening1() {
        return evening1;
    }

    public void setEvening1(String evening1) {
        this.evening1 = evening1;
    }

    public String getEvening2() {
        return evening2;
    }

    public void setEvening2(String evening2) {
        this.evening2 = evening2;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }


    public boolean isShiftAvailable(String time) {
        if (time.equals(morning1) || time.equals(morning2) ||
                time.equals(afternoon1) || time.equals(afternoon2) ||
                time.equals(evening1) || time.equals(evening2)) {
            return true;
        }
        return false;
    }
}
