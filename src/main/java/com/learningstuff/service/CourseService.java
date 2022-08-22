package com.learningstuff.service;

import com.learningstuff.dto.Course;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseService {
    private List<Course> courseList = new ArrayList<>(); //instead of database just taken list as sample example

    //Create a new course in data base
    public Course onBoardNewCourse(Course course){
        course.setCourseId(new Random().nextInt(3000));
        courseList.add(course);
        return course;
    }

    //view all the courses in database
    public List<Course> getAllCoursesList(){
        return courseList;
    }
    //find out course by id
    public Course findByCourseId(Integer courseId){
        return courseList.stream()
                .filter(course -> course.getCourseId() == courseId)
                .findFirst().orElse(null);
    }
    //delete course
    public void deleteCourse(Integer courseId){
        Course course = findByCourseId(courseId);
    }
    //update the course
    public Course updateCourse(Integer courseId, Course course){
        Course existingCourse = findByCourseId(courseId);
        return courseList.set(courseList.indexOf(existingCourse), course);
    }

}
