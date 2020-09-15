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
            <div>
                <li>{sessionStorage.getItem("username")}</li>
            </div>
        </div>
        
    )
}
