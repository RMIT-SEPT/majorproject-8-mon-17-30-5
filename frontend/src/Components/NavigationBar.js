import React from 'react';
import './LoginForm.css';
import {Link as LinkRouter} from "react-router-dom";
import AboutUs from  "./AboutUs";

function NavigationBar(){
    return(
        <div>
            <ul>
                <LinkRouter to= "/about-us">
                <li><a>About Us </a></li>
                </LinkRouter>
                <LinkRouter to="/contact-us">
                <li><a>Contact Us</a></li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBar;