import React, { Component } from "react";
import Dropdown from 'react-dropdown';

const options = ['Female', 'Male'];

export default class AddWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  render() {
    return (
      <div>
        <span className="close" onClick={this.handleClick}> X </span>
        <form>
          <h3>Worker Details</h3>
          <label>
            First Name:
            <input type="text"/>
          </label>
          <label>
            Last Name:
            <input type="text"/>
          </label>
          <label>
            Occupation:
            <input type="text"/>
          </label>
          <label>
            Gender:
            <Dropdown options={options} onChange={this._onSelect} placeholder='Select' />;
          </label>
          <label>
            Username:
            <input type="text"/>
          </label>
          <label>
            Password:
            <input type="text"/>
          </label>
          <label>
            Working Hours:
            <input type="text"/>
          </label>
          <label>
            Working Dates:
            <input type="text"/>
          </label>
          <br />
          <input type="submit" value= "Add worker"/>
        </form>
      </div>
    );
  }
}
