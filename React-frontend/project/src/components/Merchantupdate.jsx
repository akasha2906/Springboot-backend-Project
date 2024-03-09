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

    useEffect(()=>{
        axios.get(`http://localhost:8080/merchants/${id.ak}`)
        .then((e)=>{console.log("done")
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
        // console.log(data);

        axios.put(`http://localhost:8080/merchants`,data)
        .then((e)=>{console.log("update done")
            navi(`/merchanthome/${e.data.body.id}`)
        })
        .catch((e)=>{console.log("err");})

    }

    return(<div className={design.update}>
                <h1 style={{fontSize:70}}>Update Merchant</h1>
                <div className={design.ubox}>
                        <label htmlFor="">Name</label>
                        <input required value={name} onChange={(e)=>{setName(e.target.value)}}  type="text" />
                
                         <label htmlFor="">Phone</label>
                         <input required value={phone} onChange={(e)=>{setPhone(e.target.value)}} type="text" />
                    
                         <label htmlFor="">Email</label>
                         <input required value={email} onChange={(e)=>{setEmail(e.target.value)}} type="text" />
                
                         <label htmlFor="">gender</label>
                         <input required value={gst} onChange={(e)=>{setGst(e.target.value)}} type="text" />
                    
                         <label htmlFor="">Password</label>
                        <input required value={password} onChange={(e)=>{setPassword(e.target.value)}} type="text" />
                    
                    <button onClick={submit}>Submit</button>
                </div>
        </div>)
}
export default Merchantupdate