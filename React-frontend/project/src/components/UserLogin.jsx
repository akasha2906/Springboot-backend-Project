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
        .catch(()=>{console.log("err");})
    }

    return(
        <div id={design.user} className={design.login}>
            <h1>User Login</h1>     
            <div className={design.logins}>
            <img src="https://www.vhv.rs/dpng/f/509-5097256_new-svg-image-login-logo-user-icon-hd.png" alt="" />
            <tr>
                <td><label htmlFor="">Phone: </label></td>
                <td><input type="tel" onChange={(e)=>{setPhone(e.target.value)}} /></td>
            </tr>
            <tr>
                <td><label htmlFor="">Password: </label></td>
                <td><input type="password" onChange={(e)=>{setPassword(e.target.value)}} /></td>
            </tr>
            <button onClick={verify}>submit</button>
            </div>       
            <h4 style={{color:"red"} } >I don't have an account? <Link style={{textDecoration:"none"}} to="/usignup">Sign up</Link></h4>
        </div>
    )
}
export default UserLogin