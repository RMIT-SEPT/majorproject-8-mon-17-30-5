import WorkerForm from "./WorkerForm"
import React, { Component} from "react";


export default class AddWorker extends Component {
  // constructor(props) {
  //   super(props);
  //   //this.submitAddWorker = this.submitAddWorker.bind(this);
  // }

  handleClick = () => {
    this.props.toggle();
  };

  // submitAddWorker = (workerInfo) => {
  //   // TODO: submit to backend
  //   console.log("Add worker form submitted");
  //   console.log(workerInfo);
  //  // console.log(this.props.history);
  //  this.createPerson(workerInfo);
  // }

  
//TODO delete useHistory if not needed
AddWorker() {
 
  const history = useHistory();
  const[userDetails, setUserDetails] = useState({
    username: "",
    firstname:"",
    lastname: "",
    password: "",
    starttime:"",
    finishtime:"",
    hasLoginFailed: false
  });
     //export default class AddWorker extends Component {
}
 /* handleSubmit(event) {
    console.log("handleSubmit");
    event.preventDefault();
    const person = {
      username: userDetails.username,
      firstName: userDetails.finishtime,
      lastName:userDetails.lastname,
      password:userDetails.password,
      startTime:userDetails.starttime,
      finishTime:userDetails.finishtime
    }
    console.log(person);
    createPerson(person);
  }*/
  // async createPerson(person){
  //   try {
  //       console.log("creating a worker");
  //       const res = await axios.post("http://localhost:8080/api/worker/create", person);
  //       // TODO: push to React history
  //       // history.push("/");
  //     } catch (err) {
  //      console.log(err);
  //     }
  //    }


 // render() {
    render() {

      return (
        <div> 
        <WorkerForm/>
        </div>      
    );
  }
//} 