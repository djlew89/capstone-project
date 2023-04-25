import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving policy data by id
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function SaveVehiclePolicyById() {
    const [userId, setSetUserId] = useState("");
    const [autoId, setAutoId] = useState("");
    const [startDate, setStartDate] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        console.log(startDate)

        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userId}/policy/autos/${autoId}?startDate=${startDate}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("User saved")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Create new vehicle policy</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>Enter the Customer ID for the new policy</Form.Label>
                    <Form.Control name='cid' type="text" placeholder="Customer ID"
                                  value={userId} onChange={(e) => setSetUserId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter the Auto ID for the new policy</Form.Label>
                    <Form.Control name='apid' type="text" placeholder="Auto ID"
                                  value={autoId} onChange={(e) => setAutoId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter the Start Date of the policy</Form.Label>
                    <Form.Control name='sd' type="date" placeholder="Policy Start"
                                  value={startDate} onChange={(e) => setStartDate(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save user</Button>
            </Form>
        </>
    );
}


