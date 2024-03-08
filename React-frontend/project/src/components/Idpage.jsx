import axios from "axios"
import { useEffect } from "react"


const Idpage=()=>{
    useEffect(
        ()=>{
            axios.get(`http://localhost:8080/merchants/2`)
        .then(()=>{console.log("done");})
        .catch(()=>{console.log("err");})
        }
    )
  return(
    <div>
        <h1>hi</h1>

    </div>
    )  
}

export default Idpage