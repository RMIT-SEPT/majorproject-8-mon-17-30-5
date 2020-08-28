import axios from "axios";
import { GET_ERRORS } from "./types";

const createPerson = (type, person, history) => async dispatch => {
    console.log("before try");
  try {
    console.log("after try");
      if(type==="customer"){
        const res = await axios.post("http://localhost:8080/api/customer", person);
        history.push("/");
      }else if(type==="worker"){
        console.log("creating a worker");
        const res = await axios.post("http://localhost:8080/api/worker/create", person);
        history.push("/about-us")
      }else if(type==="admin"){
        const res = await axios.post("http://localhost:8080/api/admin", person);
      }
    } catch (err) {
      dispatch({
        type: GET_ERRORS,
        payload: err.response.data
      });
    }
  };
  
export default createPerson;