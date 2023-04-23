import React, { useState } from "react";
import { ListGroup } from 'react-bootstrap';

export default function ViewDrivers() {
    let [driver, setDriver] = useState([]);

    fetch("http://localhost:8080/v1/drivers")
        .then(response => response.json())
        .then(setDriver)
        .catch(e => console.log(e.message))

    return (
        <>
            <ul>
                {
                    Array.from(driver).map(driverData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>User ID: {driverData.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User ID: {driverData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User First Name: {driverData.user.id}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}