import { Link } from "react-router-dom"
import design from "./style/design.module.css"
const LandingPage=()=>{
    return(
        <div className={design.landingpage}>
            <Link to="/merchant">
                <img src="https://play-lh.googleusercontent.com/JA1PIg2C55SmFK6PWgMx_4DlxR9lFVvZIpL5Yq6lLaLA7lICWs_7VWySAM31owr3tA" alt="" />
               <br />
                Merchant</Link>

            <Link to="/user">
                <img src="https://cdn-icons-png.freepik.com/512/4143/4143099.png" alt="" />
                <br />
                User</Link>
        </div>
    )
}
export default LandingPage