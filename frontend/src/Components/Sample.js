import React, {useState, useEffect} from 'react';
import axios from "axios";

function Sample(){
    const [customerData, setCustomerData] = useState({});

    useEffect(() => {
        axios.get("http://localhost:8080/api/customer/username/Austin")
        .then(function(response){
            setCustomerData(response.data);
        })
        .catch()
        .finally();
    }, [])

    return(
        <div>{customerData.id}</div>
    )
}


export default Sample;