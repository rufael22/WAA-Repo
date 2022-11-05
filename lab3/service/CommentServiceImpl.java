package miu.edu.lab3.service;

import miu.edu.lab3.model.Comment;
import miu.edu.lab3.model.Post;
import miu.edu.lab3.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Override
    public List<Comment> findAll() {
       return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Comment com) {
        commentRepo.save(com);

    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);

    }

    @Override
    public void update(long id, Comment com) {

    }


}
