import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Route, Routes} from "react-router-dom";
import ViewUsers from "./pages/Users/CRUD/ListUserData";
import EditUser from "./pages/Users/CRUD/EditUser";
import ViewDrivers from './pages/Drivers/CRUD/ViewDriverById';
import ViewHomeByHomeID from "./pages/Homes/CRUD/ListHomeByHomeID";
import NavigationBar from './Navbar';
import ViewVehiclesByID from "./pages/Vehicles/CRUD/ListVehicleByID";
import Homepage from "./Slideshow";
import DeleteUserById from "./pages/Users/CRUD/DeleteUserById";
import SaveData from "./pages/Users/CRUD/SaveData";
import SaveVehicleData from "./pages/Vehicles/CRUD/SaveVehicleData";
import ViewAssociatedHomes from "./pages/Users/other/ListUserHomes";
import ViewAssociatedVehicles from "./pages/Users/other/ListUserVehicles";
import ViewAssociatedDriverData from "./pages/Users/other/ListUserDriverData";
import GetHomeQuoteById from "./pages/Homes/other/GetQuote";
import DeleteVehicleById from "./pages/Vehicles/CRUD/DeleteVehicleById";
import EditVehicleById from "./pages/Vehicles/CRUD/EditVehicleById";
import DeleteDriverById from "./pages/Drivers/CRUD/DeleteDriverById";
import SaveDriverById from "./pages/Drivers/CRUD/SaveDriverById";
import EditDriverById from "./pages/Drivers/CRUD/EditDriverById";
import SaveHomeById from "./pages/Homes/CRUD/SaveHomeById";
import DeleteHomeByHomeId from "./pages/Homes/CRUD/DeleteHomeByHomeId";
import EditHomeById from "./pages/Homes/CRUD/EditHomeById";
import GetAutoQuoteById from "./pages/Vehicles/GetAutoQuote";
import DeleteHomePolicyByHomeId from "./pages/Homes/Policy/DeleteHomePolicyById";
import RenewHomePolicyById from "./pages/Homes/Policy/RenewHomePolicyById";
import ListHomePolicyById from "./pages/Homes/Policy/ListHomePolicyById";
import SaveHomePolicyById from "./pages/Homes/Policy/SaveHomePolicyById";

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
                <Route path="/GetQuote" element={<GetHomeQuoteById/>}/>
                <Route path="/EditUserData" element={<EditUser/>}/>
                <Route path="/DeleteUserData" element={<DeleteUserById/>}/>
                <Route path="/SaveUserData" element={<SaveData/>}/>
                <Route path="/SaveVehicleData" element={<SaveVehicleData/>}/>
                <Route path="/AssociatedHomes" element={<ViewAssociatedHomes/>}/>
                <Route path="/AssociatedVehicles" element={<ViewAssociatedVehicles/>}/>
                <Route path="/AssociatedDriver" element={<ViewAssociatedDriverData/>}/>
                <Route path="/editHomeData" element={<EditHomeById/>}/>
                <Route path="/deleteHomeData" element={<DeleteHomeByHomeId/>}/>
                <Route path="/saveHomeData" element={<SaveHomeById/>}/>
                <Route path="/GetQuote" element={<ViewAssociatedDriverData/>}/>
                <Route path="/editVehicleData" element={<EditVehicleById/>}/>
                <Route path="/deleteVehicleData" element={<DeleteVehicleById/>}/>
                <Route path="/getVehicleQuote" element={<GetAutoQuoteById/>}/>
                <Route path="/deleteDriverData" element={<DeleteDriverById/>}/>
                <Route path="/saveDriverData" element={<SaveDriverById/>}/>
                <Route path="/editDriverData" element={<EditDriverById/>}/>
                <Route path="/deleteHomePolicy" element={<DeleteHomePolicyByHomeId/>}/>
                <Route path="/renewHomePolicy" element={<RenewHomePolicyById/>}/>
                <Route path="/listHomePolicy" element={<ListHomePolicyById/>}/>
                <Route path="/saveHomePolicy" element={<SaveHomePolicyById/>}/>

            </Routes>
        </>
    );
}

export default App;