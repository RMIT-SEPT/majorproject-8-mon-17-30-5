import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";

function DisplayAService(props) {
    return (
        // <option value={props.service.id}>{props.service.description}</option>
        <div className="col-sm-3">
            <div className="btn btn-info btn-block">
            <p>{props.service.id}</p>
            <ul>
                <li>Description: {props.service.description}</li>
                <li>Worker Name: {props.service.workername}</li>
                <li>Worker ID: {props.service.workerId}</li>
            </ul>
            <br></br>
            <LinkRouter to="/customer/makeBooking">
            <button workerId={props.service.workerId}>Book</button>
            </LinkRouter>
            <br></br>
        </div>
        </div>
    )
}

export default DisplayAService;
