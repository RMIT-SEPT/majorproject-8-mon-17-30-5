import React from 'react';
import axios from 'axios';
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';
import "bootstrap/dist/css/bootstrap.min.css";

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
        axios.post("http://localhost:8080/api/booking/create/", booking)
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
        <NavigationBarCustomerPage/>
        <br></br>
        <br></br>
       <article className = "confirmBook" >
       <h1>Booking information</h1>
       <label>Workername: {sessionStorage.getItem("booking-workername")}</label>
       <br></br>
       <label>Description: {sessionStorage.getItem("booking-serviceDescription")}</label>
       <br></br>
       <label>Date: {sessionStorage.getItem("booking-date")}</label>
       <br></br>
       <label>Start: {sessionStorage.getItem("booking-startTime")}</label>
       <br></br>
       <label>Finish: {sessionStorage.getItem("booking-finishTime")}</label>
       <br></br>
       <label>Duration: {sessionStorage.getItem("booking-duration")} Hour</label>
       <br></br>
       <br></br>
       <label>Book as {sessionStorage.getItem("firstname")}</label>
       <br></br>
       <br></br>
       <button id = "confirmBook" onClick={handleSubmit}>Confirm</button>
       <br></br>
       <br></br>
       <button id = "cancelBook" onClick={clearBookingInfo}>Cancel</button>
       </article>  
    </div>  
    )
}

export default MakeBooking;

