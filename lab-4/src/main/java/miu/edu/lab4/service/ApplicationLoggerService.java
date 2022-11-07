package miu.edu.lab4.service;


import miu.edu.lab4.model.Logger;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationLoggerService {
    public void saveApplicationLog(Logger logger);

}
