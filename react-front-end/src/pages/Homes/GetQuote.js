import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

/**
 * The page responsible for viewing vehicles
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function GetQuoteById() {
    let [homeQuote, setHomeQuote] = useState([]);
    const [id, setId] = useState("");
    const [homeId, setHomeId] = useState("");


    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${id}/quote/homes/${homeId}`, requestOptions)
            .then(response => response.json())
            .then(setHomeQuote)
            .catch(error => console.log('error', error));

    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <label>Enter the User ID of the Home you would like to get a quote for:
                    <input
                        type="text"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </label>
                <p></p>
                <label>Enter the Home ID of the Home you would like to get a quote for:
                    <input
                        type="text"
                        value={homeId}
                        onChange={(e) => setHomeId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
            <ul>
                {
                    homeQuote.map(homeData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Associated User's
                                    Name: {homeData.home.user.lastName}, {homeData.home.user.firstName}</ListGroup.Item>
                                <ListGroup.Item>Start Date: {homeData.startDate}</ListGroup.Item>
                                <ListGroup.Item>End Date: {homeData.endDate}</ListGroup.Item>
                                <ListGroup.Item>Total Tax: {homeData.tax}</ListGroup.Item>
                                <ListGroup.Item>Total Before Tax: {homeData.totalBeforeTax}</ListGroup.Item>
                                <ListGroup.Item>Date Home Built: {homeData.home.dateBuilt}</ListGroup.Item>
                                <ListGroup.Item>Home Heating Type: {homeData.home.heatingType}</ListGroup.Item>
                                <ListGroup.Item>Home Location: {homeData.home.location}</ListGroup.Item>
                                <ListGroup.Item>Home Value: {homeData.home.value}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}
