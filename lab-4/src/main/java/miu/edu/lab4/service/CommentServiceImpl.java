package miu.edu.lab4.service;

import miu.edu.lab4.model.Comment;
import miu.edu.lab4.model.Post;
import miu.edu.lab4.repository.CommentRepo;
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
