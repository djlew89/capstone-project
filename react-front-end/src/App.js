import './App.css';
import { Route, Routes } from "react-router-dom";
import ViewUsers from './pages/User';
import ViewDrivers from './pages/Driver';
import ViewUserHomes from "./pages/UserHome";
import NavigationBar from './Navbar';
import ViewVehicles from "./pages/Vehicles";
import 'bootstrap/dist/css/bootstrap.min.css';
import {useEffect, useState} from "react";

function App() {
  return (
    <>
      <NavigationBar />
         <Routes>
             <Route path="/"/>
             <Route path="/Users" element={<ViewUsers/>}/>
             <Route path="/Drivers" element={<ViewDrivers/>}/>
             <Route path="/Vehicles" element={<ViewVehicles/>}/>
             <Route path="/Homes" element={<ViewUserHomes/>}/>
         </Routes>
    </>
    );
}

export default App;