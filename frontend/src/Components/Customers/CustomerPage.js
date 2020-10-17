<<<<<<< HEAD
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
            <h1> Welcome {sessionStorage.getItem("username")}</h1>
            <LinkRouter to = "/booking-page">
            <button id = "booking" className = "booking">View Booking History</button>
            </LinkRouter>
            <br></br>
            <br></br>
            <h2>User Details</h2>
            <label>Username : {sessionStorage.getItem("username")}</label>
            <br></br>
            <label>First Name : {sessionStorage.getItem("firstname")}</label>
            <br></br>
            <label>Last Name : {sessionStorage.getItem("lastname")}</label>
            <br></br>
            <label>Phone Number : {sessionStorage.getItem("phone")}</label>
            <br></br>
            <label>Billing Address : {sessionStorage.getItem("billingAddress")}</label>
            <br></br>
            <label>Shipping Address : {sessionStorage.getItem("shippingAddress")}</label>
            <br></br>
            <LinkRouter to = "/editCustomer">
            <button className = "editCustomer">Change My Details</button>
            </LinkRouter>
        </form>
        </div>
    );
}
=======
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
            <h1> Welcome {sessionStorage.getItem("username")}</h1>
            <LinkRouter to = "/booking-page">
            <button id = "booking" className = "booking">View Booking History</button>
            </LinkRouter>
            <br></br>
            <br></br>
            <h2>User Details</h2>
            <label>Username : {sessionStorage.getItem("username")}</label>
            <br></br>
            <label>First Name : {sessionStorage.getItem("firstname")}</label>
            <br></br>
            <label>Last Name : {sessionStorage.getItem("lastname")}</label>
            <br></br>
            <label>Phone Number : {sessionStorage.getItem("phone")}</label>
            <br></br>
            <label>Billing Address : {sessionStorage.getItem("billingAddress")}</label>
            <br></br>
            <label>Shipping Address : {sessionStorage.getItem("shippingAddress")}</label>
            <br></br>
            <LinkRouter to = "/editCustomer">
            <button className = "editCustomer">Change My Details</button>
            </LinkRouter>
        </form>
        </div>
    );
}
>>>>>>> m3-local
export default CustomerPage;