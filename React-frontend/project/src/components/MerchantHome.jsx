import axios from "axios";
import design from "./style/home.module.css"
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom"
import DeleteMerchant from "./DeleteMerchant";

const MerchantHome=()=>{
    let [mer,setMer]=useState([])
    let id=useParams()
    useEffect(()=>{
        axios.get(`http://localhost:8080/merchants/${id.ak}`)
        .then((e)=>{setMer(e.data.body);})
        .catch(()=>{console.log("err");})
    },[id])

    return(
        <div className={design.home}>
            {/* {console.log("done")} */}
            <h1> Welcome {(mer.name)} </h1>
            <Link to={`/merchantupdate/${mer.id}`}>Update Merchant</Link>
            <Link to={`/mdelete/${id.ak}`}>Delete Merchant</Link>
            
        </div>
    )
}
export default MerchantHome