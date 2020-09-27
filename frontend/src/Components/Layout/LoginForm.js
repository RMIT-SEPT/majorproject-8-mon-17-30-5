import React, {useState} from 'react';
import '../../Style.css'
import NavigationBar from './NavigationBar';
import {Link as LinkRouter} from "react-router-dom";
import axios from "axios";

function LoginForm(props){

    const[userDetails, setUserDetails] = useState({
        username: "",
        password: "",
        hasLoginFailed: false
    });

    function handleChange(event){
       const {name, value} = event.target;

        setUserDetails(prevValue => {
            return {
                ...prevValue,
                [name] : value
            }
        });
    }

    function handleSubmit(event){
        axios.get("http://localhost:8080/api/customer/username/"+userDetails.username+
        "/password/"+userDetails.password)
        .then(function(response){
            console.log(response.data);
            sessionStorage.setItem("id", response.data.id);
            sessionStorage.setItem("username", response.data.username);
            sessionStorage.setItem("firstname", response.data.firstName);
            sessionStorage.setItem("lastname", response.data.lastName);
            sessionStorage.setItem("billingAddress", response.data.billingAddress);
            sessionStorage.setItem("shippingAddress", response.data.shippingAddress);
            props.history.push("/customerDashboard/");
        })
        .catch(function(){
            setUserDetails(prevValue => {
                return {
                    ...prevValue,
                    "hasLoginFailed" : true
                }
            });
        })
        .finally();

        

        event.preventDefault();
    }
    return(
        <div>
            <NavigationBar/>
            <br></br>
            <br></br>
            <br></br>
            <form className = "entry" id = "loginForm" onSubmit={handleSubmit}>
            {userDetails.hasLoginFailed && <h1>Error</h1>}
            <h1>Welcome!</h1>
            <label id = "enjoy">Login to enjoy a wide range of services!</label>
            <br></br>
            <br></br>
            <label id = "emailLabel">Email/Username</label><br></br>
            <input name="username" onChange = {handleChange} type = "text" id = "username" className = "loginInput" placeholder = "Email/Username" required></input>
            <br></br>
            <br></br>
            <label id = "passwordLabel">Password</label><br></br>
            <input name ="password" onChange = {handleChange} type = "password" id = "password" className = "loginInput" placeholder = "Enter Password" required></input>
            <br></br>
            <br></br>
            
        
            <div className = "buttonholder">
           
                <input id = "loginBtn" type="submit" value="Log In"></input>
            </div>
           
            <p>Don't have an account yet? <LinkRouter to = "/signupform">Sign Up</LinkRouter> here!</p>
            <p>Or</p>
            <p>Log in as  <LinkRouter to = "/admin/login">Admin</LinkRouter> or <LinkRouter to="/worker/login">Employee</LinkRouter></p>
            </form>
        </div>
    );
}

export default LoginForm;