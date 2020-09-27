  
import React,{useState}  from 'react'
import Table from 'react-bootstrap/Table';
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
import axios from 'axios';

export default function WorkerDashboard() {

    const[userDetails, setUserDetails] = useState({
        day1:[]
    });

    function handleChange(name, value){
        setUserDetails(prevValue => {
            return {
                ...prevValue,
                [name] : value
            }
        });
    }

    function setUp(){
       // console.log("http://localhost:8080/api/worker/workerId/1/date/"+getFormattedDate());
       getWorkingHr(getFormattedDate());
    }

    function getWorkingHr(date){
        axios.get("http://localhost:8080/api/worker/workerId/1/date/"+date)
        .then(function(response){
            console.log("get working hr for today");
            console.log(response.data);
            handleChange("day1", response.data);
        })
        .catch()
        .finally();
    }

    function getFormattedDate(){
        const date = new Date();
        const day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        if(month < 10){
            month++;
            month = "0" + month;
        }
        return year + "-" + month +"-"+day;   
    }

   
    return (
        
        <div className = "buttonholder">
            <NavigationBarWorkerPage/>
            <br></br>
            <button onClick={setUp}>View working time</button>
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
        
    );
}
