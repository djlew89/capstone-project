import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

export default function ViewUsers() {
    let [user, setUser] = useState([]);
    const [id, setId] = useState("");
    let requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8080/v1/users/" + id, requestOptions)
            .then(response => response.json())
            .then(setUser)
            .catch(error => console.log('error', error));
    }


    return (
        <>
            <form onSubmit={handleSubmit} id="view_user_form_display">
                <label>Enter the ID of the User you would like to view:
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
                    Array.of(user).map(userData =>
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