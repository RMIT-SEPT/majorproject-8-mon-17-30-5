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
      <div>
        <div className="btn" onClick={() => this.formToggle("addWorkerToggle")}>
          <button>Add</button>
          {this.state.addWorkerToggle ? <AddWorker/> : null}
        </div>
        <div className="btn" onClick={() => this.formToggle("editWorkerToggle")}>
          <button>Edit</button>
          {this.state.editWorkerToggle ? <EditWorker/> : null}
        </div>
      </div>
    );
  }
}