import React from 'react'
import axios from 'axios';

function ToDelete(){
function handleClick(){
    axios.get("http://localhost:8080/api/worker/1/1/2002-08-21/washing/1/")
    .then((response)=>{
        console.log(response);
    }).catch().finally();
}

return (
    <div>
    <button onClick={handleClick}>test('should ', () => {
        
    })
    </button>
    </div>
)
}

export default ToDelete;