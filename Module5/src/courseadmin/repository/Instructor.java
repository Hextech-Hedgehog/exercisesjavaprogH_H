package courseadmin.repository;

import model.Course;

@FunctionalInterface
public interface Instructor {
    public void teachCourse(Course course);
}
