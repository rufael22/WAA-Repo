package miu.edu.lab4.repository;

import miu.edu.lab4.model.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationLoggerRepo extends JpaRepository<Logger,Long> {

}
