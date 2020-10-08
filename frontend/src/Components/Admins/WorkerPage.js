import React from "react";
import AddWorker from "./AddWorker";
import Table from 'react-bootstrap/Table';
import axios from 'axios';
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import DisplayAWorker from '../Layout/DisplayAWorker';
import {Link as LinkRouter} from "react-router-dom";

export default class WorkerPage extends React.Component {
  state = {
    seen: false,
    addWorkerToggle: false,
    editWorkerToggle: false, 
    worker: []
  };

  componentDidMount(){
    axios.get("http://localhost:8080/api/worker/companyId/"+sessionStorage.getItem("companyId"))
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
    const workers = this.state.worker.map((w)=> <DisplayAWorker key={w.id} worker={w}/>);
    return (
      <div>
      <NavigationBarAdminPage/>
      <br></br>
      <br></br>
      <article className = "workerPage">
      <LinkRouter to="/admin">
        <button className = "adminDash">Back to Dashboard</button>
      </LinkRouter>
      <br></br>
      <br></br>
      <h1>Worker Information</h1>
      <Table striped bordered hover>
  <thead>
    
    <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Username</th>
      <th>Start Time</th>
      <th>Finish Time</th>
      <th>Lunch Break</th>
      <th>Phone Number</th>
      <th>Manage</th>
    </tr>
  </thead>
  <tbody>
  {workers}
  </tbody>
</Table>
        <button className = "workerBtn" onClick={() => this.formToggle("addWorkerToggle")}>Add New Worker</button>
        {this.state.addWorkerToggle ? <AddWorker /> : null}
        </article>
      </div>
    );
  }
}