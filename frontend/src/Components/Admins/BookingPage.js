import React from "react";
import ViewBooking from "./ViewBooking";

export default class BookingPage extends React.Component {
  state = {
    seen: false
  };

  togglePop = () => {
    this.setState({
      seen: !this.state.seen
    });
  };

  render() {
    return (
      <div>
        <div className="btn" onClick={this.togglePop}>
          <button>View</button>
        </div>
        {this.state.seen ? <ViewBooking toggle={this.togglePop} /> : null}
      </div>
    );
  }
}