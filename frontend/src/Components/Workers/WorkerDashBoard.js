import React from 'react'
import {Link as LinkRouter} from "react-router-dom";
import Table from 'react-bootstrap/Table';
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';

//TODO an admin can also make a booking
export default function AdminDashboard() {
    return (
        <div className = "buttonholder">
            <NavigationBarAdminPage/>
            <br></br>
            <br></br>
            <form className = "workerDetails">
            <h1> Welcome {sessionStorage.getItem("username")}!</h1>
            <br></br>
            <h2>Employee Details</h2>
            <label>Worker ID: {sessionStorage.getItem("id")}</label>
            <br></br>
            <label>Username : {sessionStorage.getItem("username")}</label>
            <br></br>
            <label>First Name : {sessionStorage.getItem("firstname")}</label>
            <br></br>
            <label>Last Name : {sessionStorage.getItem("lastname")}</label>
            <br></br>
            <label>Company ID: {sessionStorage.getItem("companyId")}</label>
            <br></br>
            <br></br>
            <h4>Schedule for the Coming Week</h4>
            <Table striped bordered hover>
            <thead>
                <tr>
                    <th></th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>0800 - 0900</td>
                </tr>
                <tr>
                    <td>0900 - 1000</td>
                </tr>
                <tr>
                    <td>1000 - 1100</td>
                </tr>
                <tr>
                    <td>1100 - 1200</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                </tr>
                <tr>
                    <td>1200 - 1300</td>
                </tr>
                <tr>
                    <td>1300 - 1400</td>
                </tr>
                <tr>
                    <td>1400 - 1500</td>
                </tr>
                <tr>
                    <td>1500 - 1600</td>
                </tr>

            </tbody>
            </Table>
            </form>
        </div>
        
    )
}
