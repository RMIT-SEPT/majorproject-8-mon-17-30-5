import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";

function NavigationBar(){
    return(
        <div>
            <ul>
                <LinkRouter to= "/about-us">
                <li>About Us </li>
                </LinkRouter>
                <LinkRouter to="/contact-us">
                <li>Contact Us</li>
                </LinkRouter>
                <LinkRouter to="/">
                <li>Customer Login</li>
                </LinkRouter>
                <LinkRouter to="/admin/login">
                <li>Admin Login</li>
                </LinkRouter>
                <LinkRouter to="/worker/login">
                <li>Worker Login</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBar;