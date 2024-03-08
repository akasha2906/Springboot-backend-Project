import axios from "axios"
import design from "./style/home.module.css"
import { useEffect, useState } from "react"
import { Link, useParams } from "react-router-dom"

const UserHomepage=()=>{
    let id=useParams()
    let [user,setUser]=useState([])
    useEffect(()=>{
        console.log(id.ak);
        axios.get(`http://localhost:8080/users/${id.ak}`)
        .then((e)=>{setUser(e.data.body) 
            console.log("done");})
        .catch(()=>{console.log("err");})

    },[id])

    return(
        <div className={design.home}>
            <h1 style={{color:"red",fontSize:80}}>welcome {user.name}</h1>   
            <Link to={`/userupdate/${user.id}`}>Update user</Link>

        </div>
    )
}
export default UserHomepage