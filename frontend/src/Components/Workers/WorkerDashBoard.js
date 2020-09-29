  
import React,{useState}  from 'react'
import Table from 'react-bootstrap/Table';
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
import axios from 'axios';

export default function WorkerDashboard() {

    const[userDetails, setUserDetails] = useState({
        day1:[],
        day2:[],
        day3:[],
        day4:[],
        day5:[],
        day6:[],
        day7:[],
        seeShift: false
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
       getAll7DaysShift();
       handleChange("seeShift", true);
    }

    function getAll7DaysShift(){
        getWorkingHr(getFormattedDate(0), "day1");
        getWorkingHr(getFormattedDate(1), "day2");
        getWorkingHr(getFormattedDate(2), "day3");
        getWorkingHr(getFormattedDate(3), "day4");
        getWorkingHr(getFormattedDate(4), "day5");
        getWorkingHr(getFormattedDate(5), "day6");
        getWorkingHr(getFormattedDate(6), "day7");
    }

    async function getWorkingHr(date, name){
        //TODO add aws url
        axios.get("http://localhost:8080/api/worker/workerId/"+sessionStorage.getItem("id")+"/date/"+date)
        .then(function(response){
            // console.log("get working hr for " + name);
            // console.log(response.data);
            handleChange(name, response.data);
        })
        .catch()
        .finally();
    }

    function getFormattedDate(num){
        const today = new Date();
        var date = new Date(today.getTime() + num * 24 * 60 * 60 * 1000);
        const day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month < 10){
            month = "0" + month;
        }
        return year + "-" + month +"-"+day; 
    }

   
    return (
        
        <div className = "buttonholder">
            <NavigationBarWorkerPage/>
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
            <button className = "workerBtn" type="button" onClick={setUp}>View working time</button>
            <br></br>
            <br></br>
            {userDetails.seeShift && <h4>Schedule for the Coming Week</h4> &&
            <Table striped bordered hover>
            <thead>
                <tr>
                    <th></th>
                    <th>{getFormattedDate(0)}</th>
                    <th>{getFormattedDate(1)}</th>
                    <th>{getFormattedDate(2)}</th>
                    <th>{getFormattedDate(3)}</th>
                    <th>{getFormattedDate(4)}</th>
                    <th>{getFormattedDate(5)}</th>
                    <th>{getFormattedDate(6)}</th>
                </tr>
            </thead>
            <tbody>
                {sessionStorage.getItem("startTime") === "08:00" &&
                <tr>
                    <td>08:00 - 09:00</td>
                    <td>{userDetails.day1[800]}</td>
                    <td>{userDetails.day2[800]}</td>
                    <td>{userDetails.day3[800]}</td>
                    <td>{userDetails.day4[800]}</td>
                    <td>{userDetails.day5[800]}</td>
                    <td>{userDetails.day6[800]}</td>
                    <td>{userDetails.day7[800]}</td>
                </tr>}
                <tr>
                    <td>09:00 - 10:00</td>
                    <td>{userDetails.day1[900]}</td>
                    <td>{userDetails.day2[900]}</td>
                    <td>{userDetails.day3[900]}</td>
                    <td>{userDetails.day4[900]}</td>
                    <td>{userDetails.day5[900]}</td>
                    <td>{userDetails.day6[900]}</td>
                    <td>{userDetails.day7[900]}</td>
                </tr>
                <tr>
                    <td>10:00 - 11:00</td>
                    <td>{userDetails.day1[1000]}</td>
                    <td>{userDetails.day2[1000]}</td>
                    <td>{userDetails.day3[1000]}</td>
                    <td>{userDetails.day4[1000]}</td>
                    <td>{userDetails.day5[1000]}</td>
                    <td>{userDetails.day6[1000]}</td>
                    <td>{userDetails.day7[1000]}</td>
                </tr>
                {sessionStorage.getItem("lunchTime") ==="11:00" &&
                <tr>
                    <td>11:00 - 12:00</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                </tr>}
                {sessionStorage.getItem("lunchTime") ==="11:00" && 
                <tr>
                    <td>12:00 - 13:00</td>
                    <td>{userDetails.day1[1200]}</td>
                    <td>{userDetails.day2[1200]}</td>
                    <td>{userDetails.day3[1200]}</td>
                    <td>{userDetails.day4[1200]}</td>
                    <td>{userDetails.day5[1200]}</td>
                    <td>{userDetails.day6[1200]}</td>
                    <td>{userDetails.day7[1200]}</td>
                </tr>}
                {sessionStorage.getItem("lunchTime") ==="12:00" &&
                <tr>
                    <td>11:00 - 12:00</td>
                    <td>{userDetails.day1[1100]}</td>
                    <td>{userDetails.day2[1100]}</td>
                    <td>{userDetails.day3[1100]}</td>
                    <td>{userDetails.day4[1100]}</td>
                    <td>{userDetails.day5[1100]}</td>
                    <td>{userDetails.day6[1100]}</td>
                    <td>{userDetails.day7[1100]}</td>
                </tr>}
                {sessionStorage.getItem("lunchTime") ==="12:00" && 
                <tr>
                    <td>12:00 - 13:00</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                    <td>LUNCH BREAK</td>
                </tr>}

                <tr>
                    <td>13:00 - 14:00</td>
                    <td>{userDetails.day1[1300]}</td>
                    <td>{userDetails.day2[1300]}</td>
                    <td>{userDetails.day3[1300]}</td>
                    <td>{userDetails.day4[1300]}</td>
                    <td>{userDetails.day5[1300]}</td>
                    <td>{userDetails.day6[1300]}</td>
                    <td>{userDetails.day7[1300]}</td>
                </tr>
                <tr>
                    <td>14:00 - 15:00</td>
                    <td>{userDetails.day1[1400]}</td>
                    <td>{userDetails.day2[1400]}</td>
                    <td>{userDetails.day3[1400]}</td>
                    <td>{userDetails.day4[1400]}</td>
                    <td>{userDetails.day5[1400]}</td>
                    <td>{userDetails.day6[1400]}</td>
                    <td>{userDetails.day7[1400]}</td>
                </tr>
                {sessionStorage.getItem("finishTime") === "16:00" &&
                <tr>
                    <td>15:00 - 16:00</td>
                    <td>{userDetails.day1[1500]}</td>
                    <td>{userDetails.day2[1500]}</td>
                    <td>{userDetails.day3[1500]}</td>
                    <td>{userDetails.day4[1500]}</td>
                    <td>{userDetails.day5[1500]}</td>
                    <td>{userDetails.day6[1500]}</td>
                    <td>{userDetails.day7[1500]}</td>
                </tr>
                }
                {sessionStorage.getItem("finishTime") === "17:00" &&
                <tr>
                    <td>16:00 - 17:00</td>
                    <td>{userDetails.day1[1600]}</td>
                    <td>{userDetails.day2[1600]}</td>
                    <td>{userDetails.day3[1600]}</td>
                    <td>{userDetails.day4[1600]}</td>
                    <td>{userDetails.day5[1600]}</td>
                    <td>{userDetails.day6[1600]}</td>
                    <td>{userDetails.day7[1600]}</td>
                </tr>
                }

            </tbody>
            </Table>}
            </form>
        </div>
        
    );
}
