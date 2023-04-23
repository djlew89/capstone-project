import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Route, Routes} from "react-router-dom";
import ViewUsers from "./pages/Users/CRUD/ListUserData";
import EditUser from "./pages/Users/CRUD/EditUser";
import ViewDrivers from './pages/Driver';
import ViewUserHomes from "./pages/Homes/ListAllHomes";
import NavigationBar from './Navbar';
import ViewVehicles from "./pages/Vehicles";
import Homepage from "./Slideshow";
import DeleteUser from "./pages/Users/CRUD/DeleteUser";
import SaveData from "./pages/Users/CRUD/SaveData";
import SaveVehicle from "./pages/Vehicles/SaveVehicle";
import ViewAssociatedHomes from "./pages/Users/other/ListUserHomes";

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
                <Route path="/SaveVehicleData" element={<SaveVehicle/>}/>
                <Route path="/AssociatedHomes" element={<ViewAssociatedHomes/>}/>
            </Routes>
        </>
    );
}

export default App;