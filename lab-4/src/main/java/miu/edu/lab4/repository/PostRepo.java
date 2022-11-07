package miu.edu.lab4.repository;



import miu.edu.lab4.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
@Query("select p from Post p where p.title =: title")
    public List<Post> findPostByTitle(@Param("title")String title);
}
