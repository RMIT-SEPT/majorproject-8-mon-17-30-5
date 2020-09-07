import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";

function NavigationBarWorkerPage(){
    function handleLogout(){
        sessionStorage.removeItem("id");
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("firstname");
        sessionStorage.removeItem("lastname");
        sessionStorage.removeItem("password");
        sessionStorage.removeItem("companyId");
        sessionStorage.removeItem("serviceId");
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
                <LinkRouter to  = "/worker/login">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarWorkerPage;