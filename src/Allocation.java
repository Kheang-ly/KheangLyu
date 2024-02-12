class Allocation {
    private Teacher teacher;
    private Subject subject;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ClassRoom getRoom() {
        return room;
    }

    public void setRoom(ClassRoom room) {
        this.room = room;
    }

    private ClassRoom room;

    public Allocation(Teacher teacher, Subject subject, ClassRoom room, TimeSlot timeSlot) {
        this.teacher = teacher;
        this.subject = subject;
        this.room = room;
    }

    // Getters and setters
}