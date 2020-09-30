import React, { Component } from "react";
import axios from "axios";
import history from '../../history';
import "bootstrap/dist/css/bootstrap.min.css";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';

export default class ViewWorker extends Component {

    
    constructor(props) {
        super(props);
        
        this.state = {
            value: '',
            firstName: props.workerInfo ? props.workerInfo.firstName : 'enter name',
            lastName: props.workerInfo ? props.workerInfo.lastName : 'enter name',
            occupation: props.workerInfo ? props.workerInfo.occupation : 'enter occupation',
            email: props.workerInfo ? props.workerInfo.email : 'enter email',
            username: props.workerInfo ? props.workerInfo.username : 'enter username',
            password: props.workerInfo ? props.workerInfo.password : 'enter password',
            workinghours: props.workerInfo ? props.workerInfo.workinghours : 'enter working hours',
            workingdates: props.workerInfo ? props.workerInfo.workingdates : 'enter working dates',
            companyId: 1,
            hidden: true
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
        let { firstName, lastName, username, password} = this.state
        let workerInfo = { firstName, lastName, username, password};
       console.log(workerInfo);
        this.createPerson(workerInfo);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    createPerson(person){
        
        try {
            console.log("creating a worker");
            axios.post("http://localhost:8080/api/worker/create", person)
            .then(()=>{
                history.push("/admin/workers");
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
            <NavigationBarAdminPage/>
            <br></br>
            <br></br>
                <form class = "workerForm" onSubmit={this.handleSubmit}>
                    <h1>Worker Details</h1>
                    <label>
                        First Name:
                    <input readOnly placeholder={this.state.firstName} name="firstName" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Last Name:
                    <input readOnly placeholder={this.state.lastName} name="lastName" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Occupation:
                    <input readOnly placeholder={this.state.occupation} name="occupation" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Email:
                    <input readOnly placeholder={this.state.email} name="email" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Username:
                    <input readOnly placeholder={this.state.username} name="username" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Password:
                    <input readOnly type={this.state.hidden ? "password" : "text"} value={this.state.password} placeholder={this.state.value} name="password" onChange={this.handleChange} />
                    <button onClick={this.toggleShow}>Show / Hide</button>
                            </label>
                            <br></br>
                            <label>
                                Working Hours:
                    <input readOnly placeholder={this.state.workinghours} name="workinghours" onChange={this.handleChange} />
                            </label>
                            <br></br>
                            <label>
                                Working Dates:
                    <input readOnly placeholder={this.state.workingdates} name="workingdates" onChange={this.handleChange} />
                            </label>
                </form>
                <br></br>
                <br></br>
            </div>
        );
    }
}
