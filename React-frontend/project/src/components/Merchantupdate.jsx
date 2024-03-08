import axios from "axios"
import design from "./style/home.module.css"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"

const Merchantupdate=()=>{
    let [name,setName]=useState("")
    let [phone,setPhone]=useState(0)
    let [email,setEmail]=useState("")
    let [password,setPassword]=useState("")
    let [gst,setGst]=useState("")
    let navi=useNavigate()
    let id=useParams()
    console.log(id.ak);

    useEffect(()=>{
        axios.get(`http://localhost:8080/merchants/${id.ak}`)
        .then((e)=>{console.log(e.data.body)
        setName(e.data.body.name)
        setEmail(e.data.body.email)
        setGst(e.data.body.gst)
        setPassword(e.data.body.password)
        setPhone(e.data.body.phone)
        })
        .catch((e)=>{console.log(e);})
    },[])

    function submit(){
        let data={
            "id":id.ak,
            "name":name,
            "phone":phone,
            "email":email,
            "gst":gst,
            "password":password
        }
        console.log(data);

        axios.put(`http://localhost:8080/merchants`,data)
        .then((e)=>{console.log(e)
            navi(`/merchanthome/${e.data.body.id}`)
        })
        .catch((e)=>{console.log(e);})

    }

    return(<div className={design.update}>
                <h1>merchant update</h1>
                <div className={design.ubox}>
                        <label htmlFor="">Name</label>
                        <input value={name} onChange={(e)=>{setName(e.target.value)}}  type="text" />
                
                         <label htmlFor="">Phone</label>
                         <input value={phone} onChange={(e)=>{setPhone(e.target.value)}} type="text" />
                    
                         <label htmlFor="">Email</label>
                         <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type="text" />
                
                         <label htmlFor="">gender</label>
                         <input value={gst} onChange={(e)=>{setGst(e.target.value)}} type="text" />
                    
                         <label htmlFor="">Password</label>
                        <input value={password} onChange={(e)=>{setPassword(e.target.value)}} type="text" />
                    
                    <button onClick={submit}>Submit</button>
                </div>
        </div>)
}
export default Merchantupdate