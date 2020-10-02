import React from 'react';
import '../App.css'
import NavigationBar from './Layout/NavigationBar';

function ContactUs(){
    return(
        <div>
        <NavigationBar/>
        <br></br>
        <br></br>
        <form className = "contactUs">
            <h1>Contact Us</h1>
            <h4>Our Contact Details are as mentioned below:</h4>
            <label>Chiraporn Ropkhop - s3781279@student.rmit.edu.au (Scrum Master)</label>
            <br></br>
            <label>Ngoc Do - s3698200@student.rmit.edu.au</label>
            <br></br>
            <label>Allan Baker - s3718362@student.rmit.edu.au</label>
            <br></br>
            <label>Kavin Abeysinghe - s3756717@student.rmit.edu.au</label>
            <br></br>
        </form>
        </div>);
}

export default ContactUs;