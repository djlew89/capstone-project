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

    // this is used for setting the id from the form input to track in the fetch statement
    let [id, setId] = useState("");

    let requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/v1/drivers/${id}`, requestOptions)
        .then(response => response.json())
        .then(setDriver)
        .catch(error => console.log('error', error));

    return (
        <>
            <ul>
                {
                    Array.from(driver).map(driverData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>User ID: {driverData.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's ID: {driverData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {driverData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}