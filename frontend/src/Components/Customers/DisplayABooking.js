import React from 'react'

function DisplayABooking(props) {

    // private Long workerId; 
    // private String workerName;
    // @NotNull (message = "Service ID is required")
    // private Long serviceId; --> getdescription
    // private String type;
    // private Date startTime;
    // private Date finishTime;
    return (
        <div>
            <p>Id {props.booking.id}</p>
            <ul>
                <li>description:{}</li>
                <li>worker Id: {}</li>
                <li>worker name: {}</li>
                <li>Start time: {}</li>
                <li>Finish time: {}</li>
            </ul>
        </div>
    )
}

export default DisplayABooking;