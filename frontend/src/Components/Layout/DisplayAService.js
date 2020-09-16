import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function DisplayAService(props) {
    return (
        // <option value={props.service.id}>{props.service.description}</option>
        <div className="col-sm-3">
            <div className="btn btn-info btn-block">
            <p>{props.service.description}</p>
            <ul>
                <li>Worker Name: {props.service.workername}</li>
                <li>Duration: {props.service.duration} Hour</li>
                <li>Start Time: {props.service.startTime}</li>
                <li>End Time: {props.service.finishTime}</li>
            </ul>
        </div>
        <br></br>
        </div>
    )
}

export default DisplayAService;
