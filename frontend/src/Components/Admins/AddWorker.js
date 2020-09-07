import WorkerForm from "./WorkerForm"
import React, { Component} from "react";


export default class AddWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

    render() {
      return (
        <div> 
        <WorkerForm/>
        </div>      
    );
  };
}
