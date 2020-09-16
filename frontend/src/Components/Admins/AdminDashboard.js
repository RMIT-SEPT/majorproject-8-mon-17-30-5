import React from 'react'
import {Link as LinkRouter} from "react-router-dom";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';

//TODO an admin can also make a booking
export default function AdminDashboard() {
    return (
        <div className = "buttonholder">
            <NavigationBarAdminPage/>
            <LinkRouter to="/admin/workers">
                <input id = "workderBtn" type="submit" value="Worker"></input>
            </LinkRouter>
            <LinkRouter to="/booking">
                <input id = "bookingBtn" type="submit" value="Booking"></input>
            </LinkRouter>
            <br></br>
            <br></br>
            <form className = "adminDetails">
            <h1> Welcome {sessionStorage.getItem("username")}!</h1>
            <br></br>
            <h2>Admin Details</h2>
            <label>Username : {sessionStorage.getItem("username")}</label>
            <br></br>
            <label>First Name : {sessionStorage.getItem("firstname")}</label>
            <br></br>
            <label>Last Name : {sessionStorage.getItem("lastname")}</label>
            <br></br>
            <label>Company ID: {sessionStorage.getItem("companyId")}</label>
            <br></br>
            </form>
        </div>
        
    )
}
