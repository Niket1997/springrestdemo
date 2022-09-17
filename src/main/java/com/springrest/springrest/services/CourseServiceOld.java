package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

public class CourseServiceOld implements com.springrest.springrest.services.interfaces.ICourseService {
    private Map<Long, Course> courses;

    public CourseServiceOld() {
        courses = new HashMap<>();
        courses.put(1L, new Course(1, "Java Spring Tutorial",
                "This course will teach you about how to work with Spring Boot framework in Java."));
        courses.put(2L, new Course(2, "Golang gRPC Tutorial",
                "This course will teach you about how to work with gRPC in Golang."));
        courses.put(3L, new Course(3, "English 101",
                "This course will teach you about basic English."));
        courses.put(4L, new Course(4, "Economy 202",
                "This course will teach you about intermediate level economics."));
    }

    @Override
    public List<Course> getCourses() {
        return courses.values().stream().toList();
    }

    @Override
    public Course getCourse(long courseId) {
        return courses.getOrDefault(courseId, null);
    }

    @Override
    public Course addCourse(Course course) {
        if (courses.containsKey(course.getId())) return null;
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        if (!courses.containsKey(course.getId())) return null;
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) throws HttpClientErrorException.BadRequest {
        if (!courses.containsKey(courseId)) throw new RuntimeException("Course not found!");
        courses.remove(courseId);
    }
}
