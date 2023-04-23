import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Route, Routes} from "react-router-dom";
import ViewUsers from "./pages/Users/display/User";
import EditUser from "./pages/Users/editing/EditUser";
import ViewDrivers from './pages/Driver';
import ViewUserHomes from "./pages/Homes/UserHome";
import NavigationBar from './Navbar';
import ViewVehicles from "./pages/Vehicles";
import Homepage from "./Slideshow";
import DeleteUser from "./pages/Users/editing/DeleteUser";
import SaveData from "./pages/Users/editing/SaveData";

function App() {
    return (
        <>
            <NavigationBar/>
            <Routes>
                <Route path="/" element={<Homepage/>}/>
                <Route path="/Users" element={<ViewUsers/>}/>
                <Route path="/Drivers" element={<ViewDrivers/>}/>
                <Route path="/Vehicles" element={<ViewVehicles/>}/>
                <Route path="/Homes" element={<ViewUserHomes/>}/>
                <Route path="/EditUserData" element={<EditUser/>}/>
                <Route path="/DeleteUserData" element={<DeleteUser/>}/>
                <Route path="/SaveUserData" element={<SaveData/>}/>
            </Routes>
        </>
    );
}

export default App;