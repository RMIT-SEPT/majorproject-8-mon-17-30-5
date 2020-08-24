import React, { Component } from "react";

export default class AddWorker extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  render() {
    
    return (
      <div>
        <div>
          <span className="close" onClick={this.handleClick}>
            X
          </span>
          <form>
            <h3>Register!</h3>
            <label>
              Name:
              <input type="text" name="name" />
            </label>
            <br />
            <input type="submit" />
          </form>
        </div>
      </div>
    );
  }
}