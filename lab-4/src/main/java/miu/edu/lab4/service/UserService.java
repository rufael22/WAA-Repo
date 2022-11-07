package miu.edu.lab4.service;

import miu.edu.lab4.model.Post;
import miu.edu.lab4.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User getById(long id);

    public void save(User u);

    public List<Post> findPosts(long id);
    public void getPost(long id, Post post);

    public List<User> findUserByPostsGreaterThan(@Param("n") int n);

}
