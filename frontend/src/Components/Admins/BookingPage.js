import React from "react";
import {Link as LinkRouter} from "react-router-dom";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import DisplayABooking from '../Layout/DisplayABooking';
import Table from 'react-bootstrap/Table';
import axios from 'axios';
import {API_URL} from '../../BackendLink';


export default class BookingPage extends React.Component {
  constructor(){
    super();
    this.state={
        bookingExist: false,
        res: []
    }
    this.sortClosest.bind(this);
    this.sortFurtherest.bind(this);
    this.sortByBookingId.bind(this);
    
}

componentDidMount(){
  this.sortByBookingId();
}

  formToggle = (stateName) => {
    this.setState({
      [stateName]: !this.state[stateName]
    });
  }

  sortByBookingId(){
    axios.get(API_URL+"/booking/allBooking/"+sessionStorage.getItem("companyId"))
  .then((response)=>{
      this.setState({"res": response.data});
      this.setState({"bookingExist": true});
  })
  .catch(()=>{
    this.setState({"bookingExist":false});
})
  .finally();
  }

  sortFurtherest(){
    axios.get(API_URL+"/booking/allBooking/"+sessionStorage.getItem("companyId")
    +"/ASC")
  .then((response)=>{
      this.setState({"res": response.data});
      this.setState({"bookingExist": true});
  })
  .catch(()=>{
    this.setState({"bookingExist":false});
})
  .finally();
  }

  sortClosest(){
    axios.get(API_URL+"/booking/allBooking/"+sessionStorage.getItem("companyId")
    +"/DESC")
  .then((response)=>{
      this.setState({"res": response.data});
      this.setState({"bookingExist": true});
  })
  .catch(()=>{
    this.setState({"bookingExist":false});
})
  .finally();
  }

  render() {
    const list = this.state.res.map((s)=> <DisplayABooking key={s.id} booking={s}/>);
    return (
      <div>
      <NavigationBarAdminPage/>
      <br></br>
      <br></br>
      <form className="adminDetails">
      <br></br>
        <LinkRouter to="/admin">
        <button className = "adminDash">Back to Dashboard</button>
        </LinkRouter>
        <br></br>
        <br></br>
        <h1>Booking History</h1>
        <br></br>
        <br></br>
        <button onClick={this.sortByBookingId.bind(this)} className = "btn btn-warning" type="button">Sort By Booking ID</button>
        {"  "}
        <button onClick={this.sortFurtherest.bind(this)} className = "btn btn-warning" type="button">Sort By Oldest Date</button>
        {"  "}
        <button onClick={this.sortClosest.bind(this)} className = "btn btn-warning" type="button">Sort By Newest Date</button>
        <br></br>
        <br></br>
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
        </form>
        </div>
    );
  }
}