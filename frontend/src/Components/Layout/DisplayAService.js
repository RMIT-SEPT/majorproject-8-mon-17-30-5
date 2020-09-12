import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function DisplayAService(props) {
    return (
        <option value={props.service.id}>{props.service.description}</option>
        // <div className="row-sm-3">
        //     <div className="btn btn-info btn-block">
        //     <p>Id {props.service.id}</p>
        //     <ul>
        //         <li>description:{props.service.description}</li>
        //         <li>worker Id: {props.service.workerId}</li>
        //         <li>worker name: {props.service.workerName}</li>
        //     </ul>
        //     </div>
            
        // </div>
    )
}

export default DisplayAService;
