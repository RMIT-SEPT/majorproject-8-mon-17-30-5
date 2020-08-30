import React, { Component, useState} from "react";
import Dropdown from 'react-dropdown';
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";
//import createPerson from "../Actions/createPersonTesting"

function AddWorker() {
 
  const history = useHistory();
  const[userDetails, setUserDetails] = useState({
    username: "",
    firstname:"",
    lastname: "",
    password: "",
    starttime:"",
    finishtime:"",
    hasLoginFailed: false
  });
     //export default class AddWorker extends Component {
  function handleClick() {
    this.props.toggle();
  };

  function handleChange(event){
    const{name, value} = event.target;
    setUserDetails(prevValue =>{
      return {
        ...prevValue,
        [name] : value
      }
    })
  }

  async function createPer(type, person){
    try {
        if(type==="customer"){
          const res = await axios.post("http://localhost:8080/api/customer", person);
         // history.push("/");
        }else if(type==="worker"){
          console.log("creating a worker");
          const res = await axios.post("http://localhost:8080/api/worker/create", person);
          history.push("/");
          //<Redirect push to="/about-us"/>
          //.then(function(){
           // this.props.router.push("/about-us");
          //});
         // history.push("/about-us")
        }else if(type==="admin"){
          const res = await axios.post("http://localhost:8080/api/admin", person);
        }
      } catch (err) {
       console.log(err);
      }
    
  }

  function handleSubmit(event) {
    console.log("handleSubmit");
    event.preventDefault();
    const person = {
      username: userDetails.username,
      firstName: userDetails.finishtime,
      lastName:userDetails.lastname,
      password:userDetails.password,
      startTime:userDetails.starttime,
      finishTime:userDetails.finishtime
    }
    console.log(person);
   // console.log(this.props.history);
   createPer("worker", person);
  }

  //render() {
    return (
      <div>
        <span className="close" onClick={handleClick}> X </span>
        <form onSubmit={handleSubmit}>
          <h3>Worker Details</h3>
          <label>
            First Name:
            <input type="text" name="firstname" onChange={handleChange}/>
          </label>
          <label>
            Last Name:
            <input type="text" name="lastname" onChange={handleChange}/>
          </label>
          <label>
            Username:
            <input type="text" name="username" onChange={handleChange}/>
          </label>
          <label>
            Password:
            <input type="text" name="password" onChange={handleChange}/>
          </label>
          <label>
            Working start Hours:
            <input type="text" name="starttime" onChange={handleChange}/>
          </label>
          <label>
            Working finish Hours:
            <input type="text" name="finishtime" onChange={handleChange}/>
          </label>
          <label>
            Working Dates:
            <input type="text"/>
          </label>
          <br />
          <button type="submit" value= "Add worker"/>
        </form>
      </div>
    );
  //}
}

export default AddWorker;