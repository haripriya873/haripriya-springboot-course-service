package com.learningstuff.controller;

import com.learningstuff.dto.Course;
import com.learningstuff.service.CourseService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
       Course newCourse = courseService.onBoardNewCourse(course);
       return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/findAllCourses")
    public ResponseEntity<?> findAllCourses(){
        return new ResponseEntity<>(courseService.getAllCoursesList(), HttpStatus.OK);
    }

    @GetMapping("/search/path/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    @GetMapping("/search/request")
    public ResponseEntity<?> findCourseUsingRequestParam(@RequestParam(required = false) Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deteleCourse(@PathVariable Integer courseId){
        return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(courseId,course), HttpStatus.OK);
    }
}
