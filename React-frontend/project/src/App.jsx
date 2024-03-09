import { BrowserRouter, Route, Routes } from "react-router-dom"
import LandingPage from "./components/LandingPage"
import UserLogin from "./components/UserLogin"
import MerchantLogin from "./components/MerchantLogin"
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantSignup from "./components/MerchantSignup";
import UserSignup from "./components/UserSignup";
import UserHomepage from "./components/UserHomepage";
import MerchantHome from "./components/MerchantHome";
import Merchantupdate from "./components/Merchantupdate";
import Userupdate from "./components/Userupdate";
import DeleteMerchant from "./components/DeleteMerchant";
import DeleteUser from "./components/DeleteUser";
const App=()=>{
    return(
        <div>
            <BrowserRouter>
            <Routes>
                <Route path="/" element={<LandingPage/>}/>
                <Route path="/merchant" element={<MerchantLogin/>}/>
                <Route path="/user" element={<UserLogin/>}/>
                <Route path="/msignup" element={<MerchantSignup/>}/>
                <Route path="/usignup" element={<UserSignup/>}/>
                <Route path="/userhome/:ak" element={<UserHomepage/>}/>
                <Route path="/merchanthome/:ak" element={<MerchantHome/>}/>
                <Route path="/userupdate/:ak" element={<Userupdate/>}/>
                <Route path="/merchantupdate/:ak" element={<Merchantupdate/>}/>
                <Route path="/mdelete/:ak" element={<DeleteMerchant/>}/>
                <Route path="/udelete/:ak" element={<DeleteUser/>}/>
            </Routes>           
            </BrowserRouter>
        </div>
    )
}
export default App