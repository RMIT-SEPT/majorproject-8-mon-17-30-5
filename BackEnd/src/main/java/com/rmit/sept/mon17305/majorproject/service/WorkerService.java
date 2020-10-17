<<<<<<< HEAD
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
        if(worker == null)
        {
            throw new NullPointerException("Empty worker cannot be saved");
        }
        //business logic
        return workerRepository.save(worker);

    }

    public List<Worker> getWorkers(){
        List<Worker> workers = workerRepository.findAll();
        if(workers == null)
        {
            throw new NullPointerException("No workers exist");
        }
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
        Worker worker = workerRepository.findByUsernameAndPassword(username, password);
        if(worker == null)
        {
            throw new NullPointerException("Username and password don't exist");
        }
        return workerRepository.findByUsernameAndPassword(username, password);
    }

    public Worker getWorkerByIdEquals(Long id) throws Exception {
        Worker worker = workerRepository.findByIdEquals(id);
         if(id < 1)
         {
             throw new Exception("Id cannot be less than 1");
         }

         if(worker == null)
         {
             throw new NullPointerException("Id does not exist");
         }

         return workerRepository.findByIdEquals(id);
    }


    public Optional<Worker> getWorker(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Worker> worker = workerRepository.findById(id);
        if(!worker.isPresent())
        {
            throw new NullPointerException(("Id does not exist"));
        }
        return workerRepository.findById(id);
    }

    public void deleteWorkerById(Long id) throws Exception {
        Worker worker = workerRepository.findByIdEquals(id);
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }

        if(worker == null)
        {
            throw new NullPointerException("Id does not exist to delete");
        }
        workerRepository.deleteById(id);
    }

    public void setWorkerRepository(WorkerRepository workerRepository) {
        if(workerRepository == null)
        {
            throw new NullPointerException("Cannot set empty worker repository");
        }
        this.workerRepository = workerRepository;
    }

    public Worker getWorkerById(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Worker worker = workerRepository.findByIdEquals(id);
        if(worker == null)
        {
            throw new NullPointerException("Id does not exist");
        }
        return workerRepository.findByIdEquals(id);
    }

    public List<Worker> getWorkersByCompanyId(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Company id cannot be less than 1");
        }

        List<Worker> workers = workerRepository.findByCompanyIdEquals(id);

        if(workers == null)
        {
            throw new NullPointerException("No workers exist for company");
        }
        return workerRepository.findByCompanyIdEquals(id);
    }
=======
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
        if(worker == null)
        {
            throw new NullPointerException("Empty worker cannot be saved");
        }
        //business logic
        return workerRepository.save(worker);

    }

    public List<Worker> getWorkers(){
        List<Worker> workers = workerRepository.findAll();
        if(workers == null)
        {
            throw new NullPointerException("No workers exist");
        }
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
        Worker worker = workerRepository.findByUsernameAndPassword(username, password);
        if(worker == null)
        {
            throw new NullPointerException("Username and password don't exist");
        }
        return workerRepository.findByUsernameAndPassword(username, password);
    }

    public Worker getWorkerByIdEquals(Long id) throws Exception {
        Worker worker = workerRepository.findByIdEquals(id);
         if(id < 1)
         {
             throw new Exception("Id cannot be less than 1");
         }

         if(worker == null)
         {
             throw new NullPointerException("Id does not exist");
         }

         return workerRepository.findByIdEquals(id);
    }


    public Optional<Worker> getWorker(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Worker> worker = workerRepository.findById(id);
        if(!worker.isPresent())
        {
            throw new NullPointerException(("Id does not exist"));
        }
        return workerRepository.findById(id);
    }

    public void deleteWorkerById(Long id) throws Exception {
        Worker worker = workerRepository.findByIdEquals(id);
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }

        if(worker == null)
        {
            throw new NullPointerException("Id does not exist to delete");
        }
        workerRepository.deleteById(id);
    }

    public void setWorkerRepository(WorkerRepository workerRepository) {
        if(workerRepository == null)
        {
            throw new NullPointerException("Cannot set empty worker repository");
        }
        this.workerRepository = workerRepository;
    }

    public Worker getWorkerById(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Worker worker = workerRepository.findByIdEquals(id);
        if(worker == null)
        {
            throw new NullPointerException("Id does not exist");
        }
        return workerRepository.findByIdEquals(id);
    }

    public List<Worker> getWorkersByCompanyId(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Company id cannot be less than 1");
        }

        List<Worker> workers = workerRepository.findByCompanyIdEquals(id);

        if(workers == null)
        {
            throw new NullPointerException("No workers exist for company");
        }
        return workerRepository.findByCompanyIdEquals(id);
    }
>>>>>>> m3-local
}