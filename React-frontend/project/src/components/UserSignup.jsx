import { Link, useNavigate } from "react-router-dom"
import design from "./style/design.module.css"
import { useState } from "react"
import axios from "axios"
const UserSignup=()=>{
    let[name,setName]=useState("")
    let[phone,setPhone]=useState()
    let[email,setEmail]=useState("")
    let[gender,setGender]=useState("")
    let[password,setPassword]=useState("")
    let navi=useNavigate()
    function submit(){
        let user={
            "name":name,
            "gender":gender,
            "phone":phone,
            "email":email,
            "password":password
        }
        // console.log(phone.length);
        
        {axios.post(`http://localhost:8080/users`,user)
        .then((e)=>{console.log("done");
        navi(`/userhome/${e.data.body.id}`)})
        .catch((e)=>{console.log("err");})}

    }

    return(
        <div id={design.user} className={design.signup}>
            <h1>User Signup</h1>     
            <img src="https://www.vhv.rs/dpng/f/509-5097256_new-svg-image-login-logo-user-icon-hd.png" alt="" />
            <div className={design.logins}>
            
                    <label htmlFor="">Name: </label>
                    <input required type="text" onChange={(e)=>{setName(e.target.value)}}/>
               
               
                    <label htmlFor="">Phone: </label>
                    <input required type="tel" onChange={(e)=>{setPhone(e.target.value)}} />
               
                    <label htmlFor="">Gender: </label>
                    <input required type="text" onChange={(e)=>{setGender(e.target.value)}} />
                
                    <label htmlFor="">Email: </label>
                    <input required type="email" onChange={(e)=>{setEmail(e.target.value)}} />
                
                    <label htmlFor="">Password: </label>
                    <input required type="password" onChange={(e)=>{setPassword(e.target.value)}} />
                
                <button onClick={submit}>submit</button>
            </div>       
            <h4 style={{color:"red"} } >I already have an account? <Link style={{textDecoration:"none"}} to="/user">Sign in</Link></h4>
        </div>
    )
}
export default UserSignup