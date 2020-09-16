import React from 'react';
import '../App.css'
import NavigationBar from './Layout/NavigationBar';

function AboutUs(){
    return(
        <div>
        <NavigationBar/>
        <br></br>
        <br></br>
        <form className="aboutUs">
            <h1>About Us</h1>
            <label>This project was made as part of the
            First Assignment for Software Engineering:
            Process and Tools for Semester 2 of 2020.</label>
            <br></br>
            <h4>The team is as follows</h4>
            <label>Cathy Ropkhop (s3781279)</label>
            <br></br>
            <label>Ngoc Do (s3698200)</label>
            <br></br>
            <label>Allan Baker (s3718362)</label>
            <br></br>
            <label>Kavin Abeysinghe (s3756717)</label>
            <br></br>
        </form>
        </div>
    );
}

export default AboutUs;