import React from 'react'
import {Link as LinkRouter} from "react-router-dom";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';

export default function AdminDashboard() {

    return (
        <div className = "buttonholder">
            <NavigationBarAdminPage/>
            <br></br>
            <br></br>
            <article className = "adminDash">
            <LinkRouter to="/admin/workers">
                <input className = "workers" type="submit" value="Worker"></input>
            </LinkRouter>
            <LinkRouter to="/admin/bookings">
                <input className = "bookings" type="submit" value="Booking"></input>
            </LinkRouter>
            </article>
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
            <label>Phone number : {sessionStorage.getItem("phone")}</label>
            <br></br>
            <label>Company ID: {sessionStorage.getItem("companyId")}</label>
            <br></br>
            </form>
            <br></br>
            <br></br>
        </div>
        
    )
}
