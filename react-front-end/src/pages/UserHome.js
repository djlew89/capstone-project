import React, { useState } from "react";

//TODO this

export default function ViewUserHomes() {
    let [userHomes, setUserHomes] = useState("empty");

    fetch("http://localhost:8080/v1/users/1/homes")
        .then(reponse => reponse.json())
        .then(setUserHomes)
        .catch(e => console.log(e.message))

    return (
        <>
            <ul>
                {
                    Array.from(userHomes).map(userData =>
                        [
                            <li>User ID: {userData.id}</li>,
                            <li>Email: {userData.email}</li>,
                            <li>Actors: {userData.password}</li>,
                            <li>User's First Name: {userData.firstName}</li>,
                            <li>User's Last Name: {userData.lastName}</li>,
                            <li>Date of Birth: {userData.dob}</li>,
                            <li>Address: {userData.address}</li>,
                        ])
                }
            </ul>
        </>
    );
}