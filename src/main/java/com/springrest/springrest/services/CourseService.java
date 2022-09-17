package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

public class CourseService implements com.springrest.springrest.services.interfaces.ICourseService {
    private Map<Integer, Course> courses;

    public CourseService() {
        courses = new HashMap<>();
        courses.put(1, new Course(1, "Java Spring Tutorial",
                "This course will teach you about how to work with Spring Boot framework in Java."));
        courses.put(2, new Course(2, "Golang gRPC Tutorial",
                "This course will teach you about how to work with gRPC in Golang."));
        courses.put(3, new Course(3, "English 101",
                "This course will teach you about basic English."));
        courses.put(4, new Course(4, "Economy 202",
                "This course will teach you about intermediate level economics."));
    }

    @Override
    public List<Course> getCourses() {
        return courses.values().stream().toList();
    }

    @Override
    public Course getCourse(int courseId) {
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
    public void deleteCourse(int courseId) throws HttpClientErrorException.BadRequest {
        if (!courses.containsKey(courseId)) throw new RuntimeException("Course not found!");
        courses.remove(courseId);
    }
}
