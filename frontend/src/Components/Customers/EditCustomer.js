import React from 'react';
import '../../App.css'
//import {Link as LinkRouter} from "react-router-dom";
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';

function EditCustomer()
{
    return(
        <div>
            <NavigationBarCustomerPage/>
            <form className = "editCustomer">
                <h1>Edit Customer</h1>
            </form>
        </div>
    );
}

export default EditCustomer;