import React, { Component} from 'react'
// import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'
import {Link as LinkRouter} from "react-router-dom";
import WorkerOption from '../Layout/WorkerOption';
import DisplayServiceOption from '../Layout/DisplayServiceOption';

export default class CustomerDashboard extends Component {
    constructor(){
        super();
       
        this.state={
            serviceExist: false,
            res: [], 
            workers: [],
            selectServiceId: -1,
            selectWorkerId: -1,
            selectDate: "",
            display:[], 
            duration: 0,
            description: "", 
        }
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    componentDidMount(){
        axios.get("http://localhost:8080/api/serviceObject/getAll")
        .then((response)=>{
            this.setState({"serviceExist": true});
            this.setState({"res": response.data});
        })
        .catch()
        .finally();

        axios.get("http://localhost:8080/api/worker/")
        .then((response)=>{
            this.setState({"workers":response.data});
            console.log("Workers");
            console.log(this.state.workers);
        })
        .catch()
        .finally();

    }

    handleSubmit = (event) => {
        if(this.state.selectServiceId > 0 && this.state.selectWorkerId >0){
        let duration1 = 0;
        let description1 ="";

        axios.get("http://localhost:8080/api/serviceObject/"+this.state.selectServiceId)
        .then((response)=>{
           
            duration1 = response.data.duration;
            description1 = response.data.description;
            this.setState({duration: duration1});
            this.setState({description: description1});
            this.getAvailable();
        })
        .catch()
        .finally();
        }else{
            alert("Select all search fields please!");
        }

    }

     selectedServiceId(e){
         this.setState({"selectServiceId":e.target.value});
         console.log(this.state.selectServiceId);
     }

    selectedWorkerId(e){
        this.setState({"selectWorkerId": e.target.value});
    }

    selectedDate(e){
        this.setState({selectDate: e.target.value});
    }

    getAvailable(){
        axios.get("http://localhost:8080/api/worker/" + this.state.selectWorkerId+"/"+this.state.selectServiceId
        +"/"+this.state.selectDate+"/"+this.state.description+"/"+this.state.duration+"/")
        .then((response)=>{
            this.setState({display: response.data});
            console.log(this.state.display);
        })
        .catch()
        .finally();
    }

    getFormattedDate(){
        const date = new Date();
        let day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month <= 9){
            month = "0" + month;
        }

        if(day < 10){
            day = "0" + day;
        }
        console.log(year + "-" + month +"-"+day);
        return year + "-" + month +"-"+day;       
    }

    render() {
        const serviceList = this.state.display.map((s)=> <DisplayAService key={"service"+s.startTime} service={s}/>);
        const serviceOption = this.state.res.map((s)=> <DisplayServiceOption key={s.id} service={s}/>);
        const workers = this.state.workers.map((w)=> <WorkerOption key={w.id} w={w}/>);
        return (
            <div>
            <NavigationBarCustomerPage/>
            <br></br>
            <article className = "custDash">
            <div>
                <LinkRouter to = "/custDetails">
                <button id = "userDetails">View User Details</button>
                </LinkRouter>
            </div>
            <br></br>
            <div>
                    <h1>Customer Dashboard</h1>
            </div>
            <br></br>
            <form className = "searchDash">
            <div id="datePicker">
                <input type="date" className = "datePicker" id="dateFilter" name="selectDate" placeholder = "Select Date"  min={this.getFormattedDate()}  onChange={this.selectedDate.bind(this)} required></input>
            </div>
            <br></br>
            <div>
                <select name="selectServiceId" id="serviceFilter" onChange={this.selectedServiceId.bind(this)} required>
                    <option defaultValue="">Select Service</option>
                    {serviceOption}
                </select> 
            </div> 
            <br></br>
            <div>
                <select name="selectWorkersId" id="workerFilter" onChange={this.selectedWorkerId.bind(this)} required>
                    <option defaultValue="">Select Worker</option>
                    {workers}
                </select>
            </div>
            <br></br>
            <div>
            <button className = "searchService" type="button" value="submit" onClick={this.handleSubmit}>Search</button>
            </div>
            <br></br>
            <br></br>
            </form>
            <br></br>
            <div className="container">
                <div className="row">
                    {serviceList}
                </div>
            </div>
            <br></br>
            </article>
            </div>  
        )
   }
}
