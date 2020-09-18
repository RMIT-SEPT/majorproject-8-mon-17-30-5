import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function WorkerOption(props) {
    return (
        <option value={props.w.id}>{props.w.firstName}</option>
    )
}

export default WorkerOption;