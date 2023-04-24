import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

// TODO update this to be a select user ID instead of displaying everything in db. Then update file name


/**
 * The page responsible for viewing vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewVehiclesByID() {
    let [vehicle, setVehicle] = useState([]);
    const [id, setId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch("http://localhost:8080/v1/autos/1", requestOptions)
            .then(response => response.json())
            .then(setVehicle)
            .catch(error => console.log('error', error));
    }

    console.log(Array.of(vehicle))

    return (
        <>
            <ul>
                {
                    Array.of(vehicle).map(vehicleData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Home ID: {vehicleData.id}</ListGroup.Item>
                                <ListGroup.Item>Date Built: {vehicleData.dateBuilt}</ListGroup.Item>
                                <ListGroup.Item>Heating Type: {vehicleData.heatingType}</ListGroup.Item>
                                <ListGroup.Item>Location: {vehicleData.location}</ListGroup.Item>
                                <ListGroup.Item>Date of Birth: {vehicleData.value}</ListGroup.Item>
                                {/*TODO uncommenting while table is loaded loads these but refreshing then crashes*/}
                                {/*<ListGroup.Item>Associated User's ID: {vehicleData.user.id}</ListGroup.Item>*/}
                                {/*<ListGroup.Item>Associated User's Name: {vehicleData.user.firstName}</ListGroup.Item>*/}
                            </ListGroup>
                        ])
                }
            </ul>
            <h1 id="data_display">Get house by house id</h1>
            <form onSubmit={handleSubmit}>
                <label>Enter the House ID of the home you would like to view the data of:
                    <input
                        type="text"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    );
}