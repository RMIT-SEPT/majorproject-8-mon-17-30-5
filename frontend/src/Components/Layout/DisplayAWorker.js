import React from 'react';
import axios from 'axios';
import {Link as LinkRouter} from "react-router-dom";


export default function DisplayAWorker(props) {
    function handleClick(){
        sessionStorage.setItem("worker-id", props.worker.id);
        console.log("worker-id : " + sessionStorage.getItem("worker-id"));
        axios.get("http://localhost:8080/api/worker/"+sessionStorage.getItem("worker-id"))
        .then(function(response){
            console.log(response.data);
            sessionStorage.setItem("worker-username", response.data.username);
            sessionStorage.setItem("worker-firstname", response.data.firstName);
            sessionStorage.setItem("worker-lastname", response.data.lastName);
            sessionStorage.setItem("worker-companyId", response.data.companyId);
            sessionStorage.setItem("worker-password", response.data.password);
            sessionStorage.setItem("worker-serviceId", response.data.serviceId);
            sessionStorage.setItem("worker-startTime", response.data.startTime);
            sessionStorage.setItem("worker-finishTime", response.data.finishTime);
            sessionStorage.setItem("worker-lunchTime", response.data.lunchBrTime);
            sessionStorage.setItem("worker-phone", response.data.phone);
            window.location.reload();
        })
        .catch()
        .finally();
      }

    return (
      <tr>
      <td>{props.worker.id}</td>
      <td>{props.worker.firstName}</td>
      <td>{props.worker.lastName}</td>
      <td>{props.worker.username}</td>
      <td>{props.worker.startTime}</td>
      <td>{props.worker.finishTime}</td>
      <td>{props.worker.lunchBrTime}</td>
      <td>{props.worker.phone}</td>
      <td>
      <LinkRouter to="/admin/editworkers">
      <button onClick={handleClick} className = "btn btn-warning" value="Edit">Edit {props.worker.firstName}</button>
      </LinkRouter>
      <br></br>
      <br></br>
      <LinkRouter to="/admin/viewworkers">
      <button onClick={handleClick} className = "btn btn-info" value="View">View {props.worker.firstName}'s information</button>
      </LinkRouter>
      </td>
    </tr>
    )
}
