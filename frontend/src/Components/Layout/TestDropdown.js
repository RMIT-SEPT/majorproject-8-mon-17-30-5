import React from 'react'
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import "bootstrap/dist/css/bootstrap.min.css";

function TestDropdown() {
    // const options = [
    //     'one', 'two', 'three'
    //   ];
    // const defaultOption = options[0];
    
    return (
        <div>
        
            <select name="cars" id="cars">
            <option defaultValue="volvo">Volvo</option>
            <option defaultValue="saab">Saab</option>
            <option defaultValue="mercedes">Mercedes</option>
            <option defaultValue="audi">Audi</option>
            <option defaultValue="selected">Please select</option>
            </select>
        </div>
    )
}


export default TestDropdown;