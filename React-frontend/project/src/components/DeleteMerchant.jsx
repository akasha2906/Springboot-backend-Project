import { useNavigate, useParams } from "react-router-dom"
import design from "./style/home.module.css"
import axios from "axios"
const DeleteMerchant=()=>{
    let id=useParams()
    let navi=useNavigate()
    function yes(){
        axios.delete(`http://localhost:8080/merchants/${id.ak}`)
        .then(()=>{console.log("done");})
        .catch(()=>{console.log("err");})
        navi(`/merchant`)
    }

    function no(){
        navi(`/merchanthome/${id.ak}`)
    }

    return(<div className={design.delete}>
        <h1>Are you delete?</h1>
       <div className={design.dbox}>
       <button onClick={yes}>Yes</button>
        <button onClick={no}>No</button>
       </div>
    </div> )
}
export default DeleteMerchant