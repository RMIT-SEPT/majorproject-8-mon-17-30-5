import React from 'react';
import '../../Style.css';
import {Link as LinkRouter} from "react-router-dom";

function NavigationBarWorkerPage(){
    function handleLogout(){
        sessionStorage.removeItem("worker-id");
        sessionStorage.removeItem("worker-username");
        sessionStorage.removeItem("worker-firstname");
        sessionStorage.removeItem("worker-lastname");
        sessionStorage.removeItem("worker-password");
        sessionStorage.removeItem("worker-companyId");
        sessionStorage.removeItem("worker-serviceId");
        sessionStorage.removeItem("worker-phone");
    }

    return(
        <div>
            <ul>
                <LinkRouter to  = "/worker/login">
                <li id = "logout" onClick={handleLogout}>Log Out</li>
                </LinkRouter>
            </ul>
        </div>
    );
}

export default NavigationBarWorkerPage;