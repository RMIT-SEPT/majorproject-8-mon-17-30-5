import React, { Component} from 'react'
// import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';
import {Link as LinkRouter} from "react-router-dom";
import WorkerOption from '../Layout/WorkerOption';
import DisplayServiceOption from '../Layout/DisplayServiceOption';
import DisplayACompanyOption from '../Layout/DisplayACompanyOption';
<<<<<<< HEAD
import {API_URL} from '../../BackendLink';
=======
>>>>>>> m3-local

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
            businesses:[],
            selectCompanyId: 0
        }
        this.handleSubmit = this.handleSubmit.bind(this);
        this.getSearchOptionsSetUp = this.getSearchOptionsSetUp.bind(this);
    }
    componentDidMount(){

<<<<<<< HEAD
        axios.get(API_URL+"/company/All")
=======
        axios.get("http://localhost:8080/api/company/All")
>>>>>>> m3-local
        .then((response)=>{
            this.setState({"businesses": response.data});
        })
        .catch()
        .finally();
    }

    getSearchOptionsSetUp(event){
        event.preventDefault();
        if(this.state.selectCompanyId >= 1){
<<<<<<< HEAD
            axios.get(API_URL+"/serviceObject/getAll/"+this.state.selectCompanyId)
=======
            axios.get("http://localhost:8080/api/serviceObject/getAll/"+this.state.selectCompanyId)
>>>>>>> m3-local
            .then((response)=>{
                this.setState({"serviceExist": true});
                this.setState({"res": response.data});
                console.log(this.state.res);
            })
            .catch()
            .finally();

<<<<<<< HEAD
            axios.get(API_URL+"/worker/companyId/"+this.state.selectCompanyId)
=======
            axios.get("http://localhost:8080/api/worker/companyId/"+this.state.selectCompanyId)
>>>>>>> m3-local
            .then((response)=>{
                this.setState({"workers":response.data});
                console.log("Workers");
                console.log(this.state.workers);
            })
            .catch()
            .finally();
            sessionStorage.setItem("companyIsSelected", true);
        }else{
            sessionStorage.setItem("companyIsSelected", false);
            this.setState({"selectCompanyId":0});
            window.location.reload();
        }
        
    }

    handleSubmit = (event) => {
        if(this.state.selectServiceId > 0 && this.state.selectWorkerId >0){
        let duration1 = 0;
        let description1 ="";

        axios.get(API_URL+"/serviceObject/"+this.state.selectServiceId)
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
         console.log("serviceId: " + this.state.selectServiceId);
         console.log(e.target.value);
     }

    selectedWorkerId(e){
        this.setState({selectWorkerId: e.target.value});
        console.log("workerId: " + this.state.selectWorkerId);
        console.log(e.target.value);
    }

    selectedDate(e){
        this.setState({selectDate: e.target.value});
    }

    selectCompanyId(e){
        this.setState({"selectCompanyId": e.target.value});
       
        console.log(e.target.value);
        if(e.target.value === 0){
            sessionStorage.setItem("companyIsSelected", false);
        }else{
            sessionStorage.setItem("companyIsSelected", true);
        }
    }

    getAvailable(){
        axios.get(API_URL+"/worker/" + this.state.selectWorkerId+"/"+this.state.selectServiceId
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
        const businesses = this.state.businesses.map((b)=> <DisplayACompanyOption key={b.id} company={b}/>)
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
            <br></br>
            <div>
                    <h1>Customer Dashboard</h1>
            </div>
            <br></br>
            <form className="searchDash" onSubmit={this.getSearchOptionsSetUp.bind(this)}>
            <br></br>
            <br></br>
            <div>
                <select name="selectBusinessId" id="businessFilter" class = "businessFilter" onChange={this.selectCompanyId.bind(this)} required>
                    <option defaultValue="0" value={0}>Select Business</option>
                    {businesses}
                </select>
            </div>
            <br></br>
            <br></br>
            <div>
            <button className = "searchService" type="submit" value="submit">Confirm</button>
            </div>
            <br></br>
            <br></br>
            </form>
            <form className = "searchDash">
            <div id="datePicker">
                <input type="date" className = "datePicker" id="dateFilter" name="selectDate" placeholder = "Select Date"  min={this.getFormattedDate()}  onChange={this.selectedDate.bind(this)} required></input>
            </div>
            <br></br>
            <br></br>
            <div>
                <select name="selectServiceId" id="serviceFilter" onChange={this.selectedServiceId.bind(this)} required>
                    <option defaultValue="">Select Service</option>
                    {serviceOption}
                </select> 
            </div> 
            <br></br>
            <br></br>
            <div>
                <select name="selectWorkersId" id="workerFilter" onChange={this.selectedWorkerId.bind(this)} required>
                    <option defaultValue="">Select Worker</option>
                    {workers}
                </select>
            </div>
            <br></br>
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
