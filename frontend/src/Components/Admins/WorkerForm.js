import React, { Component } from "react";
import Dropdown from 'react-dropdown';


const options = ['Female', 'Male'];


export default class WorkerForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            value: '',
            firstname: props.workerInfo ? props.workerInfo.firstname : 'enter name',
            lastname: props.workerInfo ? props.workerInfo.lastname : 'enter name',
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
    handleClick = () => {
        this.props.toggle();
    };

    handleSubmit(event) {
        // TODO: extract information from form
        let { firstname, lastname, occupation, email, username, password, workinghours, workingdates } = this.state
        let workerInfo = { firstname, lastname, occupation, email, username, password, workinghours, workingdates }
        this.props.onSubmit(workerInfo);
        event.preventDefault();
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render() {

        return (
            <div>
                <span className="close" onClick={this.handleClick}> X </span>
                <form onSubmit={this.handleSubmit}>
                    <h3>Worker Details</h3>
                    <label>
                        First Name:
            <input type="text" value={this.state.firstname} name="firstname" onChange={this.handleChange} />
                    </label>
                    <label>
                        Last Name:
            <input type="text" value={this.state.lastname} name="lastname" onChange={this.handleChange} />
                    </label>
                    <label>
                        Occupation:
            <input type="text" value={this.state.occupation} name="occupation" onChange={this.handleChange} />
                    </label>
                    <label>
                        Gender:
            <Dropdown options={options} name="gender" onChange={this.handleChange} placeholder='Select' />;
          </label>
                    <label>
                        Email:
            <input type="text" value={this.state.email} name="email" onChange={this.handleChange} />
                    </label>
                    <label>
                        Username:
            <input type="text" value={this.state.username} name="username" onChange={this.handleChange} />
                    </label>
                    <label>
                        Password:
            <input type="text" value={this.state.password} name="password" onChange={this.handleChange} />
                    </label>
                    <label>
                        Working Hours:
            <input type="text" value={this.state.workinghours} name="workinghours" onChange={this.handleChange} />
                    </label>
                    <label>
                        Working Dates:
            <input type="text" value={this.state.workingdates} name="workingdates" onChange={this.handleChange} />
                    </label>
                    <br />
                    <input type="submit" value="Submit" />
                </form>
            </div >
        );
    }
}
