import React, {useState} from 'react';
import '../../App.css'
//import {Link as LinkRouter} from "react-router-dom";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';
import axios from 'axios';

function EditCustomer(props)
{

    const[userDetails, setUserDetails] = useState({
        id: sessionStorage.getItem("id"),
        username: sessionStorage.getItem("username"),
        password: sessionStorage.getItem("password"),
        firstname: sessionStorage.getItem("firstname"),
        lastname: sessionStorage.getItem("lastname"),
        billingAddress: sessionStorage.getItem("billingAddress"),
        shippingAddress: sessionStorage.getItem("shippingAddress"),
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
        const person = {
            id: userDetails.id,
            username: userDetails.username,
            password: userDetails.password,
            firstName: userDetails.firstname,
            lastName: userDetails.lastname,
            billingAddress: userDetails.billingAddress,
            shippingAddress: userDetails.shippingAddress
        }
        setSessionStorage();
        console.log("updating customer");
        console.log(person);
        axios.put("http://localhost:8080/api/customer/"+sessionStorage.getItem("id"), person)
        .then(()=>{
          alert("Successfully edit your information.\nWe are now taking you back to dashboard");
          props.history.push("/customerDashBoard");
        }).catch()
        .finally();
        event.preventDefault();
    }

    function goBack(){
        props.history.push("/customerDashBoard");
    }

    function setSessionStorage(){
        sessionStorage.setItem("id", userDetails.id);
        sessionStorage.setItem("username", userDetails.username);
        sessionStorage.setItem("firstname", userDetails.firstname);
        sessionStorage.setItem("lastname", userDetails.lastname);
        sessionStorage.setItem("billingAddress", userDetails.billingAddress);
        sessionStorage.setItem("shippingAddress", userDetails.shippingAddress);
        sessionStorage.setItem("password", userDetails.password);
    }



    return(
        <div>
            <NavigationBarCustomerPage/>
            <br></br>
            <br></br>
            <form className = "editCustomer" onSubmit={handleSubmit}>
                <h1>Edit Customer</h1>
                <label>Change First Name</label>
                <input type ="text" id = "changeFName" name="firstname" placeholder={sessionStorage.getItem("firstname")} onChange = {handleChange}></input>
                <br></br>
                <label>Change Last Name</label> 
                <input type = "text" id = "changeLName" name="lastname" placeholder={sessionStorage.getItem("lastname")} onChange = {handleChange}></input>
                <br></br>
                <label>Change Username</label>
                <input type = "text" id = "changeUName" name="username"  placeholder={sessionStorage.getItem("username")} onChange = {handleChange}></input>
                <br></br>
                <label>Change Password</label>
                <input type = "text" id = "changePassword" name="password"  placeholder={sessionStorage.getItem("password")} onChange = {handleChange}></input>
                <br></br>
                <label>Change Billing Address</label>
                <input type = "text" id = "changeBAddress" name="billingAddress" placeholder={sessionStorage.getItem("billingAddress")} onChange = {handleChange}></input>
                <br></br>
                <label>Change Shipping Address</label>
                <input type = "text" id = "changeSAddress"  name="shippingAddress" placeholder={sessionStorage.getItem("shippingAddress")} onChange = {handleChange}></input>
                <br></br>
                <input type = "submit" className = "changeCustDetails" id = "changeCustDetails" value = "Change My Details"></input>
                <br></br>
                <input onClick={goBack} className = "changeCustDetails" id = "changeCustDetailsBack" value = "Cancel / Back" readOnly></input>
                <br></br>
            </form>
            <br></br>
            <br></br>
        </div>
    );
}

export default EditCustomer;