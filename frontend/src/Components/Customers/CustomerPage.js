import React from 'react';
import '../../App.css'
import {Link as LinkRouter} from "react-router-dom";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';

function CustomerPage(){
    return(
        <div>
        <NavigationBarCustomerPage/>
        <br></br>
        <br></br>
        <br></br>

        <form className = "custDetails" id = "custDetails">
            <h1> Welcome #username</h1>
            <LinkRouter to = "/booking-page">
            <button id = "booking" className = "booking">View Booking History</button>
            </LinkRouter>
            <h2>User Details</h2>
            <br></br>
            <br></br>
            <label>Username : username</label>
            <br></br>
            <label>First Name : firstname</label>
            <br></br>
            <label>Last Name : lastname</label>
            <br></br>
            <label>Billing Address : billingAddress</label>
            <br></br>
            <br></br>
            <label>User Address : billingAddress</label>
        </form>
        </div>
    );
}
export default CustomerPage;