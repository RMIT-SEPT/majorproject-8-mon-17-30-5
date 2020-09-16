package com.rmit.sept.mon17305.majorproject.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rmit.sept.mon17305.majorproject.CustomedException.TimeFormatException;
import com.rmit.sept.mon17305.majorproject.model.Admin;
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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewWorker(@RequestBody Worker worker, BindingResult result) throws TimeFormatException {

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        String startTime = worker.getStartTime();
        String finishTime = worker.getFinishTime();
        String lunchBrTime = worker.getLunchBrTime();
        boolean validStart = checkTimeformat(startTime);
        boolean validFinish = checkTimeformat(finishTime);
        boolean validBreak = checkTimeformat(lunchBrTime);

        if(!validStart||!validFinish||!validBreak){
            throw new TimeFormatException("invalid time input");
        }

        Worker worker1 = workerService.saveOrUpdateWorker(worker);
        return new ResponseEntity<Worker>(worker, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Worker> getWorkers() {

        return workerService.getWorkers();
    }

    @GetMapping("/username/{username}")
    public Worker getWorkerByUsername(@PathVariable String username) {
        return workerService.getWorkerByUsername(username);
    }

    @GetMapping("/username/{username}/password/{password}")
    public Worker getWorkerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return workerService.getWorkerByUsernameAndPassword(username, password);
    }

    @GetMapping("/{id}")
    public Optional<Worker> getWorker(@PathVariable Long id) {
        return workerService.getWorker(id);
    }


    @GetMapping("/{id}/{serviceId}/{date}/{description}/{duration}/")
    public HashMap[] getWorkerAvailability(@PathVariable Long id,
                                         @PathVariable Long serviceId, @PathVariable String date,
                                         @PathVariable String description, @PathVariable int duration) {
        Worker worker = workerService.getWorkerByIdEquals(id);
        int[] timeFree = computeAvailableTime(worker.getStartTime(), worker.getFinishTime(), worker.getLunchBrTime()
        ,duration);
      //  String[] ret = new String[timeFree.length];
        HashMap[] ret = new HashMap[timeFree.length];
        int hrCount = 100*duration;
        for(int i =0; i < timeFree.length; i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("serviceId", serviceId);
            map.put("workerId", id);
            map.put("workerName", worker.getFirstName());
            map.put("date", date);
            map.put("description", description);
            map.put("duration", duration);
            map.put("startTime", timeFree[i]);
            map.put("finishTime", timeFree[i]+hrCount);
//            StringBuilder str = new StringBuilder();
//            str.append("{ServiceId: "+serviceId+",");
//            str.append("workerId: "+id+",");
//            str.append("workername: "+"\""+worker.getFirstName()+"\",");
//            str.append("date: "+"\""+date+"\",");
//            str.append("description: "+"\""+description+"\",");
//            str.append("duration: "+duration+",");
//            str.append("startTime: "+timeFree[i]+",");
//            str.append("finishTime: "+timeFree[i]+hrCount+"}");
           ret[i] = map;
        }

        return ret;
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

    private boolean checkTimeformat(String timeString){
        boolean valid = true;
        if(timeString.contains(":")){
            String[] time = timeString.split(":");
            int hr = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            if(hr>24 || hr <0){
                valid = false;
            }
            if(min>59|| min < 0){
                valid = false;
            }
        }else{
            valid = false;
        }

        return valid;
    }

    private int[] computeAvailableTime(String startStr, String finishStr, String breakStr, int duration){

        startStr = startStr.substring(0,2)+startStr.substring(3);
        finishStr = finishStr.substring(0,2)+finishStr.substring(3);
        breakStr = breakStr.substring(0,2) + breakStr.substring(3);
       // System.out.println("Str:"+startStr+","+finishStr+"<"+breakStr);
        int start = Integer.parseInt(startStr);
        int finish = Integer.parseInt(finishStr);
        int lunch = Integer.parseInt(breakStr);
       // System.out.println("int: "+start+","+finish+","+lunch);
        int diff = finish-lunch;
        int hrCount = 100*duration;
        int num = (finish-start-100)/hrCount;
        int[] array = new int[num];
        int arrayIndex =0;
        for(int i = start; i < finish; i = i + hrCount){
            if(i != lunch){
                int temp = i + hrCount;
                if(!(lunch>i && lunch<temp)){
                    array[arrayIndex] = i;
                    arrayIndex++;
                }
            }
        }
        return array;
    }
}
