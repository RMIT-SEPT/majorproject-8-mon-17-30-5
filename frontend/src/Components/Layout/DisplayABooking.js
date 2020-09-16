import React, {useState, useEffect} from 'react';
import axios from 'axios';

function DisplayABooking(props) {
    
    const[userDetails, setUserDetails] = useState({
        description:"",
        workerName:"",
        startTime:"null",
        finishTime:"null"
    });

    useEffect(() => {
       async function getDescription(){
        axios.get("http://localhost:8080/api/serviceObject/"+props.booking.serviceId)
        .then((response)=>{
            console.log(response.data);
            setUserDetails  ((prevValue)=>{
            return {
                ...prevValue,
                description: response.data.description,
                workerName: response.data.workerName
            }
          });       
        })
        .catch()
        .finally();
       };
       getDescription();
    }, [props]);

    return (
        <div>
            <p>Id {props.booking.id}</p>
            <ul>
                <li>Service Id: {props.booking.serviceId}</li>
                <li>description:{userDetails.description}</li>
                <li>worker Id: {props.booking.workerId}</li>
                <li>worker name: {props.booking.workerName}</li>
                <li>Start time: {props.booking.startTime}</li>
                <li>Finish time: {props.booking.finishTime}</li>
            </ul>
        </div>
    )
}

export default DisplayABooking;