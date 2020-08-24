import React from "react";
import AddWorker from "./AddWorker";

export default class WorkerPage extends React.Component {
  state = {
    seen: false
  };

  togglePop = () => {
    this.setState({
      seen: !this.state.seen
    });
  };

  render() {
    return (
      <div>
        <div className="btn" onClick={this.togglePop}>
          <button>Add</button>
        </div>
        {this.state.seen ? <AddWorker toggle={this.togglePop} /> : null}
      </div>
    );
  }
}