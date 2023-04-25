import React, {useState} from "react";
import {ListGroup} from 'react-bootstrap';

/**
 * The page responsible for listing a vehicle policy by auto id
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function ViewVehiclePolicyById() {
    let [vehiclePolicy, setVehiclePolicy] = useState([]);
    const [autoId, setAutoId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        var requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/autos/${autoId}/policy`, requestOptions)
            .then(response => response.json())
            .then(setVehiclePolicy)
            .catch(error => console.log('error', error));
    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <label>Enter the Auto ID of the policy you wish to view data of:
                    <input
                        type="text"
                        value={autoId}
                        onChange={(e) => setAutoId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
            <ul>
                {
                    vehiclePolicy.map(policyData =>
                        [
                            <ListGroup id="vehiclepolicy_data_display">
                                <ListGroup.Item >Policy Total before tax : ${policyData.totalBeforetax}</ListGroup.Item>
                                <ListGroup.Item >Policy Start: {policyData.startDate}</ListGroup.Item>
                                <ListGroup.Item >Policy End: {policyData.endDate}</ListGroup.Item>
                                <ListGroup.Item >Customer: {policyData.user.firstName} {policyData.user.lastName}</ListGroup.Item>
                                <ListGroup.Item >Customer Address: {policyData.user.address}</ListGroup.Item>
                                <ListGroup.Item >Driver Number of Accidents: {policyData.driver.numberAccidents}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Make: {policyData.vehicle.make}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Model: {policyData.vehicle.model}</ListGroup.Item>
                                <ListGroup.Item>Vehicle Year: {policyData.vehicle.year}</ListGroup.Item>
                            </ListGroup>
                        ])
                }
            </ul>
        </>
    );
}