package miu.edu.lab4.service;

import miu.edu.lab4.model.Post;
import miu.edu.lab4.model.User;
import miu.edu.lab4.repository.UserRepo;
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
    public void getPost(long id, Post post) {
        userRepo.findById(id).get().getPosts().add(post);
        userRepo.save(userRepo.findById(id).get());
    }

    @Override
    public List<User> findUserByPostsGreaterThan(int n) {
        return userRepo.findUserByPostsGreaterThan(n);
    }


}
