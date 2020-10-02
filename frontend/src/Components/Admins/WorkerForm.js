import React, { Component } from "react";
import axios from "axios";
import history from '../../history';
import "bootstrap/dist/css/bootstrap.min.css";
//import { Link as LinkRouter } from "react-router-dom";

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
            phone: props.workerInfo ? props.workerInfo.phone : 'enter phone number',
            companyId: sessionStorage.getItem("companyId"),
            hidden: true,
            errors: {
                startTime: '',
                finishTime: '',
                lunchBrTime: '',
            }
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.toggleShow = this.toggleShow.bind(this);
    }

    toggleShow() {
        this.setState({ hidden: !this.state.hidden });
    }

    handleSubmit(event) {
        event.preventDefault();
        let { firstName, lastName, username, password, startTime, finishTime, lunchBrTime, companyId, phone } = this.state
        let workerInfo = { firstName, lastName, username, password, startTime, finishTime, lunchBrTime, companyId, phone};

        let matches;
        let match1 = startTime === "08:00" || startTime === "09:00";
        let match2 = finishTime === "16:00" || finishTime === "17:00";
        let match3 = lunchBrTime === "11:00" || lunchBrTime === "12:00";
        matches = match1 && match2 && match3;
        matches ? this.createPerson(workerInfo) : alert("Please enter correct time");

    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
        event.preventDefault();
        if (event.target.name === "startTime") {
            if (event.target.value === "08:00" || event.target.value === "09:00") {
                document.getElementById("startTime").style.color = "black";
            } else {
                document.getElementById("startTime").style.color = "red";
            }
        }

        if (event.target.name === "finishTime") {
            if (event.target.value === "16:00" || event.target.value === "17:00") {
                document.getElementById("finishTime").style.color = "black";
            } else {
                document.getElementById("finishTime").style.color = "red";
            }
        }

        if (event.target.name === "lunchBrTime") {
            if (event.target.value === "11:00" || event.target.value === "12:00") {
                document.getElementById("lunchBrTime").style.color = "black";
            } else {
                document.getElementById("lunchBrTime").style.color = "red";
            }
        }

        const { name, value } = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'startTime':
                errors.startTime =
                    value !== '08:00' && value !== '09:00'
                        ? 'Please enter start time either 08:00 or 09:00'
                        : '';
                break;
            case 'finishTime':
                errors.finishTime =
                    value !== '16:00' && value !== '17:00'
                        ? 'Please enter finish time either 16:00 or 17:00'
                        : '';
                break;
            case 'lunchBrTime':
                errors.lunchBrTime =
                    value !== '11:00' && value !== '12:00'
                        ? 'Please enter lunch break time either 11:00 or 12:00'
                        : '';
                break;
            default:
                break;
        }

        this.setState({ errors, [name]: value });
    }

    createPerson(person) {

        try {
            console.log("creating a worker");
            axios.post("http://localhost:8080/api/worker/create", person)
                .then(() => {
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
                            Phone number:
                <input type="text" placeholder={this.state.phone} name="phone" onChange={this.handleChange} />
                        </label>
                        <br></br>
                            <label>
                                Start time:
                    <input type="text" id="startTime" placeholder={this.state.startTime} name="startTime" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Finish time:
                    <input type="text" id="finishTime" placeholder={this.state.finishTime} name="finishTime" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Lunch break time:
                    <input type="text" id="lunchBrTime" placeholder={this.state.lunchBrTime} name="lunchBrTime" onChange={this.handleChange} />
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
