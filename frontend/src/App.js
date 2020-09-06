import React from 'react';
import {Router, Route, Switch} from "react-router-dom";
import LoginForm from './Components/Layout/LoginForm';
import CustomerDashboard from './Components/Customers/CustomerDashboard';
import AboutUs from './Components/AboutUs';
import ContactUs from './Components/ContactUs';
import "bootstrap/dist/css/bootstrap.min.css";
import AdminDashboard from './Components/Admins/AdminDashboard';
import WorkerPage from './Components/Admins/WorkerPage';
import BookingPage from './Components/Admins/BookingPage';
import RegisterForm from './Components/Customers/RegisterForm';
import CustomerPage from './Components/Customers/CustomerPage';
import CustomerBooking from './Components/Customers/CustomerBooking';
import workerDashBoard from './Components/Workers/WorkerDashBoard';
import AddWorker from './Components/Admins/AddWorker';
import history from './history';
import AdminLogin from './Components/Admins/AdminLogin';
import WorkerLogin from "./Components/Workers/WorkerLogin";


function App() {
  return (
  <Router history={history}>
    <div className="App">
        <Switch>
          <Route path = "/" exact component = {LoginForm}></Route>
          <Route path ="/signup" exact component={RegisterForm}></Route>
          <Route path = "/customerDashBoard" exact component = {CustomerDashboard}></Route>
          <Route path = "/about-us" exact component = {AboutUs}></Route>
          <Route path = "/contact-us" exact component = {ContactUs}></Route>
          <Route path = "/admin" exact component = {AdminDashboard}></Route>
          <Route path = "/admin/workers" exact component = {WorkerPage}></Route>
          <Route path = "/booking" exact component = {BookingPage}></Route>
          <Route path = "/admin/add-worker" exact component = {AddWorker}></Route>
          <Route path = "/signupform" exact component = {RegisterForm}></Route>
          <Route path = "/loginform" exact component = {LoginForm}></Route>
          <Route path = "/custDetails" exact component = {CustomerPage}></Route>
          <Route path = "/booking-page" exact component = {CustomerBooking}></Route>
          <Route path = "/workerDashboard" exact component = {workerDashBoard}></Route>
          <Route path = "/admin/login" exact component={AdminLogin}></Route>
          <Route path = "/worker/login" exact component={WorkerLogin}></Route>
          <Route path = "/workerDetails" exact component = {WorkerPage}></Route>
        </Switch>
    </div>
       
    </Router>
 
  );
}

export default App;
