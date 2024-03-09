import { Link, useNavigate } from "react-router-dom"
import design from "./style/design.module.css"
import axios from "axios"
import { useState } from "react"
const MerchantLogin=()=>{

    let [email,setEmail]=useState("")
    let [password,setPassword]=useState("")
    let navi=useNavigate()

    function verify(){
        console.log(email,password);
        axios.post(`http://localhost:8080/merchants/verifybyemail?email=${email}&password=${password}`)
        .then((e)=>{console.log("login successfull");
        navi(`/merchanthome/${e.data.body.id}`)})
        .catch(()=>{
            let error=document.getElementById("error")
            error.innerHTML="*Email or Password is wrong*"
            console.log(error);
        })
    }
    

    return(
        <div className={design.login}>
            <h1>Merchant Login</h1>     
            <img src="https://play-lh.googleusercontent.com/JA1PIg2C55SmFK6PWgMx_4DlxR9lFVvZIpL5Yq6lLaLA7lICWs_7VWySAM31owr3tA" alt="" />
            <div className={design.logins}>
                <label htmlFor="">email: </label>
                <input type="email" onChange={(e)=>{setEmail(e.target.value)}} />
            
                <label htmlFor="">Password: </label>
                <input type="password" onChange={(e)=>{setPassword(e.target.value)}} />
            
            <button onClick={verify}>submit</button>
            </div>       
            <p id="error" style={{color:"red"}}>enter email and password</p>
            <h4 style={{color:"red"} } >I don't have an account? <Link style={{textDecoration:"none"}} to="/msignup">Sign up</Link></h4>
        </div>
    )
}
export default MerchantLogin