import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

/**
 * The page responsible for viewing home policy information
 *
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function ViewHomePolicyByHomeID() {
    let [home, setHome] = useState([]);
    const [homeId, setHomeId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/homes/${homeId}/policy`, requestOptions)
            .then(response => response.json())
            .then(setHome)
            .catch(error => console.log('error', error));
    }

    return (
        <>
            <h1 id="data_display">Get home policy by home id</h1>
            <form onSubmit={handleSubmit}>
                <label>Enter the House ID of the home you would like to view the data of:
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
                    home.map(homeData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Home ID: {homeData.id}</ListGroup.Item>
                                <ListGroup.Item>Date Built: {homeData.home.dateBuilt}</ListGroup.Item>
                                <ListGroup.Item>Heating Type: {homeData.home.heatingType}</ListGroup.Item>
                                <ListGroup.Item>Location: {homeData.home.location}</ListGroup.Item>
                                <ListGroup.Item>Date of Birth: {homeData.home.value}</ListGroup.Item>
                                <ListGroup.Item>Policy Start Date: {homeData.startDate}</ListGroup.Item>
                                <ListGroup.Item>Policy End Date: {homeData.endDate}</ListGroup.Item>
                                <ListGroup.Item>Policy Total Before Tax: {homeData.totalBeforetax}</ListGroup.Item>
                                <ListGroup.Item>Associated User's ID: {homeData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {homeData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}
