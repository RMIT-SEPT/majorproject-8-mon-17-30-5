package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("")
    public ResponseEntity<Worker> createNewWorker(@RequestBody Worker worker){

        Worker worker1 = workerService.saveOrUpdateWorker(worker);
        return new ResponseEntity<Worker>(worker, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Worker> getWorkers() {

        return workerService.getWorkers();
    }

    @GetMapping("/{id}")
    public Optional<Worker> getWorker(@PathVariable Long id) {
        return workerService.getWorker(id);
    }

}
