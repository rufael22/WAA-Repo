package miu.edu.lab3.service;


import miu.edu.lab3.model.Comment;
import miu.edu.lab3.model.Post;
import miu.edu.lab3.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;


    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }


    @Override
    public Post getById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);

    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);

    }

    @Override
    public void update(long id, Post p) {
        Post post = postRepo.findById(id).orElse(null);
        post.setAuthor(p.getAuthor());
        post.setTitle(p.getTitle());
        post.setContent(p.getContent());
        postRepo.save(post);

    }

    @Override
    public List<Comment> findComments(long id) {
        Post post = postRepo.findById(id).orElse(null);
        return post.getComments();
    }

    @Override
    public void addComments(long id, Comment c) {
        postRepo.findById(id).get().getComments().add(c);
        postRepo.save(postRepo.findById(id).get());
    }

    @Override
    public List<Post> findPostByTitle(String title) {
        return postRepo.findPostByTitle(title);
    }


}
