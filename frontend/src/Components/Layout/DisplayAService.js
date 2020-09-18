import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";


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
    }
    return (
        <div className="col-sm-3">
            <div className="btn btn-info btn-block">
            <p>{props.service.description}</p>
            <ul>
                <li>Worker Name: {props.service.workerName}</li>
                <li>Duration: {props.service.duration} Hour</li>
                <li>Start Time: {props.service.startTime}</li>
                <li>End Time: {props.service.finishTime}</li>
                <li>Date: {props.service.date}</li>
            </ul>
            <br></br>
            <LinkRouter to="/customer/makeBooking">
            <button onClick={handleClick}>Book</button>
            </LinkRouter>
            <br></br>
        </div>
        </div>

    );
}

export default DisplayAService;
