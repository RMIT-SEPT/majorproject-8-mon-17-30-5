import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function DisplayAService(props) {
    return (
        // <option value={props.service.id}>{props.service.description}</option>
        <div className="col-sm-3">
            <div className="btn btn-info btn-block">
            <p>{props.service.id}</p>
            <ul>
                <li>Description: {props.service.description}</li>
                <li>Worker Name: {props.service.workerName}</li>
                <li>Worker ID: {props.service.workerId}</li>
            </ul>
        </div>
        </div>
    )
}

export default DisplayAService;
