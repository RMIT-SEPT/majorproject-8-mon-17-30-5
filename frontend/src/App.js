import React from 'react';
import logo from './logo.svg';
import {BrowserRouter as Router, Route, Link as LinkRouter, Switch} from "react-router-dom";
import LoginForm from './Components/Layout/LoginForm';
import NavigationBar from './Components/Layout/NavigationBar'
import CustomerDashboard from './Components/Dashboard/CustomerDashboard'
import AboutUs from './Components/AboutUs'
import ContactUs from './Components/ContactUs'
import SingleCustomer from './Components/SingleCustomer'
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
  <Router>
    <div className="App">
        <Switch>
          <Route path = "/" exact component = {LoginForm}></Route>
          <Route path = "/login" exact component = {CustomerDashboard}></Route>
          <Route path = "/about-us" exact component = {AboutUs}></Route>
          <Route path = "/contact-us" exact component = {ContactUs}></Route>
        </Switch>
    </div>
       
    </Router>
 
  );
}

export default App;
