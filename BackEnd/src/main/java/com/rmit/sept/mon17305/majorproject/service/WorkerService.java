package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Admin;
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

    public Worker getWorkerByUsername(String username){
        Worker worker = workerRepository.findByUsername(username);
        if(worker==null){
            throw new NullPointerException("username not found");
        }
        return worker;
    }

    public Worker getWorkerByUsernameAndPassword(String username, String password){

        return workerRepository.findByUsernameAndPassword(username, password);
    }

    public Worker getWorkerByIdEquals(Long id){
        return workerRepository.findByIdEquals(id);
    }


    public Optional<Worker> getWorker(Long id){

        return workerRepository.findById(id);
    }

    public void deleteWorkerById(Long id){

        workerRepository.deleteById(id);
    }

    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker getWorkerById(Long id){
        return workerRepository.findByIdEquals(id);
    }

    public List<Worker> getWorkersByCompanyId(Long id){
        return workerRepository.findByCompanyIdEquals(id);
    }
}