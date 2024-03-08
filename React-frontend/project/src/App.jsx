import { BrowserRouter, Route, Routes } from "react-router-dom"
import LandingPage from "./components/LandingPage"
import UserLogin from "./components/UserLogin"
import MerchantLogin from "./components/MerchantLogin"
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantBootLogin from "./components/MerchantBootLogin";
import UserBootLogin from "./components/UseerBootLogin";
import MerchantSignup from "./components/MerchantSignup";
import UserSignup from "./components/UserSignup";
import Idpage from "./components/Idpage";
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
            </Routes>
            </BrowserRouter>
        </div>
    )
}
export default App