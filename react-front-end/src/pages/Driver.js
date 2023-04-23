import React, {useEffect, useState} from "react";


export default function ViewDrivers() {
    let [driver, setDriver] = useState("empty");

    useEffect(() => {
        fetch("http://localhost:8080/v1/drivers")
            .then(reponse => reponse.json())
            .then(setDriver)
            .catch(e => console.log(e.message))
    })

    return (
        <>
            <ul>
                {
                    Array.from(driver).map(driverData =>
                        [
                            <li>User ID: {driverData.id}</li>,
                            <li>Associated User ID: {driverData.user.id}</li>,
                            <li>Associated User First Name: {driverData.user.id}</li>,
                        ])
                }
            </ul>
        </>
    );
}