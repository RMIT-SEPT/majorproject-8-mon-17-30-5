package com.rmit.sept.mon17305.majorproject.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rmit.sept.mon17305.majorproject.CustomedException.TimeFormatException;
import com.rmit.sept.mon17305.majorproject.model.*;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.ServiceObjectRepository;
import com.rmit.sept.mon17305.majorproject.service.BookingService;
import com.rmit.sept.mon17305.majorproject.service.CustomerService;
import com.rmit.sept.mon17305.majorproject.service.ServiceObjectService;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ServiceObjectService serviceObjectService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewWorker(@RequestBody Worker worker, BindingResult result){

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
            return new ResponseEntity<String>("invalid time input", HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<?> getWorkerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        Worker worker = workerService.getWorkerByUsernameAndPassword(username, password);

        if(worker==null){
            return new ResponseEntity<String>("invalid id", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("/worker-company/{id}")
    public Long getCompanyOfWorker(@PathVariable Long id) {
        Worker w = workerService.getWorkerByIdEquals(id);
        return w.getCompanyId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorker(@PathVariable Long id) {
        Optional<Worker> worker = workerService.getWorker(id);
        if(worker==null){
            return new ResponseEntity<String>("invalid id", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Optional<Worker>>(worker, HttpStatus.FOUND);
    }


    @GetMapping("/{id}/{serviceId}/{date}/{description}/{duration}/")
    public ResponseEntity<?> getWorkerAvailability(@PathVariable Long id,
                                         @PathVariable Long serviceId, @PathVariable String date,
                                         @PathVariable String description, @PathVariable int duration) {

        if((id<1||id ==null)||(serviceId<1||serviceId==null)||(date.equals("null"))||
                (description.equals("null"))||(duration<1||duration>5)){
            return new ResponseEntity<String>("invalid param",HttpStatus.BAD_REQUEST);
        }else {

            Worker worker = workerService.getWorkerByIdEquals(id);
            int[] timeFree = computeAvailableTime(worker.getStartTime(), worker.getFinishTime(), worker.getLunchBrTime()
                    , duration);
            HashMap[] ret = new HashMap[timeFree.length];
            int hrCount = 100 * duration;
            for (int i = 0; i < timeFree.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("serviceId", serviceId);
                map.put("workerId", id);
                map.put("workerName", worker.getFirstName());
                map.put("date", date);
                map.put("description", description);
                map.put("duration", duration);
                map.put("startTime", timeFree[i]);
                map.put("finishTime", timeFree[i] + hrCount);
                String isFree = getIsFree(date, id, timeFree[i], duration);
                map.put("isFree", isFree);
                ret[i] = map;
            }
            return new ResponseEntity<HashMap[]>(ret, HttpStatus.OK);
        }
    }

    private String getIsFree(String date, Long id, int time,int duration){
        String ret = "true";
        int timeCount = time;
        for(int i = 1; i <= duration && ret=="true"; i++){
            List<Booking> found = bookingService.getBookingByDateAndWorkerIdAndTime(date, id, timeCount);
            if(found==null || found.size()==0){
                ret = "true";
            }else{
                ret = "false";
            }
            timeCount = timeCount+100;
        }
        return ret;
    }

    @GetMapping("/workerId/{id}/date/{date}")
    public ResponseEntity<?> getWorkerAvailabilityAtDate(@PathVariable Long id, @PathVariable String date){
        List<Booking> booked = bookingService.getBookingByWorkerIdAndDate(id,date);
        Worker worker = workerService.getWorkerByIdEquals(id);
        String start = worker.getStartTime();
        String finish = worker.getFinishTime();
        String lunch = worker.getLunchBrTime();
        HashMap<String, Object> map = new HashMap<>();
        if(start.equals("08:00")){
            map.put("800", checkPerHr(800,booked));
        }
        map.put("900", checkPerHr(900,booked));
        map.put("1000", checkPerHr(1000,booked));
        if(lunch.equals("12:00")){
            map.put("1100", checkPerHr(1100,booked));
        }
        else if(lunch.equals("11:00")){
            map.put("1200", checkPerHr(1200,booked));
        }
        map.put("1300", checkPerHr(1300,booked));
        map.put("1400", checkPerHr(1400,booked));
        map.put("1500", checkPerHr(1500,booked));
        if(finish.equals("17:00")){
            map.put("1600", checkPerHr(1600,booked));
        }
        return new ResponseEntity<HashMap<String, Object> >(map, HttpStatus.OK);
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
        int start = Integer.parseInt(startStr);
        int finish = Integer.parseInt(finishStr);
        int lunch = Integer.parseInt(breakStr);
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

    private String checkPerHr(int time, List<Booking> booked) {
        String ret = "free";
        if (booked != null) {
            for (Booking booking : booked) {
                if (time >= booking.getStartTime() && time < booking.getFinishTime() && ret == "free") {
                    String custName = customerService.getCustomerByIdEquals(booking.getCustomerId()).getUsername();
                    String desc = serviceObjectService.getServiceDescriptionById(booking.getServiceId());
                    StringBuilder str = new StringBuilder();
                    str.append("ID: ");
                    str.append(booking.getId());
                    str.append(", ");
                    str.append(custName);
                    str.append(" booked to ");
                    str.append(desc);
                    str.append(System.getProperty("line.separator"));
                    ret = str.toString();
                }
            }
        }
        return ret;
    }
}
