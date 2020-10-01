  
import React from 'react'
//import Table from 'react-bootstrap/Table';
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
//import axios from 'axios';
import WorkerInfoBoard from './WorkerInfoBoard';

export default function WorkerDashboard() {

   
    return (
        
        <div className = "buttonholder">
            <NavigationBarWorkerPage/>
            <br></br>
            <br></br>
            <WorkerInfoBoard></WorkerInfoBoard>
            <br></br>
            <br></br>
        </div>
        
    );
}
