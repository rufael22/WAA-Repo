package miu.edu.lab1.service;

import miu.edu.lab1.model.Post;
import miu.edu.lab1.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.getById(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);

    }

}
