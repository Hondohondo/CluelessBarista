package com.cluelessbarista.Clueless.Barista.Project.controller.impl;

import com.cluelessbarista.Clueless.Barista.Project.model.Comment;
import com.cluelessbarista.Clueless.Barista.Project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @GetMapping("/comment/{commentId}")
    public Comment getComment(@PathVariable Integer commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isPresent()) {
            return commentOptional.get();
        } else {
            return null;
        }
    }

 /*   @GetMapping("/courses/hours")
    public List<Courses> getCoursesByHoursLessThan(@RequestParam(defaultValue = "100" Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }*/
}
