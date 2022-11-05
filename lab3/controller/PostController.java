package miu.edu.lab3.controller;


import miu.edu.lab3.model.Comment;
import miu.edu.lab3.model.Post;
import miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getPosts() {
        return postService.findAll();
    }


    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable("id") int id) {
        return postService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Post p) {

        postService.save(p);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getCommentsById(@PathVariable("id") int id) {
        return postService.findComments(id);
    }


    @PostMapping("/{id}/comments")
    public void createComment(@PathVariable long id, @RequestParam Comment c) {

        postService.addComments(id, c);

    }
    @GetMapping("/{title}")
    public List<Post> getPostByTitle(@PathVariable String title){
        return postService.findPostByTitle(title);
    }

}
