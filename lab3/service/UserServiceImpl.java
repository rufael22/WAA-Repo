package miu.edu.lab3.service;

import miu.edu.lab3.model.Post;
import miu.edu.lab3.model.User;
import miu.edu.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }


    @Override
    public User getById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public List<Post> findPosts(long id) {
//        User user = userRepo.findById(id).orElse(null);
//        return user.getPosts();
        return userRepo.findById(id).get().getPosts();
    }

    @Override
    public List<User> findUserByPostsGreaterThan(int n) {
        return userRepo.findUserByPostsGreaterThan(n);
    }


}
