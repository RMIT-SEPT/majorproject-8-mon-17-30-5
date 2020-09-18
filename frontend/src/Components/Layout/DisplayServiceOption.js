import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function DisplayServiceOption(props) {
    return (
        <option value={props.service.id}>{props.service.description}</option>
    )
}

export default DisplayServiceOption;