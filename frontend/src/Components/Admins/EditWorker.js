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
        companyId: sessionStorage.getItem("companyId"),
        hidden: true,
        errors: {
            startTime: '',
            finishTime: '',
            lunchBrTime: '',
        }
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

    if (event.target.name === "finishTime") {
      if (event.target.value === "16:00" || event.target.value === "17:00") {
          document.getElementById("finishTime").style.color = "black";
      } else {
          document.getElementById("finishTime").style.color = "red";
      }
    }

    if (event.target.name === "lunchBrTime") {
        if (event.target.value === "11:00" || event.target.value === "12:00") {
            document.getElementById("lunchBrTime").style.color = "black";
        } else {
            document.getElementById("lunchBrTime").style.color = "red";
        }
    }

    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
        case 'startTime':
            errors.startTime =
                value !== '08:00' && value !== '09:00'
                    ? 'Please enter start time either 08:00 or 09:00'
                    : '';
            break;
        case 'finishTime':
            errors.finishTime =
                value !== '16:00' && value !== '17:00'
                    ? 'Please enter finish time either 16:00 or 17:00'
                    : '';
            break;
        case 'lunchBrTime':
            errors.lunchBrTime =
                value !== '11:00' && value !== '12:00'
                    ? 'Please enter lunch break time either 11:00 or 12:00'
                    : '';
            break;
        default:
            break;
    }

    this.setState({ errors, [name]: value });
  }

  handleSubmit(event) {
    event.preventDefault();
    let { startTime, finishTime, lunchBrTime} = this.state;
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
    let matches;
    let match1 = startTime === "08:00" || startTime === "09:00";
    let match2 = finishTime === "16:00" || finishTime === "17:00";
    let match3 = lunchBrTime === "11:00" || lunchBrTime === "12:00";
    matches = match1 && match2 && match3;
    matches ? this.updatePerson(workerInfo) : alert("Please enter correct time");
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
          <input type="text" id="finishime" placeholder={sessionStorage.getItem("worker-finishTime")} name="finishTime" onChange={this.handleChange} />
                  </label>
                  <br></br>
                  <label>
                      Lunch break time:
          <input type="text" id="lunchBrTime" placeholder={sessionStorage.getItem("worker-lunchTime")} name="lunchBrTime" onChange={this.handleChange} />
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