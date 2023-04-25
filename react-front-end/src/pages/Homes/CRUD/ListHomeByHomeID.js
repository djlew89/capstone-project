import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

/**
 * The page responsible for viewing home information
 *
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewHomeByHomeID() {
    let [home, setHome] = useState([]);
    const [homeId, setHomeId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/homes/${homeId}`, requestOptions)
            .then(response => response.json())
            .then(setHome)
            .catch(error => console.log('error', error));
    }

    if ( home == null) {
        return <h1>Loading...</h1>;
    }

    return (
        <>
            <ul>
                {
                    home.map(homeData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item>Home ID: {homeData.id}</ListGroup.Item>
                                <ListGroup.Item>Date Built: {homeData.dateBuilt}</ListGroup.Item>
                                <ListGroup.Item>Heating Type: {homeData.heatingType}</ListGroup.Item>
                                <ListGroup.Item>Location: {homeData.location}</ListGroup.Item>
                                <ListGroup.Item>Date of Birth: {homeData.value}</ListGroup.Item>
                                <ListGroup.Item>Associated User's ID: {homeData.user.id}</ListGroup.Item>
                                <ListGroup.Item>Associated User's Name: {homeData.user.firstName}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
            <h1 id="data_display">Get house by house id</h1>
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
        </>
    );
}