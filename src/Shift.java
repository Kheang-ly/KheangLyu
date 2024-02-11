import java.util.Objects;

public class Shift {
    private String[][] shift = new String[2][5];
    private String morning = "Morning";
    private String afternoon = "Afternoon";
    private String evening = "Evening";
    private String[] optionShift = new String[]{morning,afternoon,evening};

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    public boolean isShiftAvailable(String shift) {
        for (String option : optionShift) {
            if (Objects.equals(option, shift)) {
                System.out.println("Shift found: " + option);
                return true;
            }
        }
        return false;
    }
    public void check(){
        for (int i=0 ; i<shift.length ; i++){
            for(int j=0 ; j<shift[i].length ; j++){
                shift[i][j] = "NULL" ;
            }
        }
        System.out.println("=".repeat(100));
        for(String[] n : shift){
            for(String s : n){
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }

}
