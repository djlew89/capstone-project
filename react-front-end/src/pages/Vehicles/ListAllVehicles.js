import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

// TODO update this to be a select user ID instead of displaying everything in db. Then update file name

/**
 * The page responsible for viewing vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewVehicles() {
    let [vehicle, setVehicle] = useState([]);

    fetch("http://localhost:8080/v1/autos")
        .then(response => response.json())
        .then(setVehicle)
        .catch(e => console.log(e.message))

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
                                <ListGroup.Item>Associated User's ID: {vehicleData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {vehicleData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}