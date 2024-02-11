import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Shift {
    String MORNING1 ;
    String MORNING2 ;
    static final String AFTERNOON1 = "01:30 - 03:00";
    static final String AFTERNOON2 = "03:15 - 04:45";
    static final String EVENING1 = "05:30 - 07:00";
    static final String EVENING2 = "07:15 - 08:45";
    static final String[] time = new String[]{};
    static final String[] day = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    private static ArrayList<Shift> shifts = new ArrayList<>();
    public Shift(String MORNING1, String MORNING2) {
        this.MORNING1 = MORNING1;
        this.MORNING2 = MORNING2;
        shifts.add(this);
    }

    public String getMORNING1() {
        return MORNING1;
    }

    public void setMORNING1(String MORNING1) {
        this.MORNING1 = MORNING1;
    }

    public String getMORNING2() {
        return MORNING2;
    }

    public void setMORNING2(String MORNING2) {
        this.MORNING2 = MORNING2;
    }

    public static ArrayList<Shift> getShifts() {
        return shifts;
    }

    public static void setShifts(ArrayList<Shift> shifts) {
        Shift.shifts = shifts;
    }

    public static void schedule() {
        Table table = new Table(6, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0, 20, 40);
        table.setColumnWidth(1, 20, 40);
        table.setColumnWidth(2, 20, 40);
        table.setColumnWidth(3, 20, 40);
        table.setColumnWidth(4, 20, 40);
        table.setColumnWidth(5, 20, 40);

        table.addCell("TIME",cellStyle);
        for (String d : day) {
            table.addCell(d, cellStyle);
        }
        for (String t : time){
            table.addCell(t,cellStyle);
            for (int i=1 ; i<=5 ;i++){
                table.addCell(String.valueOf(i),cellStyle);
            }
        }
        System.out.println(table.render());
    }


}
