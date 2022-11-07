package miu.edu.lab4.service;

import miu.edu.lab4.model.Comment;
import miu.edu.lab4.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public Iterable<Comment> findAll();
    public Comment findById(long id);
    public void save(Comment com);
    public void delete(long id);
    public void update(long id,Comment com);


}
