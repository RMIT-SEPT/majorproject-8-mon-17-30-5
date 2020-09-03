import React, { Component} from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Layout/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'
import {Link as LinkRouter} from "react-router-dom";
//import Dropdown from 'react-dropdown';

//TODO display all available services -- done -- teach how to recall
//TODO able to make booking
//TODO display history bookings -- from button click -- done

export default class CustomerDashboard extends Component {
    constructor(){
        super();
        this.state={
            serviceExist: false,
            res: [], 
            workers: []
        }
    }
    componentDidMount(){
        axios.get("http://localhost:8080/api/serviceObject/getAll")
        .then((response)=>{
            this.setState({["serviceExist"]: true});
            console.log(response.data);
            this.setState({["res"]: response.data});
            console.log(this.state.res);
        })
        .catch()
        .finally();

        //this will get all the workers
        axios.get("http://localhost:8080/api/worker/")
        .then((response)=>{
            this.setState({["workers"]:response.data});
            console.log("Workers");
            console.log(this.state.workers);
        })
        .catch()
        .finally();

    }

    //TODO test if mapping workers work!!
    render() {
        const list = this.state.res.map((s)=> <DisplayAService key={s.id} service={s}/>);
        const workers = this.state.workers.map((w)=> <option key={w.id} defaultValue={w.username}>{w.firstname}</option>);
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
                {/*
                    <div className="dropdown" >
                            <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </button>
                        <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <button className="dropdown-item" type="button">Action</button>
                            <button className="dropdown-item" type="button">Another action</button>
                            <button className="dropdown-item" type="button">Something else here</button>
                        </div>
                    </div>
                */}
                
               <div>
                <select name="workers" id="workerFilter">
                {workers}
                </select>
               </div>
                <div className="container">
                <div className="row">
                </div>
                {list}                
                </div>
                 {/*
                <div className="container">
                    <div className="row">
                        <div className="col-sm-3">
                            <button type="button" className="btn btn-success btn-block">
                                <h4>Service 1</h4>
                                <li>Company:</li><br></br>
                                <li>ServiceType</li><br></br>
                                <li>Worker</li><br></br>
                                <li>Duration</li>
                            </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 2</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 3</h4>
                        <li>Company: </li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 4</h4>
                        <li>Company:kekfjsh</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                    </div>
                </div>
                <p></p>
                <div className="container">
                    <div className="row">
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 5</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 6</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 7</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 8</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    </div>
                </div>
                 */}
            </div>
               
        )
    
   }
}
