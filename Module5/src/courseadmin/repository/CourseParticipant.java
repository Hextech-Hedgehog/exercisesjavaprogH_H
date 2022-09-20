package courseadmin.repository;

import model.Course;

@FunctionalInterface
public interface CourseParticipant {
    public void attendCourse(Course course);
}
