import React, { Component} from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'
import {Link as LinkRouter} from "react-router-dom";
import WorkerOption from '../Layout/WorkerOption';
//import 'react-datepicker/dist/react-datepicker.css';
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

    handleSubmit = (event) => {
        console.log("submit");
        console.log(this.state.selectServiceId);
        console.log(this.state.selectWorkerId);
        console.log(this.state.selectDate);
        //getservice duration -- service
        let duration1 = 0;
        let description1 ="";
        //get working hrs -- worker
        //get break time -- worker
        var startTime = "";
        let finishTime = "";
        let breakTime = "";

        axios.get("http://localhost:8080/api/serviceObject/"+this.state.selectServiceId+"/duration")
        .then((response)=>{
            duration1 = response.data.duration;
            description1 = response.data.description;
            this.setState({duration: duration1});
            this.setState({description: description1});
            console.log(duration1);
        })
        .catch()
        .finally();

        axios.get("http://localhost:8080/api/worker/" + this.state.selectWorkerId)
        .then((response)=>{
            startTime = response.data.startTime;
            finishTime = response.data.finishTime;
            breakTime = response.data.lunchBrTime;
            startTime = startTime.replace(':', '');
            finishTime = finishTime.replace(':', '');
            breakTime = breakTime.replace(':', '');
            console.log("time: "+startTime+" "+finishTime+" "+breakTime);
            var diff = finishTime-breakTime;
            console.log(diff);
            var j = 100*duration1;
            var array = [];
            for(var i =startTime*1; i < (finishTime*1); i = i +j){
                if(i !== breakTime*1){
                    var temp = i +j;
                    if(!(breakTime*1 > i && breakTime*1 < temp)){
                        array.push(i);
                    }
                    
                }
            }

            var displaying = [];
            for(var k =0; k < array.length; k++){
                const disc = {
                    serviceId: this.state.selectServiceId,
                    workerId: this.state.selectWorkerId,
                    workername: response.data.firstName,
                    date: this.state.selectDate,
                    description: this.state.description,
                    duration: this.state.duration,
                    startTime: array[k],
                    finishTime: array[k] + j,
                }
                displaying.push(disc);
            }
            
            this.setState({display: displaying});
            console.log(this.state.display);
        })
        .catch()
        .finally();
        // 
        // console.log(startTime);
        //get already booked time based on date and workerId
    }

    splitTime(time){
        return time.replace(':', '');
    }

     selectedServiceId(e){
         this.setState({"selectServiceId":e.target.value});
     }

    selectedWorkerId(e){
        this.setState({"selectWorkerId": e.target.value});
    }

    selectedDate(e){
        this.setState({selectDate: e.target.value});
    }

    getFormattedDate(){
        const date = new Date();
        const day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        if(month < 10){
            month++;
            month = "0" + month;
        }
        return year + "-" + month +"-"+day;
        // const dateMax = new Date(Date.now() + 7 * 24 * 60 * 60 * 1000);
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
                    <select name="selectServiceId" id="serviceFilter" onChange={this.selectedServiceId.bind(this)}>
                    <option defaultValue="">Select Service</option>
                    {serviceList}
                    </select>   
                </div>
                <br></br>
                <div id="datePicker">
                    <input type="date" id="dateFilter" name="selectDate" min={this.getFormattedDate()}  onChange={this.selectedDate.bind(this)} ></input>
                </div>
                <br></br>
                <div>
                    <select name="selectWorkersId" id="workerFilter" onChange={this.selectedWorkerId.bind(this)}>
                    <option defaultValue="">Select Worker</option>
                    {workers}
                    </select>
               </div>
               <br></br>
               <button type="button" value="submit" onClick={this.handleSubmit}>Search</button>
                </form>
                <br></br>
                <br></br>
                <div>
                
                ---{this.getFormattedDate()}---
                </div>
                
            </div>
               
        )
    
   }
}
