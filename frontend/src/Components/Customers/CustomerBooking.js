//TODO display all booking for customer -- done -- teach how to display
//possibly filter but not urgent
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
        
    }

    // constructor(props){
    //     super(props);
    //     this.setValue = this.setValue.bind(this);
    //     this.state = {sess};
    //     this.setState({["bookingExist"]: true});
        
    //   }
    
    //   setValue(key, value){
    //     let data = {};
    //     data[key] = value;
    //     this.setState(data);
    //   }
    //TODO check if this binding actually work!!!
    componentDidMount(){
        axios.get("http://localhost:8080/api/booking/customer/"+sessionStorage.getItem("id"))
        .then((response)=>{
            this.setState({"bookingExist": true});
            console.log(response.data);
            this.setState({"res": response.data});
            console.log(this.state.res);
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
            <NavigationBarCustomerPage/>
            <br></br>
            <form className = "custDash">
            <h1>Booking History</h1>
            <Table striped bordered hover>
            <thead>
            <tr>
                    <th>Booking ID</th>
                    <th>Description</th>
                    <th>Worker ID</th>
                    <th>Worker Name</th>
                    <th>Start Time</th>
                    <th>Finish Time</th>
            </tr>
            </thead>
            <tbody>
            {list}
            </tbody>
            </Table>
            </form>            
            </div>
        )
    }
}
