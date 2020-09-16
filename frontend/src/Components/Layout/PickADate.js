import React, {useState} from 'react';
//import SimplePicker from 'simplepicker';
//import 'dist/simplepicker.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import Timekeeper from 'react-timekeeper';
import "bootstrap/dist/css/bootstrap.min.css";

function PickADate(){
  const [selectedDate, setSelectedDate] = useState(null);
  const [time, setTime] = useState('12:34pm')
  const date = new Date();
  const dateMax = new Date(Date.now() + 7 * 24 * 60 * 60 * 1000);
  //let time ="15:30";
  function confirmBooking(){

  }
  return(
    <div>
      <div id="datePicker">
          <DatePicker
          selected={selectedDate}
          onChange={date => setSelectedDate(date)}
          dateFormat = 'dd/MM/yyyy'
          filterDate={date => date.getDay() != 6 && date.getDay() !=0}
          isClearable
          minDate = {date}
          maxDate = {dateMax}
          placeholderText = "selectedDate"
          className="btn btn-outline-dark"
          />
      </div>
      <br></br>
      <div>
      <Timekeeper id="timer"
          time={time}
          onChange={(data) => setTime(data.formatted12)}
          hour24Mode
          coarseMinutes={15}  
          />
          <br></br>
          <span>Time is {time}</span>
      </div>   
      <button>Cancle</button> <button onClick={confirmBooking}>Confirm</button>
      <br></br>
      <div id="confirmBooking">
        <p>Are you sure you want to book this service?</p>
        <div>
        <button className="btn btn-success">Yes</button>
        </div>
        <br></br>
        <div>
        <button className="btn btn-info">No</button>
        </div>
      </div>
      <br></br>
    </div>
  )
}
export default PickADate;