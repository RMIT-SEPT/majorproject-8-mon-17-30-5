  
import React from 'react'
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
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
