import React, { Component} from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import DisplayAService from "../Services/DisplayAService";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage'
import {Link as LinkRouter} from "react-router-dom";

//TODO display all available services
//TODO able to make booking
//TODO display history bookings

export default class CustomerDashboard extends Component {
    constructor(){
        super();
        this.state={
            serviceExist: false,
            res: []
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
    }
    
    render() {
        const list = this.state.res.map((s)=> <DisplayAService key={s.id} service={s}/>);
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
                <div>{list}                
                </div>
                
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
            </div>
        )
    
   }
}
