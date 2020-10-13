import React from 'react'
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
import WorkerInfoBoard from './WorkerInfoBoard';

export default function WorkerDashboard() {

   
    return (
        
        <div className = "buttonholder">
            <NavigationBarWorkerPage/>
            <br></br>
            <br></br>
            <WorkerInfoBoard></WorkerInfoBoard>
            <br></br>
            <br></br>
            <label>First Name : {sessionStorage.getItem("firstname")}</label>
            <br></br>
            <label>Last Name : {sessionStorage.getItem("lastname")}</label>
            <br></br>
            <label>Company ID: {sessionStorage.getItem("companyId")}</label>
            <br></br>
            <button type="button" onClick={setUp}>View working time</button>
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
