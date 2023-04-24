import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

/**
 * The page responsible for viewing vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewVehiclesByID() {
    let [user, setUser] = useState([]);
    const [id, setId] = useState("");


    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${id}/autos`, requestOptions)
            .then(response => response.json())
            .then(setUser)
            .catch(error => console.log('error', error));

    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <label>Enter the User ID of the Vehicle you would like to view:
                    <input
                        type="text"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
            <ul>
                {
                    user.map(vehicleData =>
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