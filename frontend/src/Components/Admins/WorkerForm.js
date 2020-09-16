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
            occupation: props.workerInfo ? props.workerInfo.occupation : 'enter occupation',
            email: props.workerInfo ? props.workerInfo.email : 'enter email',
            username: props.workerInfo ? props.workerInfo.username : 'enter username',
            password: props.workerInfo ? props.workerInfo.password : 'enter password',
            workinghours: props.workerInfo ? props.workerInfo.workinghours : 'enter working hours',
            workingdates: props.workerInfo ? props.workerInfo.workingdates : 'enter working dates'
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(event) {
        // TODO: extract information from form
        
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
            //let history = useHistory();
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
               {/* <LinkRouter to="/admin/workers">
                <a> X </a>
                </LinkRouter>
        */}
               
                <form onSubmit={this.handleSubmit}>
                    <h3>Worker Details</h3>
                    <label>
                        First Name:
                    <input type="text" placeholder={this.state.firstName} name="firstName" onChange={this.handleChange} />
                            </label>
                            <label>
                                Last Name:
                    <input type="text" placeholder={this.state.lastName} name="lastName" onChange={this.handleChange} />
                            </label>
                            <label>
                                Occupation:
                    <input type="text" placeholder={this.state.occupation} name="occupation" onChange={this.handleChange} />
                            </label>
                            
                            <label>
                                Email:
                    <input type="text" placeholder={this.state.email} name="email" onChange={this.handleChange} />
                            </label>
                            <label>
                                Username:
                    <input type="text" placeholder={this.state.username} name="username" onChange={this.handleChange} />
                            </label>
                            <label>
                                Password:
                    <input type="text" placeholder={this.state.password} name="password" onChange={this.handleChange} />
                            </label>
                            <label>
                                Working Hours:
                    <input type="text" placeholder={this.state.workinghours} name="workinghours" onChange={this.handleChange} />
                            </label>
                            <label>
                                Working Dates:
                    <input type="text" placeholder={this.state.workingdates} name="workingdates" onChange={this.handleChange} />
                            </label>
                            <br />
                            <input type="submit" value="Submit" />
                </form>
                <button type="button" className="btn btn-secondary" onClick={this.backToWorkerPage}>Cancle / Close</button>
            </div>
        );
    }
}
