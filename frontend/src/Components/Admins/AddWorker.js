import WorkerForm from "./WorkerForm"
import React, { Component, useState} from "react";
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";

export default class AddWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  // submitAddWorker = (workerInfo) => {
  //   // TODO: submit to backend
  //   console.log("Add worker form submitted");
  //   console.log(workerInfo)
  // }

  
//TODO delete useHistory if not needed
AddWorker() {
 
  const history = useHistory();
  const[userDetails, setUserDetails] = useState({
    username: "",
    firstname:"",
    lastname: "",
    password: "",
    starttime:"",
    finishtime:"",
    hasLoginFailed: false
  });
     //export default class AddWorker extends Component {
}
  handleSubmit(event) {
    console.log("handleSubmit");
    event.preventDefault();
    const person = {
      username: userDetails.username,
      firstName: userDetails.finishtime,
      lastName:userDetails.lastname,
      password:userDetails.password,
      startTime:userDetails.starttime,
      finishTime:userDetails.finishtime
    }
    console.log(person);
    createPerson(person);
  }

  //render() {
    render() {

      return (
        <div> 
        <WorkerForm onSubmit={this.submitAddWorker}/>
        </div>      
    );
  }
}