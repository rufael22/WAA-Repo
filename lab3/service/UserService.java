package miu.edu.lab3.service;

import miu.edu.lab3.model.Post;
import miu.edu.lab3.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User getById(long id);

    public void save(User u);

    public List<Post> findPosts(long id);

    public List<User> findUserByPostsGreaterThan(@Param("n") int n);

}
