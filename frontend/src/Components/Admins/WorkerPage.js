import React from "react";
import AddWorker from "./AddWorker";
import EditWorker from "./EditWorker";


export default class WorkerPage extends React.Component {
  state = {
    seen: false,
    addWorkerToggle: false,
    editWorkerToggle: false
  };

  formToggle = (stateName) => {
    this.setState({
      [stateName]: !this.state[stateName]
    });
  }

  render() {
    return (
      <>
        <div onClick={() => this.formToggle("addWorkerToggle")}>Add</div>
        {this.state.addWorkerToggle ? <AddWorker /> : null}
        <br/>
        <div onClick={() => this.formToggle("editWorkerToggle")}>Edit</div>
        {this.state.editWorkerToggle ? <EditWorker /> : null}
        <br/>
      </>
    );
  }
}