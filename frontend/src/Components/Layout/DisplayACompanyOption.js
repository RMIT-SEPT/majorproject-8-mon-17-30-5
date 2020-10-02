import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

function DisplayACompanyOption(props) {
    return (
        <option value={props.company.id}>{props.company.companyName}</option>
    )
}

export default DisplayACompanyOption;