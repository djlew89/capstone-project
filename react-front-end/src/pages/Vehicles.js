import React, { useState, useEffect } from "react";


export default async function ViewVehicles() {
    let [vehicle, setVehicle] = useState("empty");

    await fetch("http://localhost:8080/v1/autos")
            .then(reponse => reponse.json())
            .then(setVehicle)
            .catch(e => console.log(e.message))


    return (
        <>
            <ul>
                {
                    Array.from(vehicle).map(vehicleData =>
                        [
                            <li>Vehicle ID: {vehicleData.id}</li>,
                            <li>Make: {vehicleData.make}</li>,
                            <li>Model: {vehicleData.model}</li>,
                            <li>Year: {vehicleData.year}</li>,
                            <li>Associated User ID: {vehicleData.user.id}</li>,
                            <li>Associated User First Name: {vehicleData.user.firstName}</li>,
                        ])
                }
            </ul>
        </>
    );
}