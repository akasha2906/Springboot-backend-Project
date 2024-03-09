import axios from "axios"
import design from "./style/home.module.css"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"

const Userupdate=()=>{
    let [name,setName]=useState("")
    let [phone,setPhone]=useState(0)
    let [email,setEmail]=useState("")
    let [password,setPassword]=useState("")
    let [gender,setGender]=useState("")
    let navi=useNavigate()
    let id=useParams()
    console.log("id"+id.ak);

    useEffect(()=>{
        axios.get(`http://localhost:8080/users/${id.ak}`)
        .then((e)=>{setName(e.data.body.name)
        setEmail(e.data.body.email)
        setGender(e.data.body.gender)
        setPassword(e.data.body.password)
        setPhone(e.data.body.phone)
        })
        .catch((e)=>{console.log(e);})
    },[id])

    function submit(){
        let data={
            "id":id.ak,
            "name":name,
            "phone":phone,
            "email":email,
            "gender":gender,
            "password":password
        }
        // console.log(data);

        axios.put(`http://localhost:8080/users`,data)
        .then((e)=>{console.log("done")
            navi(`/userhome/${e.data.body.id}`)})
        .catch((e)=>{console.log(e);})

    }

    return(<div className={design.update}>
        <h1>user update</h1>
        <div className={design.ubox}>
            
                <label htmlFor="">Name</label>
                <input required value={name} onChange={(e)=>{setName(e.target.value)}}  type="text" />
            
            
                <label htmlFor="">Phone</label>
                <input required value={phone} onChange={(e)=>{setPhone(e.target.value)}} type="text" />
            
            
                <label htmlFor="">Email</label>
                <input required value={email} onChange={(e)=>{setEmail(e.target.value)}} type="text" />
            
            
                <label htmlFor="">gender</label>
                <input required value={gender} onChange={(e)=>{setGender(e.target.value)}} type="text" />
            
            
                <label htmlFor="">Password</label>
                <input required value={password} onChange={(e)=>{setPassword(e.target.value)}} type="text" />
            
            <button onClick={submit}>Submit</button>
        </div>
    </div>)
}
export default Userupdate