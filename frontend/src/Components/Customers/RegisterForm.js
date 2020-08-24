import React from 'react';
import './LoginForm.css'
import NavigationBar from './NavigationBar';
import {Link as LinkRouter} from "react-router-dom";

function RegisterForm(){
    return(
        <div>
            <NavigationBar/>
            <br></br>
            <br></br>
            <br></br>
            <form className = "entryRegister" id = "registerForm">
            <h1 className = "regoHead">Join Us!</h1>
            <label className = "regoLabel">Join us today to have a wide range of services, right at your fingertips!</label>
            <br></br>
            <br></br>
            <label className = "regoLabel">First Name</label><br></br>
            <input type = "text" id = "firstname" className = "loginInput" placeholder = "Enter First Name" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Last Name</label><br></br>
            <input type = "text" id = "lastname" className = "loginInput" placeholder = "Enter Last Name" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Username</label><br></br>
            <input type = "text" id = "username" className = "loginInput" placeholder = "Enter Username" required></input>
            <br></br>
            <br></br>
            <label className = "regoLabel">Password</label><br></br>
            <input type = "password" id = "password" className = "loginInput" placeholder = "Enter Password" required></input>
            <br></br>
            <br></br>
            <LinkRouter to = "/signup">
            <div className = "buttonholder">
                <input id = "registerBtn" type="submit" value="Sign Up"></input>
            </div>
            <br>
            </br>
            </LinkRouter>
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