import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";
import MakeBooking from '../Customers/MakeBooking';

function DisplayAService(props) {
    function handleClick(){
        sessionStorage.setItem("booking-serviceId",props.service.serviceId);
        sessionStorage.setItem("booking-workerId", props.service.workerId);
        sessionStorage.setItem("booking-workername", props.service.workername);
        sessionStorage.setItem("booking-startTime", props.service.startTime);
        sessionStorage.setItem("booking-finishTime", props.service.finishTime);
        sessionStorage.setItem("booking-date", props.service.date);
        sessionStorage.setItem("booking-serviceDescription", props.service.description);
        sessionStorage.setItem("booking-duration", props.service.duration);
    }
    return (
        // <option value={props.service.id}>{props.service.description}</option>
        <div className="col-sm-3">
            <div className="btn btn-info btn-block">
            <p>{props.service.serviceId}</p>
            <ul>
                <li>Description: {props.service.description}</li>
                <li>Worker Name: {props.service.workername}</li>
                <li>Worker ID: {props.service.workerId}</li>
            </ul>
            <br></br>
            <LinkRouter to="/customer/makeBooking">
            <button onClick={handleClick}>Book</button>
            </LinkRouter>
            <br></br>
        </div>
        </div>
    )
}

export default DisplayAService;
