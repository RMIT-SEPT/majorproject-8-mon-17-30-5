import React, { Component } from "react";
import axios from "axios";
import history from '../../history';
import "bootstrap/dist/css/bootstrap.min.css";


export default class WorkerForm extends Component {

    
    constructor(props) {
        super(props);
        
        this.state = {
            value: '',
            firstName: props.workerInfo ? props.workerInfo.firstName : 'enter name',
            lastName: props.workerInfo ? props.workerInfo.lastName : 'enter name',
            username: props.workerInfo ? props.workerInfo.username : 'enter username',
            password: props.workerInfo ? props.workerInfo.password : 'enter password',
            startTime: props.workerInfo ? props.workerInfo.startTime : 'enter start Time',
            finishTime: props.workerInfo ? props.workerInfo.finishTime : 'enter finish Time',
            lunchBrTime: props.workerInfo ? props.workerInfo.lunchBrTime : 'enter lunch break Time',
            companyId: sessionStorage.getItem("companyId")
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        let { firstName, lastName, username, password, startTime, finishTime, lunchBrTime, companyId} = this.state
        let workerInfo = { firstName, lastName, username, password, startTime, finishTime, lunchBrTime, companyId};
       console.log(workerInfo);
        this.createPerson(workerInfo);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });

        if(event.target.name==="startTime"){
            if(event.target.value==="08:00" || event.target.value==="09:00"){
                document.getElementById("startTime").style.color = "black";
            }else{
                document.getElementById("startTime").style.color = "red";
            }
            
        }
    }

    createPerson(person){
        
        try {
            console.log("creating a worker");
            axios.post("http://localhost:8080/api/worker/create", person)
            .then(()=>{
              //  history.push("/admin/workers");
                window.location.reload();
            })
            .finally();
            
          } catch (err) {
           console.log(err);
          }
    }

    backToWorkerPage(){
        history.push("/admin/workers");
        window.location.reload();
    }


    render() {

        return (
            <div>
                <form className = "workerForm" onSubmit={this.handleSubmit}>
                    <h1>Worker Details</h1>
                    <label>
                        First Name:
                    <input type="text" placeholder={this.state.firstName} name="firstName" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Last Name:
                    <input type="text" placeholder={this.state.lastName} name="lastName" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Username:
                    <input type="text" placeholder={this.state.username} name="username" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Password:
                    <input type="password" placeholder={this.state.password} name="password" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Start time:
                    <input type="text" id="startTime" placeholder={this.state.startTime} name="startTime" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Finish time:
                    <input type="text" placeholder={this.state.finishTime} name="finishTime" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Lunch break time:
                    <input type="text" placeholder={this.state.lunchBrTime} name="lunchBrTime" onChange={this.handleChange} />
                            </label>
                            <br />
                            <input className = "workerButton" type="submit" value="Submit"/>
                </form>
                <br></br>
                <br></br>
                <button onClick={this.backToWorkerPage} className = "btn btn-danger" >Cancel</button>
                <br></br>
            </div>
        );
    }
}
