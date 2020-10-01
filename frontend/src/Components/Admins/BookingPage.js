import React from "react";
import {Link as LinkRouter} from "react-router-dom";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import DisplayABooking from '../Layout/DisplayABooking';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

export default class BookingPage extends React.Component {
  constructor(){
    super();
    this.state={
        bookingExist: false,
        res: []
    }
    
}

componentDidMount(){
  axios.get("http://localhost:8080/api/booking/allBooking/"+sessionStorage.getItem("companyId"))
  .then((response)=>{
      // console.log("response - data")
      this.setState({"res": response.data});
      this.setState({"bookingExist": true});
      // console.log(this.state.res);
  })
  .catch(()=>{
    this.setState({"bookingExist":false});
})
  .finally();
}

  formToggle = (stateName) => {
    this.setState({
      [stateName]: !this.state[stateName]
    });
  }

  render() {
    const list = this.state.res.map((s)=> <DisplayABooking key={s.id} booking={s}/>);
    return (
      <div>
      <NavigationBarAdminPage/>
        <br></br>
        <LinkRouter to="/admin">
        <button className = "workerBtn">back to dashboard</button>
        </LinkRouter>
        <br></br>
        <h1>Booking History</h1>
        {this.state.bookingExist && <Table striped bordered hover>
        <thead>
        <tr>
                <th>Booking ID</th>
                <th>Description</th>
                <th>Worker ID</th>
                <th>Worker Name</th>
                <th>Start Time</th>
                <th>Finish Time</th>
                <th>Date</th>
                <th>Status</th>
                <th>Manage</th>
        </tr>
        </thead>
        <tbody>
        {list}
        </tbody>
        </Table>}
        </div>
    );
  }
}