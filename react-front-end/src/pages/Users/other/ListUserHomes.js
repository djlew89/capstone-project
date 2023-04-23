import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

export default function ViewAssociatedHomes() {
    let [user, setUser] = useState([]);
    const [id, setId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${id}/homes`, requestOptions)
            .then(response => response.json())
            .then(setUser)
            .catch(error => console.log('error', error));
    }

    return (
        <>
            <ul>
                {
                    user.map(homeData =>
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
            <form onSubmit={handleSubmit} id="view_user_form_display">
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