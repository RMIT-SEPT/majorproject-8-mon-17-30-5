import React from 'react';
import './LoginForm.css'
import NavigationBar from './NavigationBar';
import {Link as LinkRouter} from "react-router-dom";

function LoginForm(){
    return(
        <div>
            <NavigationBar/>
            <br></br>
            <br></br>
            <br></br>
            <form className = "entry" id = "loginForm">
            <h1>Welcome!</h1>
            <label id = "enjoy">Login to enjoy a wide range of services!</label>
            <br></br>
            <br></br>
            <label id = "emailLabel">Email/Username</label><br></br>
            <input type = "text" id = "username" className = "loginInput" placeholder = "Email/Username" required></input>
            <br></br>
            <br></br>
            <label id = "passwordLabel">Password</label><br></br>
            <input type = "password" id = "password" className = "loginInput" placeholder = "Enter Password" required></input>
            <br></br>
            <br></br>
            <LinkRouter to = "/login">
            <div className = "buttonholder">
                <input id = "loginBtn" type="submit" value="Log In"></input>
            </div>
            </LinkRouter>
            <p>Don't have an account yet? <a href = "#signUp">Sign Up</a> here!</p>
            </form>
        </div>
    );
}

export default LoginForm;