import React from "react";
import AddWorker from "./AddWorker";
import EditWorker from "./EditWorker";
import ViewWorker from "./ViewWorker";
import Table from 'react-bootstrap/Table';
import axios from 'axios';

export default class WorkerPage extends React.Component {
  state = {
    seen: false,
    addWorkerToggle: false,
    editWorkerToggle: false, 
    worker: []
  };

  componentDidMount(){
    //this will get all the workers
    axios.get("http://localhost:8080/api/worker/")
    .then((response)=>{
        this.setState({"worker":response.data});
        console.log("Workers");
        console.log(this.state.worker);
    })
    .catch()
    .finally();
  }

  formToggle = (stateName) => {
    this.setState({
      [stateName]: !this.state[stateName]
    });
  }

  render() {
    const workers = this.state.worker.map((w)=> 
    <tr key={w.id}>
      <td>{w.id}</td>
      <td>{w.firstName}</td>
      <td>{w.lastName}</td>
      <td>{w.username}</td>
    </tr>);
    return (
      <div>
      <Table striped bordered hover>
  <thead>
    
    <tr>
      <th>#</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Occupation</th>
      <th>Working Dates</th>
      <th>Working Hours</th>
      <th>Option</th>
    </tr>
  </thead>
  <tbody>
  {workers}
    {}
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td>
      <div onClick={() => this.formToggle("editWorkerToggle")}>Edit</div>
        {this.state.editWorkerToggle ? <EditWorker /> : null}
        <div onClick={() => this.formToggle("addWorkerToggle")}>View</div>
        {this.state.addWorkerToggle ? <ViewWorker /> : null}
      </td>
    </tr>
  </tbody>
</Table>
        <div onClick={() => this.formToggle("addWorkerToggle")}>Add</div>
        {this.state.addWorkerToggle ? <AddWorker /> : null}
      </div>
    );
  }
}