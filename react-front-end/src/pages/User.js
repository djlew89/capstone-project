import React, { useState } from "react";


export default function ViewUsers() {
    let [user, setUser] = useState("empty");

    fetch("http://localhost:8080/v1/users")
        .then(reponse => reponse.json())
        .then(setUser)
        .catch(e => console.log(e.message))

    return (
        <>
            <ul>
                {
                    Array.from(user).map(userData =>
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