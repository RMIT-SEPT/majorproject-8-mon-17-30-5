import React, {useState} from 'react';
//import './LoginForm.css'
import NavigationBar from '../Layout/NavigationBar';
import {Link as LinkRouter, useHistory} from "react-router-dom";
import axios from "axios";

function RegisterForm(props){
    const history = useHistory();
    const[userDetails, setUserDetails] = useState({
        username: "",
        firstName:"",
        lastName: "",
        password: "",
        billingAdd:"",
        shipppingAdd:""
    });

    function handleChange(event){
        const{name, value} = event.target;
        setUserDetails(prevValue =>{
          return {
            ...prevValue,
            [name] : value
          }
        })
    }

    async function createCustomer(user){
        try {
            console.log("creating customer");
        const res = await axios.post("http://localhost:8080/api/customer/create", user);
        props.history.push("/");
         } catch (err) {
        console.log(err);
       }
    }

    function handleSubmit(event) {
        console.log("handleSubmit");
        event.preventDefault();
        const person = {
          username: userDetails.username,
          firstName: userDetails.firstName,
          lastName:userDetails.lastName,
          password:userDetails.password,
          billingAdd: userDetails.billingAdd,
          shipppingAdd: userDetails.shipppingAdd
        }
        createCustomer(person);
        console.log(person);
    }
    
    return(
        <div>
            <NavigationBar/>
            <br></br>
            <br></br>
            <br></br>
            <form className = "entryRegister" id = "registerForm" onSubmit={handleSubmit}>
            <h1 className = "regoHead">Join Us!</h1>
            <label className = "regoLabel">Join us today to have a wide range of services, right at your fingertips!</label>
            <br></br>
            <br></br>
            <label className = "regoLabel">First Name</label><br></br>
            <input type = "text" id = "firstname" name="firstName" onChange={handleChange}  className = "loginInput" placeholder = "Enter First Name" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Last Name</label><br></br>
            <input type = "text" id = "lastname" onChange={handleChange} name="lastName" className = "loginInput" placeholder = "Enter Last Name" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Username</label><br></br>
            <input type = "text" id = "username" onChange={handleChange} name="username" className = "loginInput" placeholder = "Enter Username" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Password</label><br></br>
            <input type = "password" id = "password" onChange={handleChange} name="password" className = "loginInput" placeholder = "Enter Password" required></input>
            <br></br>
            <br></br>
           
            <div className = "buttonholder">
          
                <button id = "registerBtn" type="submit" value="Sign Up">Sign up</button>
            </div>
            <br>
            </br>
            
            <label className = "regoLabel">Already have an account? <LinkRouter to = "/loginform">Log In </LinkRouter> here!</label>
            <br></br>
            <br></br>
            </form>
            <br></br>
            <br></br>
            <br></br>
        </div>
    );
}

export default RegisterForm;