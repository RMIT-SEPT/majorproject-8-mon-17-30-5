<<<<<<< HEAD
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";
import axios from 'axios';
import {API_URL} from '../../BackendLink';


function DisplayAService(props) {
    function handleClick(){
        sessionStorage.setItem("booking-serviceId",props.service.serviceId);
        sessionStorage.setItem("booking-workerId", props.service.workerId);
        sessionStorage.setItem("booking-workername", props.service.workerName);
        sessionStorage.setItem("booking-startTime", props.service.startTime);
        sessionStorage.setItem("booking-finishTime", props.service.finishTime);
        sessionStorage.setItem("booking-date", props.service.date);
        sessionStorage.setItem("booking-serviceDescription", props.service.description);
        sessionStorage.setItem("booking-duration", props.service.duration);
       
        axios.get(API_URL+"/worker/worker-company/" + sessionStorage.getItem("booking-workerId"))
        .then((response)=>{
            sessionStorage.setItem("booking-companyId", response.data);
            console.log("companyID");
            console.log(response.data);
        })
        .catch()
        .finally();
    }

    function formatDate(dateStr)
    {
        var output;
        if(dateStr.length === 4)
        {
            output = [dateStr.slice(0, 2), ':', dateStr.slice(2)].join('');
            return output;
        }

        if(dateStr.length === 3)
        {
            output = [dateStr.slice(0, 1), ':', dateStr.slice(1)].join('');
            return output;
        }
    }

    var startString = (props.service.startTime).toString();
    var finishString = (props.service.finishTime).toString();

    var start = formatDate(startString);
    var finish = formatDate(finishString);

    function ifTimePassed(start, date){
        if(date === getFormattedDate(0)){
            const now = new Date();
            let hr = now.getHours();
            let startHr = start/100;
            
            if(hr >= startHr){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
        
    }

    function getFormattedDate(num){
        const today = new Date();
        var date = new Date(today.getTime() + num * 24 * 60 * 60 * 1000);
        let day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month < 10){
            month = "0" + month;
        }

        if(day < 10){
            day = "0" + day;
        }
        return year + "-" + month +"-"+day; 
    }

    return (
        <div className="col-sm-3" >
        {props.service.isFree==="true" && <div className="btn btn-info btn-block">
            <p>{props.service.description}</p>
            <ul>
                <li>Worker Name: {props.service.workerName}</li>
                <li>Duration: {props.service.duration} Hour</li>
                <li>Start Time: {start}</li>
                <li>End Time: {finish}</li>
                <li>Date: {props.service.date}</li>
                <li hidden>isFree: {props.service.isFree}</li>
            </ul>
            <br></br>
            
            {ifTimePassed(props.service.startTime, props.service.date)===false && 
            <LinkRouter to="/customer/makeBooking"><button id = "book" onClick={handleClick}>Book</button></LinkRouter>}
            {ifTimePassed(props.service.startTime, props.service.date) && 
                <button className="btn btn-danger" readOnly>Not Available</button>}
            <br></br>
        </div>}
        {props.service.isFree==="false" && <div className="btn btn-secondary btn-block">
        <p>{props.service.description}</p>
        <ul>
            <li>Worker Name: {props.service.workerName}</li>
            <li>Duration: {props.service.duration} Hour</li>
            <li>Start Time: {start}</li>
            <li>End Time: {finish}</li>
            <li>Date: {props.service.date}</li>
            <li hidden>isFree: {props.service.isFree}</li>
        </ul>
        <br></br>
        
        <button className="btn btn-danger" readOnly>Not Available</button>
        <br></br>
        </div>}
        <br></br>
        </div>
        
    );
}

export default DisplayAService;
=======
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import {Link as LinkRouter} from "react-router-dom";
import axios from 'axios';


function DisplayAService(props) {
    function handleClick(){
        sessionStorage.setItem("booking-serviceId",props.service.serviceId);
        sessionStorage.setItem("booking-workerId", props.service.workerId);
        sessionStorage.setItem("booking-workername", props.service.workerName);
        sessionStorage.setItem("booking-startTime", props.service.startTime);
        sessionStorage.setItem("booking-finishTime", props.service.finishTime);
        sessionStorage.setItem("booking-date", props.service.date);
        sessionStorage.setItem("booking-serviceDescription", props.service.description);
        sessionStorage.setItem("booking-duration", props.service.duration);
       
        axios.get("http://localhost:8080/api/worker/worker-company/" + sessionStorage.getItem("booking-workerId"))
        .then((response)=>{
            sessionStorage.setItem("booking-companyId", response.data);
            console.log("companyID");
            console.log(response.data);
        })
        .catch()
        .finally();
    }

    function formatDate(dateStr)
    {
        var output;
        if(dateStr.length === 4)
        {
            output = [dateStr.slice(0, 2), ':', dateStr.slice(2)].join('');
            return output;
        }

        if(dateStr.length === 3)
        {
            output = [dateStr.slice(0, 1), ':', dateStr.slice(1)].join('');
            return output;
        }
    }

    var startString = (props.service.startTime).toString();
    var finishString = (props.service.finishTime).toString();

    var start = formatDate(startString);
    var finish = formatDate(finishString);

    function ifTimePassed(start, date){
        if(date === getFormattedDate(0)){
            const now = new Date();
            let hr = now.getHours();
            let startHr = start/100;
            
            if(hr >= startHr){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
        
    }

    function getFormattedDate(num){
        const today = new Date();
        var date = new Date(today.getTime() + num * 24 * 60 * 60 * 1000);
        let day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month < 10){
            month = "0" + month;
        }

        if(day < 10){
            day = "0" + day;
        }
        return year + "-" + month +"-"+day; 
    }

    return (
        <div className="col-sm-3" >
        {props.service.isFree==="true" && <div className="btn btn-info btn-block">
            <p>{props.service.description}</p>
            <ul>
                <li>Worker Name: {props.service.workerName}</li>
                <li>Duration: {props.service.duration} Hour</li>
                <li>Start Time: {start}</li>
                <li>End Time: {finish}</li>
                <li>Date: {props.service.date}</li>
                <li hidden>isFree: {props.service.isFree}</li>
            </ul>
            <br></br>
            
            {ifTimePassed(props.service.startTime, props.service.date)===false && 
            <LinkRouter to="/customer/makeBooking"><button id = "book" onClick={handleClick}>Book</button></LinkRouter>}
            {ifTimePassed(props.service.startTime, props.service.date) && 
                <button className="btn btn-danger" readOnly>Not Available</button>}
            <br></br>
        </div>}
        {props.service.isFree==="false" && <div className="btn btn-secondary btn-block">
        <p>{props.service.description}</p>
        <ul>
            <li>Worker Name: {props.service.workerName}</li>
            <li>Duration: {props.service.duration} Hour</li>
            <li>Start Time: {start}</li>
            <li>End Time: {finish}</li>
            <li>Date: {props.service.date}</li>
            <li hidden>isFree: {props.service.isFree}</li>
        </ul>
        <br></br>
        
        <button className="btn btn-danger" readOnly>Not Available</button>
        <br></br>
        </div>}
        <br></br>
        </div>
        
    );
}

export default DisplayAService;
>>>>>>> m3-local
