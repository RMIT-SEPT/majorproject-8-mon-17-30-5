import WorkerForm from "./WorkerForm"
import React, { Component, useState} from "react";
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";

export default class AddWorker extends Component {
  constructor(props) {
    super(props);
    //this.submitAddWorker = this.submitAddWorker.bind(this);
  }

  handleClick = () => {
    this.props.toggle();
  };

  // submitAddWorker = (workerInfo) => {
  //   // TODO: submit to backend
  //   console.log("Add worker form submitted");
  //   console.log(workerInfo);
  //  // console.log(this.props.history);
  //  this.createPerson(workerInfo);
  // }

<<<<<<< HEAD
  
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
 /* handleSubmit(event) {
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
  }*/
=======
  // async createPerson(person){
  //   try {
  //       console.log("creating a worker");
  //       const res = await axios.post("http://localhost:8080/api/worker/create", person);
  //       // TODO: push to React history
  //       // history.push("/");
  //     } catch (err) {
  //      console.log(err);
  //     }
  //    }

>>>>>>> 2aa89a8ea999e688ec92cb5e7ed2c1d24dcfa64a

  /*render() {
    render() {

      return (
        <div> 
        <WorkerForm/>
        </div>      
    );
  }*/
} 