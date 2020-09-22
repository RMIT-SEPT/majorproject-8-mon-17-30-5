import React from 'react';
import axios from 'axios';

function MakeBooking(props){

    function handleSubmit(){
        const booking = {
            "customerId": sessionStorage.getItem("id"),
            "workerId": sessionStorage.getItem("booking-workerId"),
            "workerName": sessionStorage.getItem("booking-workername"),
            "serviceId": sessionStorage.getItem("booking-serviceId"),
            "startTime": sessionStorage.getItem("booking-startTime"),
            "finishTime": sessionStorage.getItem("booking-finishTime"),
            "date": sessionStorage.getItem("booking-date")
        }
        axios.post("http://Majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/booking/create/", booking)
        .then(()=>{
            clearBookingInfo();
            props.history.push("/customerDashBoard");
        })
        .catch()
        .finally();
    }   

    function clearBookingInfo(){
        sessionStorage.removeItem("booking-serviceId");
        sessionStorage.removeItem("booking-workerId");
        sessionStorage.removeItem("booking-workername");
        sessionStorage.removeItem("booking-startTime");
        sessionStorage.removeItem("booking-finishTime");
        sessionStorage.removeItem("booking-date");
        sessionStorage.removeItem("booking-serviceDescription",);
        sessionStorage.removeItem("booking-duration");
        props.history.push("/customerDashBoard");
    }



    return (
       <div>
       <p>Booking information</p>
       <ul>
       <li>workername: {sessionStorage.getItem("booking-workername")}</li>
       <li>start: {sessionStorage.getItem("booking-startTime")}</li>
       <li>finish: {sessionStorage.getItem("booking-finishTime")}</li>
       <li>date: {sessionStorage.getItem("booking-date")}</li>
       <li>description:{sessionStorage.getItem("booking-serviceDescription")}</li>
       <li>duration: {sessionStorage.getItem("booking-duration")}</li>
       </ul>
       <p>Book by {sessionStorage.getItem("firstname")}</p>
       <br></br>
       <button onClick={clearBookingInfo}>cancel</button>
       <br></br>
       <button onClick={handleSubmit}>confirm</button>
       </div>    
    )
}

export default MakeBooking;

