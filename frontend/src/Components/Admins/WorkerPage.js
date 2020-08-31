import React from "react";
import AddWorker from "./AddWorker";
import EditWorker from "./EditWorker";

export default class WorkerPage extends React.Component {
  state = {
    seen: false,
    addWorkerToggle: false,
    editWorkerToggle: false
  };

  addWorkerToggle = () => {
    this.setState({
      addWorkerToggle: !this.state.addWorkerToggle
    });
  };

  editWorkerToggle = () => {
    this.setState({
      editWorkerToggle: !this.state.editWorkerToggle
    });
  };

  render() {
    return (
      <div>
        <div className="btn" onClick={this.addWorkerToggle}>
          <button>Add</button>
          {this.state.addWorkerToggle ? <AddWorker/> : null}
        </div>
        <div className="btn" onClick={this.editWorkerToggle}>
          <button>Edit</button>
          {this.state.editWorkerToggle ? <EditWorker/> : null}
        </div>
      </div>
    );
  }
}