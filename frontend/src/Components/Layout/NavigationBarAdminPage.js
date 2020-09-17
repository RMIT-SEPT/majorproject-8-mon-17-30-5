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
    }

    return(
        <div>
            <ul>
                
                <LinkRouter to="/admin">
                <li>Dashboard</li>
                </LinkRouter>
                <LinkRouter to  = "/admin/login">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarAdminPage;