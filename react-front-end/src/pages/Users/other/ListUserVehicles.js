import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

/**
 * The page responsible for viewing a customers vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewAssociatedVehicles() {
    let [vehicle, setVehicle] = useState([]);
    const [userId, setUserId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userId}/autos`, requestOptions)
            .then(response => response.json())
            .then(setVehicle)
            .catch(error => console.log('error', error));
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <label>Enter the User ID of the vehicle you would like to view information on:
                    <input
                        type="text"
                        value={userId}
                        onChange={(e) => setUserId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>

            <ul>
                {
                    Array.from(vehicle).map(vehicleData =>
                        [
                            <ListGroup id="uservehicle_data_display">
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