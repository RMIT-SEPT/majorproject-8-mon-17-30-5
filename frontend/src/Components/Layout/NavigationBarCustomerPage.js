import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";

function NavigationBarCustomerPage(){
    function handleLogout(){
        sessionStorage.removeItem("id");
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("firstname");
        sessionStorage.removeItem("lastname");
        sessionStorage.removeItem("billingAddress");
        sessionStorage.removeItem("shippingAddress");
    }

    return(
        <div>
            <ul>
                <LinkRouter to="/customerDashBoard">
                <li>Search for a service</li>
                </LinkRouter>
                <LinkRouter to="custDetails">
                <li>My Account</li>
                </LinkRouter>
                <LinkRouter to="/booking-page">
                <li>My Booking</li>
                </LinkRouter>
                <LinkRouter to  = "/loginForm">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarCustomerPage;