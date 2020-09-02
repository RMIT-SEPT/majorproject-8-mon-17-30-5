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
       getDescription();
    }, []);

    function getDescription(){
        
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
    }

    return (
        <div>
            <p>Id {props.booking.id}</p>
            <ul>
                <li>Service Id: {props.booking.serviceId}</li>
                <li>description:{userDetails.description}</li>
                <li>worker Id: {props.booking.workerId}</li>
                <li>worker name: {userDetails.workerName}</li>
                <li>Start time: {userDetails.startTime}</li>
                <li>Finish time: {userDetails.finishTime}</li>
            </ul>
        </div>
    )
}

export default DisplayABooking;