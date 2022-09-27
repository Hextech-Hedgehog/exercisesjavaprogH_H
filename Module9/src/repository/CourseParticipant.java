package repository;

import model.Course;

public interface CourseParticipant extends Comparable<CourseParticipant> {
    public void attendCourse(Course course);
    public void printInfo();
}
