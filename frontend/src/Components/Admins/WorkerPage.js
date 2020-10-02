import React from "react";
import AddWorker from "./AddWorker";
import Table from 'react-bootstrap/Table';
import axios from 'axios';
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage'
import {Link as LinkRouter} from "react-router-dom";

export default class WorkerPage extends React.Component {
  state = {
    seen: false,
    addWorkerToggle: false,
    editWorkerToggle: false, 
    worker: []
  };

  componentDidMount(){
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
      <td>{w.startTime}</td>
      <td>{w.finishTime}</td>
      <td>{w.lunchBrTime}</td>
    </tr>);
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
      <th>#</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Username</th>
      <th>Start Time</th>
      <th>Finish Time</th>
      <th>Lunch Break</th>
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
      <td></td>
    </tr>
  </tbody>
</Table>
        <button class = "workerBtn" onClick={() => this.formToggle("addWorkerToggle")}>Add</button>
        {this.state.addWorkerToggle ? <AddWorker /> : null}
        <LinkRouter to="/admin/editworkers">
                <button class = "workerBtn" value="Edit">Edit</button>
        </LinkRouter>
        <LinkRouter to="/admin/viewworkers">
            <button class = "workerBtn" value="View">View</button>
        </LinkRouter>
        </article>
      </div>
    );
  }
}