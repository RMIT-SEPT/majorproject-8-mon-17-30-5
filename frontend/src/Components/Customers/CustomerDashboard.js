import React, { Component} from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'
import {Link as LinkRouter} from "react-router-dom";
import WorkerOption from '../Layout/WorkerOption';
// import Select from "react-dropdown-select";
//TODO display all available services -- done -- teach how to recall
//TODO able to make booking
//TODO display history bookings -- from button click -- done

export default class CustomerDashboard extends Component {
    constructor(){
        super();
        this.state={
            serviceExist: false,
            res: [], 
            workers: [],
            selectServiceId: "jasdk",
            selectWorkerId: "dfsakjh"
        }
    }
    componentDidMount(){
        axios.get("http://localhost:8080/api/serviceObject/getAll")
        .then((response)=>{
            this.setState({"serviceExist": true});
            console.log(response.data);
            this.setState({"res": response.data});
            console.log(this.state.res);
        })
        .catch()
        .finally();

        //this will get all the workers
        axios.get("http://localhost:8080/api/worker/")
        .then((response)=>{
            this.setState({"workers":response.data});
            console.log("Workers");
            console.log(this.state.workers);
        })
        .catch()
        .finally();

    }

    handlechange(){
        this.setState({selectServiceId: "1"});
        console.log("selectedServiceId");
        console.log(this.state.selectServiceId);
    }

    //TODO test if mapping workers work!!
    render() {
        const serviceList = this.state.res.map((s)=> <DisplayAService key={s.id} service={s}/>);
        const workers = this.state.workers.map((w)=> <WorkerOption key={w.id} w={w}/>);
        return (
            <div>
            <NavigationBarCustomerPage/>
                <div className="jumbotron text-center">
                    <h1>Customer Dashboard</h1>
                    <LinkRouter to = "/custDetails">
                    <li id = "custDetails">View User Details</li>
                    </LinkRouter>
                    <p>This should show them any searched or available services</p>
                </div>
                <form>
                <div>
                    <select name="selectServiceId" id="serviceFilter" onChange={this.handlechange.bind(this)}>
                    <option defaultValue="">Select Service</option>
                    {serviceList}
                    </select>   
                </div>


                <div>
                    <select name="selectWorkersId" id="workerFilter">
                    <option defaultValue="">Select Worker</option>
                    {workers}
                    </select>
               </div>
                </form>
                
            </div>
               
        )
    
   }
}
