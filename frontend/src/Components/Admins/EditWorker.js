import React, { Component } from "react";
import WorkerForm from "./WorkerForm"


export default class EditWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  submitEditWorker = (workerInfo) => {
    console.log("edit worker form submitted");
    console.log(workerInfo)
  }

  render() {
    let exampleWorker = {
      firstName: "Sara",
      lastName: "Tran",
      occupation: "Gym trainer",
      email: "sara.tran@gmail.com",
      username: "sara.tran123",
      password: "0123456789",
      workinghours: "4pm",
      workingdates: "Weekdays"
    }
    return (
      <div>       
        <WorkerForm onSubmit={this.submitEditWorker} workerInfo={exampleWorker}/>
      </div>
    );
  }
}