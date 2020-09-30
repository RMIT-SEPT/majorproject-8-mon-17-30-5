import React, { Component } from "react";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage'
import axios from 'axios';
import {Link as LinkRouter} from "react-router-dom";
import history from '../../history';

export default class EditWorker extends Component{

  constructor(props) {
    super(props);
    this.state = {
        value: '',
        firstName: sessionStorage.getItem("worker-firstname"),
        lastName: sessionStorage.getItem("worker-lastname"),
        username: sessionStorage.getItem("worker-username"),
        password: sessionStorage.getItem("worker-password"),
        startTime: sessionStorage.getItem("worker-startTime"),
        finishTime: sessionStorage.getItem("worker-finishTime"),
        lunchBrTime: sessionStorage.getItem("worker-lunchTime"),
        companyId: sessionStorage.getItem("companyId")
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    this.setState({
        [event.target.name]: event.target.value
    });

    if(event.target.name==="startTime"){
        if(event.target.value==="08:00" || event.target.value==="09:00"){
            document.getElementById("startTime").style.color = "black";
        }else{
            document.getElementById("startTime").style.color = "red";
        }
        
    }
  }

  handleSubmit(event) {
    event.preventDefault();
   // let { firstName, lastName, username, password, startTime, finishTime, lunchBrTime, companyId} = this.state
    let workerInfo = { 
      id: sessionStorage.getItem("worker-id"),
      firstName: this.state.firstName, 
      lastName: this.state.lastName, 
      username: this.state.username, 
      password: this.state.password, 
      startTime: this.state.startTime, 
      finishTime: this.state.finishTime, 
      lunchBrTime: this.state.lunchBrTime, 
      companyId: this.state.companyId};
    console.log(workerInfo);
    this.updatePerson(workerInfo);
  }

  updatePerson(person){
        
    try {
        console.log("updating a worker");
        axios.put("http://localhost:8080/api/worker/"+sessionStorage.getItem("worker-id"), person)
        .then(()=>{
          alert("successfully edit worker information.\n Go back to worker page?");
          history.push("/admin/workers");
          window.location.reload();
        })
        .finally();
        
      } catch (err) {
       console.log(err);
      }
  }
    render() {
    return (
      <div> 
      <NavigationBarAdminPage/>
      <br></br>
      <br></br>      
        <form className = "workerForm" onSubmit={this.handleSubmit}>
          <h1>Worker Details</h1>
          <label>
              First Name:
          <input type="text" placeholder={sessionStorage.getItem("worker-firstname")} name="firstName" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Last Name:
          <input type="text" placeholder={sessionStorage.getItem("worker-lastname")} name="lastName" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Username:
          <input type="text" placeholder={sessionStorage.getItem("worker-username")} name="username" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Password:
          <input type="password" placeholder={sessionStorage.getItem("worker-password")} name="password" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Start time:
          <input type="text" id="startTime" placeholder={sessionStorage.getItem("worker-startTime")} name="startTime" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Finish time:
          <input type="text" placeholder={sessionStorage.getItem("worker-finishTime")} name="finishTime" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Lunch break time:
          <input type="text" placeholder={sessionStorage.getItem("worker-lunchTime")} name="lunchBrTime" onChange={this.handleChange} />
                  </label>
                  <br />
                  <input className = "workerButton" type="submit" value="Submit"/>
                  <LinkRouter to="/admin/workers">
                  <input className = "workerButton" value="Cancel / Back" readOnly/>
                  </LinkRouter>
        </form>
        <br></br>
        <br></br>
      </div>
    );
    }
}