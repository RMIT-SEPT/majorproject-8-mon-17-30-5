import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import WorkerInfoBoard from '../Workers/WorkerInfoBoard';
import {Link as LinkRouter} from "react-router-dom";

export default class ViewWorker extends Component {

    render() {
        return (
            <div>
            <NavigationBarAdminPage/>
                <br></br>
                <br></br>
                <WorkerInfoBoard/>
                <br></br>
                <br></br>
                <LinkRouter to="/admin/workers">
                <input className = "workerButton" value="Back" readOnly/>
                </LinkRouter>
            </div>
        );
    }
}
