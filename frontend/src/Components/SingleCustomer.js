import React, {useState, useEffect} from 'react';
import axios from "axios";


function SingleCustomer(){

    const [customerData, setCustomerData] = useState({});

    useEffect(() => {
        axios.get("http://localhost:8080/api/customer/username/Austin")
        .then(function(response){
            setCustomerData(response.data);
            console.log(response.data);
        })
        .catch()
        .finally();

    }, [])




    return(
        <div>
        <ul>
            <li>{customerData.firstName}</li>
            <li>{customerData.username}</li>
            <li>{customerData.address}</li>
            <li>{customerData.firstName}</li>
            <li>{customerData.firstName}</li>
        </ul>
        </div>
    )
}

export default SingleCustomer;