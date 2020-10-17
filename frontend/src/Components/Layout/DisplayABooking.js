import React, {useState, useEffect} from 'react';
import axios from 'axios';
import Modal from 'react-bootstrap/Modal';
<<<<<<< HEAD
import {API_URL} from '../../BackendLink';
=======
>>>>>>> m3-local

function DisplayABooking(props) {
    
    const[userDetails, setUserDetails] = useState({
        description:"",
        workerName:"",
        startTime:"null",
        finishTime:"null"
    });

    useEffect(() => {
       async function getDescription(){
        axios.get(API_URL+"/serviceObject/"+props.booking.serviceId)
        .then((response)=>{
            console.log(response.data);
            setUserDetails  ((prevValue)=>{
            return {
                ...prevValue,
                description: response.data.description,
                workerName: response.data.workerName
            }
          });       
        })
        .catch()
        .finally();
       };
       getDescription();
    }, [props]);

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    function cancelBooking(){
<<<<<<< HEAD
        axios.delete(API_URL+"/booking/"+ props.booking.id)
=======
        axios.delete("http://localhost:8080/api/booking/"+ props.booking.id)
>>>>>>> m3-local
        .then(()=>{
            window.location.reload();
        })
        .catch()
        .finally();
    }

    function getFormattedDate(num){
        const today = new Date();
        var date = new Date(today.getTime() + num * 24 * 60 * 60 * 1000);
        let day = date.getDate();
        let month = date.getMonth();
        const year = date.getFullYear();
        month++;
        if(month < 10){
            month = "0" + month;
        }

        if(day < 10){
            day = "0" + day;
        }
        return year + "-" + month +"-"+day; 
    }
    function formatDate(dateStr)
    {
        var output;
        if(dateStr.length === 4)
        {
            output = [dateStr.slice(0, 2), ':', dateStr.slice(2)].join('');
            return output;
        }

        if(dateStr.length === 3)
        {
            output = [dateStr.slice(0, 1), ':', dateStr.slice(1)].join('');
            return output;
        }
    }

    var startString = (props.booking.startTime).toString();
    var finishString = (props.booking.finishTime).toString();

    var start = formatDate(startString);
    var finish = formatDate(finishString);

    function getDate(dateStr)
    {
        var dateParts = props.booking.date.split("-");
        return new Date(dateParts[0], dateParts[1] - 1, dateParts[2], props.booking.startTime/100);
    }
  
    var currDate = new Date();
    var checkDate = getDate(props.booking.date);
    console.log("curr: " + currDate);
    console.log("checking: "+ checkDate);
    function canCancel(date){
        const today = getFormattedDate(0);
        const tomorrow = getFormattedDate(1);
        console.log(today);
        console.log(tomorrow);
        if(date === today){
            return false;
        }
        else if(date === tomorrow){
            return false;
        }
        else{
            return true;
        }
    }

    return (
        
        <tr>
            <td>{props.booking.id}</td>
            <td>{userDetails.description}</td>
            <td>{props.booking.workerId}</td>
            <td>{props.booking.workerName}</td>
            <td>{start}</td>
            <td>{finish}</td>
            <td>{props.booking.date}</td>
            <td>{currDate <= checkDate && <button className="btn btn-success" readOnly>Status : Current</button>}
            {currDate > checkDate && <button className="btn btn-secondary" readOnly>Status : Past</button>}
            </td>
            <td>
            {currDate <= checkDate && canCancel(props.booking.date) && <button onClick={handleShow} className="btn btn-danger">Cancel</button>}
            <Modal
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}>
                <Modal.Header closeButton>
                <Modal.Title>Confirm Cancel</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    Are you sure you want to cancel this booking?
                </Modal.Body>
                <Modal.Footer>
                <button className = "btn btn-secondary" variant="secondary" onClick={handleClose}>Close</button>
                <button className = "btn btn-danger" variant="secondary" onClick={cancelBooking}>Confirm Cancel</button>
                </Modal.Footer>
            </Modal>
            {currDate <= checkDate && canCancel(props.booking.date)===false && <button className="btn btn-secondary" readOnly>Cannot cancel in less than 48 hrs</button>}
            {currDate > checkDate && <button className="btn btn-secondary" readOnly>Already Finished</button>}
            </td>
        </tr>
    )
}

export default DisplayABooking;