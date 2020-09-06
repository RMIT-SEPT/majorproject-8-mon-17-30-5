import React from 'react';
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import {Link as LinkRouter, Router} from "react-router-dom";

export default function WorkerDashboard() {
    return (
        
     <div>
        <NavigationBarCustomerPage/>
         <div className="jumbotron text-center">
         <h1>Worker Dashboard</h1>
         
        </div>
    </div>

    
    )
}
