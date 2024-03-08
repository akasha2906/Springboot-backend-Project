import { Link } from "react-router-dom"
import design from "./style/design.module.css"
import axios from "axios"
import { useState } from "react"
const MerchantLogin=()=>{

    let [phone,setPhone]=useState(0)
    let [password,setPassword]=useState("")

    function verify(){
        console.log(phone,password);
        axios.get(`http://localhost:8080/merchants`)
        .then((e)=>{console.log(e);})
        .catch(()=>{console.log("err");})
    }
    

    return(
        <div className={design.login}>
            <h1>Merchant Login</h1>     
            <div className={design.logins}>
            <img src="https://play-lh.googleusercontent.com/JA1PIg2C55SmFK6PWgMx_4DlxR9lFVvZIpL5Yq6lLaLA7lICWs_7VWySAM31owr3tA" alt="" />
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
            <h4 style={{color:"red"} } >I don't have an account? <Link style={{textDecoration:"none"}} to="/msignup">Sign up</Link></h4>
        </div>
    )
}
export default MerchantLogin