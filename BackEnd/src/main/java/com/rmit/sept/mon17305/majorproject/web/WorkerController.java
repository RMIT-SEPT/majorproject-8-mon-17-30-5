package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("")
    public ResponseEntity<?> createNewWorker(@RequestBody Worker worker, BindingResult result){

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

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

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceWorker(@RequestBody Worker newWorker, @PathVariable Long id) {

        workerService.getWorker(id)
                .map(worker -> {
                    worker.setFirstName(newWorker.getFirstName());
                    worker.setLastName(newWorker.getFirstName());
                    return new ResponseEntity<Worker> (workerService.saveOrUpdateWorker(worker),HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    Worker worker1 = workerService.saveOrUpdateWorker(newWorker);
                    return new ResponseEntity<Worker>(newWorker, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find Worker", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteWorker(@PathVariable Long id) {
        workerService.deleteWorkerById(id);
    }

}
