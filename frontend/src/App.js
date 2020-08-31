import React from 'react';
import logo from './logo.svg';
import {BrowserRouter as Router, Route, Link as LinkRouter, Switch} from "react-router-dom";
import LoginForm from './Components/Layout/LoginForm';
import NavigationBar from './Components/Layout/NavigationBar';
import CustomerDashboard from './Components/Customers/CustomerDashboard';
import AboutUs from './Components/AboutUs';
import ContactUs from './Components/ContactUs';
import SingleCustomer from './Components/SingleCustomer';
import RegisterForm from'./Components/Customers/RegisterForm';
import "bootstrap/dist/css/bootstrap.min.css";
<<<<<<< Updated upstream
import AdminDashboard from './Components/Admins/AdminDashboard';
import WorkerPage from './Components/Admins/WorkerPage';
import RegisterForm from "./Components/Customers/RegisterForm";
=======
import CustomerPage from './Components/Customers/CustomerPage';
>>>>>>> Stashed changes

function App() {
  return (
  <Router>
    <div className="App">
        <Switch>
          <Route path = "/" exact component = {LoginForm}></Route>
          <Route path ="/signup" exact component={RegisterForm}></Route>
          <Route path = "/customerDashBoard" exact component = {CustomerDashboard}></Route>
          <Route path = "/about-us" exact component = {AboutUs}></Route>
          <Route path = "/contact-us" exact component = {ContactUs}></Route>
<<<<<<< Updated upstream
          <Route path = "/admin" exact component = {AdminDashboard}></Route>
          <Route path = "/admin/workers" exact component = {WorkerPage}></Route>
=======
          <Route path = "/signupform" exact component = {RegisterForm}></Route>
          <Route path = "/loginform" exact component = {LoginForm}></Route>
          <Route path = "/custDetails" exact component = {CustomerPage}></Route>
>>>>>>> Stashed changes
        </Switch>
    </div>
       
    </Router>
 
  );
}

export default App;
