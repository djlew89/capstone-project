import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Route, Routes} from "react-router-dom";
import ViewUsers from "./pages/Users/CRUD/ListUserData";
import EditUser from "./pages/Users/CRUD/EditUser";
import ViewDrivers from './pages/Driver';
import ViewHomeByHomeID from "./pages/Homes/ListHomeByHomeID";
import NavigationBar from './Navbar';
import ViewVehiclesByID from "./pages/Vehicles/ListVehicleByID";
import Homepage from "./Slideshow";
import DeleteUser from "./pages/Users/CRUD/DeleteUser";
import SaveData from "./pages/Users/CRUD/SaveData";
import SaveVehicle from "./pages/Vehicles/SaveVehicle";
import ViewAssociatedHomes from "./pages/Users/other/ListUserHomes";
import ViewAssociatedVehicles from "./pages/Users/other/ListUserVehicles";
import ViewAssociatedDriverData from "./pages/Users/other/ListUserDriverData";


/**
 * The main application responsible for linking together the pages and logic of the front end.
 * @author Mason Seward
 * @returns {JSX.Element}
 */
function App() {
    return (
        <>
            <NavigationBar/>
            <Routes>
                <Route path="/" element={<Homepage/>}/>
                <Route path="/Users" element={<ViewUsers/>}/>
                <Route path="/Drivers" element={<ViewDrivers/>}/>
                <Route path="/Vehicles" element={<ViewVehiclesByID/>}/>
                <Route path="/Homes" element={<ViewHomeByHomeID/>}/>
                <Route path="/EditUserData" element={<EditUser/>}/>
                <Route path="/DeleteUserData" element={<DeleteUser/>}/>
                <Route path="/SaveUserData" element={<SaveData/>}/>
                <Route path="/SaveVehicleData" element={<SaveVehicle/>}/>
                <Route path="/AssociatedHomes" element={<ViewAssociatedHomes/>}/>
                <Route path="/AssociatedVehicles" element={<ViewAssociatedVehicles/>}/>
                <Route path="/AssociatedDriver" element={<ViewAssociatedDriverData/>}/>
                <Route path="/SaveDriver" element={<ViewAssociatedDriverData/>}/>
            </Routes>
        </>
    );
}

export default App;