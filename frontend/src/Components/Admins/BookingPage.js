import React from "react";
import ViewBooking from "./ViewBooking";

export default class BookingPage extends React.Component {
  state = {
    seen: false,
    viewBookingToggle: false,
  };

  formToggle = (stateName) => {
    this.setState({
      [stateName]: !this.state[stateName]
    });
  }

  render() {
    return (
      <div>
        <div onClick={() => this.formToggle("viewBookingToggle")}>Add</div>
        {this.state.viewBookingToggle ? <ViewBooking /> : null}
        
      </div>
    );
  }
}