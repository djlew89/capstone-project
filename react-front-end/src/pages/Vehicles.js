import React, { useState } from "react";
import {ListGroup} from "react-bootstrap";


export default function ViewVehicles() {
    let [vehicle, setVehicle] = useState([]);

    fetch("http://localhost:8080/v1/autos")
        .then(response => response.json())
        .then(setVehicle)
        .catch(e => console.log(e.message))

    /**
     * id make model year
     */


    return (
        <>
            <ul>
                {
                    Array.from(vehicle).map(vehicleData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Vehicle ID: {vehicleData.id}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Make: {vehicleData.make}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Model: {vehicleData.model}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Year: {vehicleData.year}</ListGroup.Item>
                                <ListGroup.Item>Associated User ID: {vehicleData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User Name: {vehicleData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}