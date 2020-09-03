import React from 'react'
import {BrowserRouter as Router, Route, Link as LinkRouter, Switch} from "react-router-dom";
//TODO an admin can also make a booking
export default function AdminDashboard() {
    return (
        <div className = "buttonholder">
            <LinkRouter to="/admin/workers">
                <input id = "workderBtn" type="submit" value="Worker"></input>
            </LinkRouter>
            <LinkRouter to="/booking">
                <input id = "bookingBtn" type="submit" value="Booking"></input>
            </LinkRouter>
        </div>
        
    )
}
