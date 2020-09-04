import React, { Component } from "react";
import WorkerForm from "./WorkerForm"
import React, { Component, useState} from "react";
import Dropdown from 'react-dropdown';
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";
const options = ['Female', 'Male'];

export default class AddWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  submitAddWorker = (workerInfo) => {
    // TODO: submit to backend
    console.log("Add worker form submitted");
    console.log(workerInfo)
  }

  
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
  function handleClick() {
    this.props.toggle();
  };

  function handleChange(event){
    const{name, value} = event.target;
    setUserDetails(prevValue =>{
      return {
        ...prevValue,
        [name] : value
      }
    })
  }

  async function createPerson(person){
    try {
        console.log("creating a worker");
        const res = await axios.post("http://localhost:8080/api/worker/create", person);
        history.push("/");
      } catch (err) {
       console.log(err);
      }
    
 }

  function handleSubmit(event) {
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
   // console.log(this.props.history);
   createPerson(person);
  }
}

  //render() {
    render() {

      return (
        <div> 
        <WorkerForm onSubmit={this.submitAddWorker} workerInfo/>
        </div>      
    );
  }
}

export default AddWorker;