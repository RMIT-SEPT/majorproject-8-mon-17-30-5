import React, { Component } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";

export default class CustomerDashboard extends Component {
    render() {
        return (
            <div>
                <div className="jumbotron text-center">
                    <h1>Customer Dashboard</h1>
                    <p>This should show them any searched or available services</p>
                </div>
        
                <div className="container">
                    <div className="row">
                        <div className="col-sm-3">
                            <button type="button" className="btn btn-success btn-block">
                                <h4>Service 1</h4>
                                <li>Company:</li><br></br>
                                <li>ServiceType</li><br></br>
                                <li>Worker</li><br></br>
                                <li>Duration</li>
                            </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 2</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 3</h4>
                        <li>Company: </li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                        <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 4</h4>
                        <li>Company:kekfjsh</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                    </button>
                        </div>
                    </div>
                </div>
                <p></p>
                <div className="container">
                    <div className="row">
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 5</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 6</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 7</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    <div className="col-sm-3">
                        <button type="button" className="btn btn-info btn-block">
                        <h4>Service 8</h4>
                        <li>Company:</li><br></br>
                        <li>ServiceType</li><br></br>
                        <li>Worker</li><br></br>
                        <li>Duration</li>
                        </button>
                    </div>
                    </div>
                </div>
            </div>
        )
    }
}
