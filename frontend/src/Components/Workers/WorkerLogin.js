import React, {useState} from 'react';
import '../../Style.css'
import NavigationBar from '../Layout/NavigationBar';
import axios from "axios";
import {API_URL} from '../../BackendLink';

function WorkerLogin(props){

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
        console.log(userDetails.username+", "+userDetails.password);
        axios.get(API_URL+"/worker/username/"+userDetails.username+
        "/password/"+userDetails.password)
        .then(function(response){
            console.log(response.data);
            sessionStorage.setItem("worker-id", response.data.id);
            sessionStorage.setItem("worker-username", response.data.username);
            sessionStorage.setItem("worker-firstname", response.data.firstName);
            sessionStorage.setItem("worker-lastname", response.data.lastName);
            sessionStorage.setItem("worker-companyId", response.data.companyId);
            sessionStorage.setItem("worker-password", response.data.password);
            sessionStorage.setItem("worker-serviceId", response.data.serviceId);
            sessionStorage.setItem("worker-startTime", response.data.startTime);
            sessionStorage.setItem("worker-finishTime", response.data.finishTime);
            sessionStorage.setItem("worker-lunchTime", response.data.lunchBrTime);
            sessionStorage.setItem("worker-phone", response.data.phone);
            if(sessionStorage.getItem("worker-username")!==null){
                props.history.push("/workerDashboard");
            }
            else{
                setUserDetails(prevValue => {
                    return {
                        ...prevValue,
                        "hasLoginFailed": true
                    }
                });
            }
           
        })
        .catch(function(){
            setUserDetails(prevValue => {
                return {
                    ...prevValue,
                    "hasLoginFailed": true
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
            {userDetails.hasLoginFailed && <h1>Error invalid information provided</h1>}
            <h1>Welcome Employee!</h1>
            <label id = "enjoy">Login to view a wide range of services!</label>
            <br></br>
            <br></br>
            <label id = "emailLabel">Username</label><br></br>
            <input name="username" onChange = {handleChange} type = "text" id = "username" className = "loginInput" placeholder = "Username" required></input>
            <br></br>
            <br></br>
            <label id = "passwordLabel">Password</label><br></br>
            <input name ="password" onChange = {handleChange} type = "password" id = "password" className = "loginInput" placeholder = "Enter Password" required></input>
            <br></br>
            <br></br>
            
        
            <div className = "buttonholder">
           
                <input id = "loginBtn" type="submit" value="Log In"></input>
            </div>
            </form>
        </div>
    );
}

export default WorkerLogin;