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

    function cancelBooking(){
        axios.delete("http://localhost:8080/api/booking/"+ props.booking.id)
        .then()
        .catch()
        .finally();
    }

    return (
        <tr>
            <td>{props.booking.id}</td>
            <td>{userDetails.description}</td>
            <td>{props.booking.workerId}</td>
            <td>{props.booking.workerName}</td>
            <td>{props.booking.startTime}</td>
            <td>{props.booking.finishTime}</td>
            <td>{props.booking.date}</td>
            <td><button onClick={cancelBooking} className="btn btn-danger">cancel</button></td>
        </tr>
    )
}

export default DisplayABooking;