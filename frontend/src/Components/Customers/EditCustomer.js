import React from 'react';
import '../../App.css'
//import {Link as LinkRouter} from "react-router-dom";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';

function EditCustomer()
{
    return(
        <div>
            <NavigationBarCustomerPage/>
            <br></br>
            <br></br>
            <form className = "editCustomer">
                <h1>Edit Customer</h1>
                <label>Change First Name</label>
                <input type ="text" id = "changeFName"></input>
                <br></br>
                <label>Change Last Name</label> 
                <input type = "text" id = "changeLName"></input>
                <br></br>
                <label>Change Username</label>
                <input type = "text" id = "changeUName"></input>
                <br></br>
                <label>Change Billing Address</label>
                <input type = "text" id = "changeBAddress"></input>
                <br></br>
                <label>Change Shipping Address</label>
                <input type = "text" id = "changeSAddress"></input>
                <br></br>
                <input type = "submit" className = "changeCustDetails" id = "changeCustDetails" value = "Change My Details"></input>
                <br></br>
            </form>
            <br></br>
            <br></br>
        </div>
    );
}

export default EditCustomer;