package miu.edu.lab4.service;


import lombok.Setter;
import miu.edu.lab4.model.Comment;
import miu.edu.lab4.model.Post;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> findAll();

    public Post getById(long id);

    public void save(Post p);
    public void delete(long id);
    public void update(long id,Post p);
    public List<Comment> findComments(long id);
    public void addComments(long id,Comment c);
    public List<Post> findPostByTitle(@Param("title")String title);

}
