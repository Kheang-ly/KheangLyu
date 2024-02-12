import java.util.ArrayList;
import java.util.List;

class TimeSlot {
    private String dayOfWeek;
    private String startTime;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    private String endTime;
    private   List<Allocation> allocations;

    public TimeSlot(String dayOfWeek, String startTime, String endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        allocations = new ArrayList<>();
    }

    public void addAllocation(Allocation allocation) {
        allocations.add(allocation);
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public boolean overlaps(TimeSlot other) {
        // Implement logic to check if this time slot overlaps with another
        return false;
    }
}


