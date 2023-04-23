import React, { useState } from "react";

//TODO this

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
                            <li>Home ID: {homeData.id}</li>,
                            <li>Date Built: {homeData.dateBuilt}</li>,
                            <li>Heating Type: {homeData.heatingType}</li>,
                            <li>Location: {homeData.location}</li>,
                            <li>Date of Birth: {homeData.value}</li>,
                            <li>Associated User ID: {homeData.user.id}</li>,
                            <li>Associated User First Name: {homeData.user.firstName}</li>,
                        ])
                }
            </ul>
        </>
    );
}