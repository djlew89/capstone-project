import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

/**
 * The page responsible for viewing a customers homes
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewAssociatedDriverData() {
    let [driver, setDriver] = useState([]);
    const [id, setId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${id}/autos`, requestOptions)
            .then(response => response.json())
            .then(setDriver)
            .catch(error => console.log('error', error));
    }

    return (
        <>
            <ul>
                {
                    Array.from(driver).map(driverData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Driver ID: {driverData.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's ID: {driverData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {driverData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
            <form onSubmit={handleSubmit}>
                <label>Enter the User ID of the home you would like to view information on:
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