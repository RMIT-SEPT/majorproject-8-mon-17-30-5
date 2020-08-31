import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";
import AboutUs from  "../AboutUs";

function NavigationBarCustomerPage(){
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
                <li id = "logout">Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarCustomerPage;