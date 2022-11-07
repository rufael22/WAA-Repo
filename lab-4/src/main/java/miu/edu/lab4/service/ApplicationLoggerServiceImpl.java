package miu.edu.lab4.service;


import miu.edu.lab4.model.Logger;
import miu.edu.lab4.repository.ApplicationLoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ApplicationLoggerServiceImpl implements ApplicationLoggerService {
        @Autowired
        private ApplicationLoggerRepo applicationLoggerRepo;


    @Override
    public void saveApplicationLog(Logger logger) {
        applicationLoggerRepo.save(logger);
    }
}
