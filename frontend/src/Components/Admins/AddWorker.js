import WorkerForm from "./WorkerForm"
import React, { Component, useState} from "react";
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";

export default class AddWorker extends Component {
  constructor(props) {
    super(props);
    this.submitAddWorker = this.submitAddWorker.bind(this);
  }

  handleClick = () => {
    this.props.toggle();
  };

  submitAddWorker = (workerInfo) => {
    // TODO: submit to backend
    console.log("Add worker form submitted");
    console.log(workerInfo);
   // console.log(this.props.history);
   this.createPerson(workerInfo);
  }

  async createPerson(person){
    try {
        console.log("creating a worker");
        const res = await axios.post("http://localhost:8080/api/worker/create", person);
        // TODO: push to React history
        // history.push("/");
      } catch (err) {
       console.log(err);
      }
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