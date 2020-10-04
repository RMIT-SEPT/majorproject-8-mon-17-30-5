import React, { Component} from 'react';
import axios from 'axios';
import DisplayABooking from '../Layout/DisplayABooking';
import Table from 'react-bootstrap/Table';
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'

export default class CustomerBooking extends Component {
    constructor(){
        super();
        this.state={
            bookingExist: true,
            res: []
        }
        this.sortClosest.bind(this);
        this.sortFurtherest.bind(this);
        this.sortByBookingId.bind(this);
    }

    componentDidMount(){
       this.sortByBookingId();
    }

    sortByBookingId(){
        axios.get("http://localhost:8080/api/booking/customer/"+sessionStorage.getItem("id"))
        .then((response)=>{
           // this.setState({"bookingExist": true});
            console.log("found booking");
            console.log(response.data);
            this.setState({"res": response.data});
            console.log(this.state.res);
        })
        .catch(()=>{
            this.setState({"bookingExist":false});
        })
        .finally();
    }

    sortFurtherest(){
        axios.get("http://localhost:8080/api/booking/customer/"+sessionStorage.getItem("id")+"/dateASC")
        .then((response)=>{
          //  this.setState({"bookingExist": true});
            console.log("found booking");
            console.log(response.data);
            this.setState({"res": response.data});
            console.log(this.state.res);
            //window.location.reload();
        })
        .catch()
        .finally();
    }

    sortClosest(){
        axios.get("http://localhost:8080/api/booking/customer/"+sessionStorage.getItem("id")+"/dateDESC")
        .then((response)=>{
          //  this.setState({"bookingExist": true});
            console.log("found booking");
            console.log(response.data);
            this.setState({"res": response.data});
            console.log(this.state.res);
            //window.location.reload();
        })
        .catch()
        .finally();
    }

    render() {
        const list = this.state.res.map((s)=> <DisplayABooking key={s.id} booking={s}/>);
        return (
            <div>
            <NavigationBarCustomerPage/>
            <br></br>
            <article className = "custDash">
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
            <Table 
            striped 
            bordered 
            hover>
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
            </Table>
            </article>            
            </div>
        )
    }
}
