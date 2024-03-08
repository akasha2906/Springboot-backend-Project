import { Link } from "react-router-dom"
import design from "./style/design.module.css"
import { useState } from "react"
const UserSignup=()=>{
    let[name,setName]=useState("")
    let[phone,setPhone]=useState()
    let[email,setEmail]=useState("")
    let[gender,setGender]=useState("")
    let[password,setPassword]=useState("")

    function submit(){
        let user={
            "name":name,
            "gender":gender,
            "phone":phone,
            "email":email,
            "password":password
        }
        console.log(user);
    }

    return(
        <div id={design.user} className={design.signup}>
            <h1>User Signup</h1>     
            <div className={design.logins}>
            <img src="https://www.vhv.rs/dpng/f/509-5097256_new-svg-image-login-logo-user-icon-hd.png" alt="" />
            <tr>
                    <td><label htmlFor="">Name: </label></td>
                    <td><input type="text" onChange={(e)=>{setName(e.target.value)}}/></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Phone: </label></td>
                    <td><input type="tel" onChange={(e)=>{setPhone(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Gender: </label></td>
                    <td><input type="text" onChange={(e)=>{setGender(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Email: </label></td>
                    <td><input type="email" onChange={(e)=>{setEmail(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Password: </label></td>
                    <td><input type="password" onChange={(e)=>{setPassword(e.target.value)}} /></td>
                </tr>
                <button onClick={submit}>submit</button>
            </div>       
            <h4 style={{color:"red"} } >I already have an account? <Link style={{textDecoration:"none"}} to="/user">Sign in</Link></h4>
        </div>
    )
}
export default UserSignup