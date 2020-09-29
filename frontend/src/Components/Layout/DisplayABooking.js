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

    function getFormattedDate(num){
        const today = new Date();
        var date = new Date(today.getTime() + num * 24 * 60 * 60 * 1000);
        const day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month < 10){
            month = "0" + month;
        }
        return year + "-" + month +"-"+day; 
    }

    function canCancel(date){
        const today = getFormattedDate(0);
        const tomorrow = getFormattedDate(1);
        if(date === today){
            return false;
        }
        else if(date === tomorrow){
            return false;
        }
        else{
            return true;
        }
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
            <td>{canCancel(props.booking.date) && <button onClick={cancelBooking} className="btn btn-danger">cancel</button>}
            {canCancel(props.booking.date)==false && "cannot cancel in less than 48 hrs"}
            </td>
        </tr>
    )
}

export default DisplayABooking;