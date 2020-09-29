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
        .then(()=>{
            window.location.reload();
        })
        .catch()
        .finally();
    }

    function getDate(dateStr)
    {
        var dateParts = props.booking.date.split("-");
        return new Date(dateParts[0], dateParts[1] - 1, dateParts[2]);

    }

    var currDate = new Date();
    var checkDate = getDate(props.booking.date);

    return (
        
        <tr>
            <td>{props.booking.id}</td>
            <td>{userDetails.description}</td>
            <td>{props.booking.workerId}</td>
            <td>{props.booking.workerName}</td>
            <td>{props.booking.startTime}</td>
            <td>{props.booking.finishTime}</td>
            <td>{props.booking.date}</td>
            <td>{currDate <= checkDate && <button onClick={cancelBooking} className="btn btn-danger">Cancel</button>}
            {currDate > checkDate && "Booking Finished"}</td>
        </tr>
    )
}

export default DisplayABooking;