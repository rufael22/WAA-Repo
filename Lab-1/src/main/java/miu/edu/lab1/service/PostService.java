package miu.edu.lab1.service;

import miu.edu.lab1.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

}
