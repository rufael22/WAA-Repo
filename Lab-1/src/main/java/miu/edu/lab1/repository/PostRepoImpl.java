package miu.edu.lab1.repository;

import miu.edu.lab1.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;
    private static int postId = 100;
    static {
        posts = new ArrayList<>();
        Post r1a = new Post(123,"Harry Potter","fiction","J.K Rowling");
        Post r1b = new Post(124,"Cant hurt me","bio","David Gaggins");
        //List<Post> posts1 = Arrays.asList(r1a,r1b);


        Post r2a = new Post(125,"12 Rules For Life","psychology","Jordan Peterson");
        Post r2b = new Post(126,"Rich Dad poor Dad","non-fiction","Robert Kiyosaki");
        //List<Post> posts2 = Arrays.asList(r2a,r2b);
        posts.add(r1a);
        posts.add(r1b);
        posts.add(r2a);
        posts.add(r2b);
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return  posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);

    }


}
