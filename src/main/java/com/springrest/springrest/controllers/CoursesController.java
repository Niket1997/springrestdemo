package com.springrest.springrest.controllers;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.repositories.interfaces.ICourseRepository;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    private final ICourseService courseService;

    @Autowired
    public CoursesController(ICourseRepository courseRepository) {
        courseService = new CourseService(courseRepository);
    }

    @GetMapping("/home")
    public String home() {
        return "Hello world!";
    }

    // get courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    // get a course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable long courseId) {
        return courseService.getCourse(courseId);
    }

    // add a course
    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // update a course
    @PutMapping(path = "/courses", consumes = "application/json")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    // delete a course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId) {
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
