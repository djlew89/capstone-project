import React, { useState } from "react";
import { ListGroup } from 'react-bootstrap';

export default function ViewUsers() {
    let [user, setUser] = useState([]);

    fetch("http://localhost:8080/v1/users")
        .then(response => response.json())
        .then(setUser)
        .catch(e => console.log(e.message))

    return (
        <>
            <ul>
                {
                    Array.from(user).map(userData =>
                        [
                            <ListGroup id="data_display">
                                <ListGroup.Item key={userData.id}>User ID: {userData.id}</ListGroup.Item>
                                <ListGroup.Item>Email: {userData.email}</ListGroup.Item>
                                <ListGroup.Item>Actors: {userData.password}</ListGroup.Item>
                                <ListGroup.Item>User's First Name: {userData.firstName}</ListGroup.Item>
                                <ListGroup.Item>User's Last Name: {userData.lastName}</ListGroup.Item>
                                <ListGroup.Item>Date of Birth: {userData.dob}</ListGroup.Item>
                                <ListGroup.Item>Address: {userData.address}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}