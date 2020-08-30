import React from 'react'

function DisplayAService(props) {
    return (
        <div>
            <p>Id {props.service.id}</p>
            <ul>
                <li>description:{props.service.description}</li>
                <li>worker Id: {props.service.workerId}</li>
                <li>worker name: {props.service.workerName}</li>
            </ul>
        </div>
    )
}

export default DisplayAService;
