import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

// TODO update this to be a select user ID instead of displaying everything in db. Then update file name

/**
 * The page responsible for viewing drivers
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewDrivers() {
    let [driver, setDriver] = useState([]);
    let [id, setId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/drivers/${id}`, requestOptions)
            .then(response => response.json())
            .then(setDriver)
            .catch(error => console.log('error', error));

    }

    return (
        <>
            <h1 id="data_display">View Driver Data by Driver Id</h1>
            <form onSubmit={handleSubmit}>
                <label>Enter the driver ID of the driver you would like to view:
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
                    driver.map(driverData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>User ID: {driverData.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's ID: {driverData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {driverData.user.firstName}</ListGroup.Item>
                                <ListGroup.Item>Number of Accidents: {driverData.numberAccidents}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}