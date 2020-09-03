import React, { Component } from "react";
import WorkerForm from "./WorkerForm"

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

  render() {
    return (
      <div>       
        <WorkerForm onSubmit={this.submitAddWorker} workerInfo/>
      </div >
    );
  }
}
