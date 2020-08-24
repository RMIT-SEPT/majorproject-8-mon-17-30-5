import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";
import AboutUs from  "../AboutUs";

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
            </ul>
        </div>
    );
}

export default NavigationBar;