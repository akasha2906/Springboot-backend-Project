import { Link, useNavigate } from "react-router-dom"
import design from "./style/design.module.css"
import { useState } from "react"
import axios from "axios"
const MerchantSignup=()=>{
        let[name,setName]=useState("")
    let[phone,setPhone]=useState()
    let[email,setEmail]=useState("")
    let[gst,setGst]=useState("")
    let[password,setPassword]=useState("")
    let navi=useNavigate()

    function submit(){
        let merchant={
            "name":name,
            "gst":gst,
            "phone":phone,
            "email":email,
            "password":password
        }
        console.log(merchant);
        axios.post(`http://localhost:8080/merchants`,merchant)
        .then((e)=>{console.log(e.data.body.id)
    navi(`/merchanthome/${e.data.body.id}`)
})
        .catch((e)=>{console.log("err");})
    }

    return(
        <div className={design.signup}>
            <h1>Merchant Signup</h1>     
            <div className={design.logins}>
            <img src="https://play-lh.googleusercontent.com/JA1PIg2C55SmFK6PWgMx_4DlxR9lFVvZIpL5Yq6lLaLA7lICWs_7VWySAM31owr3tA" alt="" />
            <tr>
                    <td><label htmlFor="">Name: </label></td>
                    <td><input type="text" onChange={(e)=>{setName(e.target.value)}}/></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Phone: </label></td>
                    <td><input type="tel" onChange={(e)=>{setPhone(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">gst: </label></td>
                    <td><input type="text" onChange={(e)=>{setGst(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Email: </label></td>
                    <td><input type="email" onChange={(e)=>{setEmail(e.target.value)}} /></td>
                </tr>
                <tr>
                    <td><label htmlFor="">Password: </label></td>
                    <td><input type="password" onChange={(e)=>{setPassword(e.target.value)}} /></td>
                </tr>
                <button className="btn btn-light" onClick={submit}>Submit</button>
            </div>       
            <h4 style={{color:"red"} } >I already have an account? <Link style={{textDecoration:"none"}} to="/merchant">Sign in</Link></h4>
        </div>
    )
}
export default MerchantSignup