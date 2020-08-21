import React, {useState, useEffect} from 'react';
import axios from "axios";
import Sample from './Sample';

function SingleCustomer(){

    const [customerData, setCustomerData] = useState({});

    useEffect(() => {
        axios.get("http://localhost:8080/api/customer/username/Austin")
        .then(function(response){
            setCustomerData(response.data);
            console.log(response);
        })
        .catch()
        .finally();

    }, [])

    return(
        <div>
        <ul>
            <li>{customerData.firstName}</li>
            
            <Sample/>
        </ul>
        </div>
    )
}

export default SingleCustomer;