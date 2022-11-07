package miu.edu.lab4.controller;

import miu.edu.lab4.model.Comment;
import miu.edu.lab4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return (List<Comment>) commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable long id){
        return commentService.findById(id);
    }


    @PostMapping
    public void create(@RequestBody Comment comment){
         commentService.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        commentService.delete(id);
    }
}
