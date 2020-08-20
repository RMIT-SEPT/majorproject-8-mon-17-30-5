package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker saveOrUpdateWorker(Worker worker){

        //business logic
        return workerRepository.save(worker);

    }

    public List<Worker> getWorkers(){

        return workerRepository.findAll();

    }

    public Optional<Worker> getWorker(Long id){

        return workerRepository.findById(id);
    }

}