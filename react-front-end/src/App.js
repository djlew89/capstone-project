import './App.css';
import {Route, Routes} from "react-router-dom";
import ViewUsers from "./pages/Users/User";
import ViewDrivers from './pages/Driver';
import ViewUserHomes from "./pages/Homes/UserHome";
import NavigationBar from './Navbar';
import ViewVehicles from "./pages/Vehicles";
import Homepage from "./Slideshow";
import 'bootstrap/dist/css/bootstrap.min.css';

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
            </Routes>
        </>
    );
}

export default App;