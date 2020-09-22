import React from "react";
import ViewBooking from "./ViewBooking";
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';

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
      <NavigationBarAdminPage/>
        <div onClick={() => this.formToggle("viewBookingToggle")}>Add</div>
        {this.state.viewBookingToggle ? <ViewBooking /> : null}
        
      </div>
    );
  }
}