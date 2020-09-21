import React, {useState} from 'react';
import '../../Style.css'
import NavigationBar from '../Layout/NavigationBar';
import axios from "axios";

function AdminLogin(props){

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
        axios.get("http://localhost:8080/api/admin/username/"+userDetails.username+
        "/password/"+userDetails.password)
        .then(function(response){
            console.log(response.data);
            sessionStorage.setItem("id", response.data.id);
            sessionStorage.setItem("username", response.data.username);
            sessionStorage.setItem("firstname", response.data.firstName);
            sessionStorage.setItem("lastname", response.data.lastName);
            sessionStorage.setItem("companyId", response.data.companyId);
            sessionStorage.setItem("password", response.data.password);
            props.history.push("/admin");
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
   // console.log(sessionStorage.getItem("username"));
    return(
        <div>
            <NavigationBar/>
            <br></br>
            <br></br>
            <br></br>
            <form className = "entry" id = "loginForm" onSubmit={handleSubmit}>
            {userDetails.hasLoginFailed && <h1>Error invalid information provided</h1>}
            <h1>Welcome Admin!</h1>
            <label id = "enjoy">Login to manage a wide range of services!</label>
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
            </form>
        </div>
    );
}

export default AdminLogin;