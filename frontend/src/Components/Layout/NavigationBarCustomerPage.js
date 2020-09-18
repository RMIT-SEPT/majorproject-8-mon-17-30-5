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
                <LinkRouter to= "/about-us">
                <li>About Us </li>
                </LinkRouter>
                <LinkRouter to="/contact-us">
                <li>Contact Us</li>
                </LinkRouter>
                <LinkRouter to  = "/loginForm">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarCustomerPage;