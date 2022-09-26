package repository;

import model.Course;

public interface CourseParticipant {
    public void attendCourse(Course course);
    public void printInfo();
}
