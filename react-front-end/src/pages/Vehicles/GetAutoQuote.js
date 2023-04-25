import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

/**
 * The page responsible for viewing auto quotes
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function GetAutoQuoteById() {
    let [autoQuote, setAutoQuote] = useState([]);
    const [id, setId] = useState("");
    const [vehicleId, setVehicleId
    ] = useState("");


    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${id}/quote/autos/${vehicleId}`, requestOptions)
            .then(response => response.json())
            .then(setAutoQuote)
            .catch(error => console.log('error', error));

    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <label>Enter the User ID of the Auto you would like to get a quote for:
                    <input
                        type="text"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </label>
                <p></p>
                <label>Enter the Auto ID of the Auto you would like to get a quote for:
                    <input
                        type="text"
                        value={vehicleId}
                        onChange={(e) => setVehicleId
                        (e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
            <ul>
                {
                    autoQuote.map(autoData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Associated User's
                                    Name: {autoData.driver.user.lastName}, {autoData.driver.user.firstName}</ListGroup.Item>
                                <ListGroup.Item>Start Date: {autoData.startDate}</ListGroup.Item>
                                <ListGroup.Item>End Date: {autoData.endDate}</ListGroup.Item>
                                <ListGroup.Item>Total Tax: {autoData.tax}</ListGroup.Item>
                                <ListGroup.Item>Total Before Tax: {autoData.totalBeforeTax}</ListGroup.Item>
                                <ListGroup.Item>Number of Accidents: {autoData.driver.numberAccidents}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}
