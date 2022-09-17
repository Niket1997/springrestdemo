package com.springrest.springrest.services.interfaces;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> getCourses();

    public Course getCourse(int courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);
    public void deleteCourse(int courseId);
}
