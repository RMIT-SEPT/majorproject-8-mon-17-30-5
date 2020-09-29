import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";
import axios from 'axios';


function DisplayAService(props) {
    function handleClick(){
        sessionStorage.setItem("booking-serviceId",props.service.serviceId);
        sessionStorage.setItem("booking-workerId", props.service.workerId);
        sessionStorage.setItem("booking-workername", props.service.workerName);
        sessionStorage.setItem("booking-startTime", props.service.startTime);
        sessionStorage.setItem("booking-finishTime", props.service.finishTime);
        sessionStorage.setItem("booking-date", props.service.date);
        sessionStorage.setItem("booking-serviceDescription", props.service.description);
        sessionStorage.setItem("booking-duration", props.service.duration);
       
        axios.get("http://localhost:8080/api/worker/worker-company/" + sessionStorage.getItem("booking-workerId"))
        .then((response)=>{
            sessionStorage.setItem("booking-companyId", response.data);
            console.log("companyID");
            console.log(response.data);
        })
        .catch()
        .finally();
    }
     
    return (
        <div className="col-sm-3" >
        {props.service.isFree==="true" && <div className="btn btn-info btn-block">
            <p>{props.service.description}</p>
            <ul>
                <li>Worker Name: {props.service.workerName}</li>
                <li>Duration: {props.service.duration} Hour</li>
                <li>Start Time: {props.service.startTime}</li>
                <li>End Time: {props.service.finishTime}</li>
                <li>Date: {props.service.date}</li>
                <li hidden>isFree: {props.service.isFree}</li>
            </ul>
            <br></br>
            <LinkRouter to="/customer/makeBooking">
            <button id = "book" onClick={handleClick}>Book</button>
            </LinkRouter>
            <br></br>
        </div>}
        {props.service.isFree==="false" && <div className="btn btn-secondary btn-block">
        <p>{props.service.description}</p>
        <ul>
            <li>Worker Name: {props.service.workerName}</li>
            <li>Duration: {props.service.duration} Hour</li>
            <li>Start Time: {props.service.startTime}</li>
            <li>End Time: {props.service.finishTime}</li>
            <li>Date: {props.service.date}</li>
            <li hidden>isFree: {props.service.isFree}</li>
        </ul>
        <br></br>
        
        <button className="btn btn-danger">Not Available</button>
        <br></br>
        </div>}
        <br></br>
        </div>
        
    );
}

export default DisplayAService;
