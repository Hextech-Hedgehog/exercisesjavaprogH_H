package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Course;

@FunctionalInterface
public interface CourseParticipant {
    public void attendCourse(Course course);
}
