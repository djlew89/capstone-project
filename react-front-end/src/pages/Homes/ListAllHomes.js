import React, {useState} from "react";
import {ListGroup} from "react-bootstrap";

// TODO update this to be a select user ID instead of displaying everything in db. Then update file name

/**
 * The page responsible for viewing a customer's home
 *
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewUserHomes() {
    let [userHomes, setUserHomes] = useState([]);

    fetch("http://localhost:8080/v1/users/1/homes")
        .then(response => response.json())
        .then(setUserHomes)
        .catch(e => console.log(e.message))

    return (
        <>
            <ul>
                {
                    Array.from(userHomes).map(homeData =>
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
        </>
    );
}