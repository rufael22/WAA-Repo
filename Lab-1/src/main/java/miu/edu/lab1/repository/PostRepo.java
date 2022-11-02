package miu.edu.lab1.repository;

import miu.edu.lab1.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);


}
