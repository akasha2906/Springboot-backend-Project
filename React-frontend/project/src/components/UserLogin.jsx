import { Link, useNavigate } from "react-router-dom"
import design from "./style/design.module.css"
import { useState } from "react"
import axios from "axios"
const UserLogin=()=>{
    let [phone,setPhone]=useState(0)
    let [password,setPassword]=useState("")
    let navi=useNavigate()

    function verify(){
        console.log(phone,password);
        axios.post(`http://localhost:8080/users/userbyphone?phone=${phone}&password=${password}`)
        .then((e)=>{console.log(e.data.body);
            navi(`/userhome/${e.data.body.id}`)})
        .catch(()=>{let error=document.getElementById("error")
        error.innerHTML="*Email or Password is wrong*"
        console.log(error);})
    }

    return(
        <div id={design.user} className={design.login}>
            <h1>User Login</h1>     
            <img src="https://www.vhv.rs/dpng/f/509-5097256_new-svg-image-login-logo-user-icon-hd.png" alt="" />
            <div className={design.logins}>
           
                <label htmlFor="">Phone: </label>
                <input type="tel" onChange={(e)=>{setPhone(e.target.value)}} />
           
                <label htmlFor="">Password: </label>
                <input type="password" onChange={(e)=>{setPassword(e.target.value)}} />
            
            <button onClick={verify}>submit</button>
            </div>   
            <p id="error" style={{color:"red"}}>enter phone and password</p>    
            <h4 style={{color:"red"} } >I don't have an account? <Link style={{textDecoration:"none"}} to="/usignup">Sign up</Link></h4>
        </div>
    )
}
export default UserLogin