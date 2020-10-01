import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";

function NavigationBarAdminPage(){
    function handleLogout(){
        sessionStorage.removeItem("id");
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("firstname");
        sessionStorage.removeItem("lastname");
        sessionStorage.removeItem("password");
        sessionStorage.removeItem("companyId");
        if(sessionStorage.getItem("worker-id") != null){
            sessionStorage.removeItem("worker-id")};
        if(sessionStorage.getItem("worker-username") != null){
            sessionStorage.removeItem("worker-username")};
        if(sessionStorage.getItem("worker-firstname") != null){
            sessionStorage.removeItem("worker-firstname")};
        if(sessionStorage.getItem("worker-lastname") != null){
            sessionStorage.removeItem("worker-lastname")};
        if(sessionStorage.getItem("worker-password") != null){
            sessionStorage.removeItem("worker-password")};
        if(sessionStorage.getItem("worker-serviceId") != null){
            sessionStorage.removeItem("worker-serviceId")};
    }

    return(
        <div>
            <ul>
                
                <LinkRouter to="/admin">
                <li>Dashboard</li>
                </LinkRouter>
                <LinkRouter to="/admin/workers">
                <li>View Workers</li>
                </LinkRouter>
                <LinkRouter to="/admin/bookings">
                <li>View Bookings</li>
                </LinkRouter>
                <LinkRouter to  = "/admin/login">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarAdminPage;