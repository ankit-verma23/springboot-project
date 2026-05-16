package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
//    List<Course> list;
    @Autowired
    private CourseDao courseDao;
    public CourseServiceImpl( ) {
//        list = new ArrayList<>();
//        list.add(new Course(145, "Java Core Course", "this course contents basic of java"));
//        list.add(new Course(4343, "Spring Boot Course", "creating rest api using spring boot"));
    }

    @Override
    public List<Course> getCourses() {

//        return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c = null;
//        for (Course course : list) {
//            if (course.getId() == courseId) {
//                c = course;
//                break;
//            }
//        }
//        return c;
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
//        Course c = null;
//        for (Course co : list) {
//            if (co.getId() == course.getId()) {
//                c = co;
//                break;
//            }
//        }
//        c.setTitle(course.getTitle());
//        c.setDocumentation((course.getDocumentation()));
//        return c;
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
//        list = this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
//        Course entity = courseDao.getOne(courseId);
        courseDao.deleteById(courseId);
    }
}
