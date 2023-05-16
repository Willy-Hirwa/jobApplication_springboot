package com.mhwc.jobPlatform.service;


import com.mhwc.jobPlatform.model.Job;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    Page<Job> findAll(int pageNumber, String keyword);



    Job findById(Long theId);

    void save(Job theJob, Long userId);

    void deleteById(Long theId);

    List<Job> findAll();
}
