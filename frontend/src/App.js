import React from 'react';
import logo from './logo.svg';
import {BrowserRouter as Router, Route, Link as LinkRouter, Switch} from "react-router-dom";
import LoginForm from './Components/LoginForm';
import NavigationBar from './Components/NavigationBar'
import CustomerDashboard from './Components/CustomerDashboard'
import AboutUs from './Components/AboutUs'
import ContactUs from './Components/ContactUs'

function App() {
  return (
  <Router>
    <div className="App">
        <LoginForm/>

        <switch>
          <Route path = "/login" exact component = {CustomerDashboard}></Route>
          <Route path = "/about-us" exact component = {AboutUs}></Route>
          <Route path = "/contact-us" exact component = {ContactUs}></Route>
        </switch>
    </div>
    </Router>
 
  );
}

export default App;
