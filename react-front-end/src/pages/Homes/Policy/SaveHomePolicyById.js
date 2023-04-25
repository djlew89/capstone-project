import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving home policy data by id
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function SaveHomePolicyById() {
    const [userId, setSetUserId] = useState("");
    const [homeId, setHomeId] = useState("");
    const [startDate, setStartDate] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        console.log(startDate)

        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userId}/policy/homes/${homeId}?startDate=${startDate}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Home policy saved")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Create new home policy</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>Enter the Customer ID for the new policy</Form.Label>
                    <Form.Control name='cid' type="text" placeholder="Customer ID"
                                  value={userId} onChange={(e) => setSetUserId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter the Home ID for the new policy</Form.Label>
                    <Form.Control name='hpid' type="text" placeholder="Home ID"
                                  value={homeId} onChange={(e) => setHomeId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter the Start Date of the policy</Form.Label>
                    <Form.Control name='sd' type="date" placeholder="Policy Start"
                                  value={startDate} onChange={(e) => setStartDate(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save Home Policy</Button>
            </Form>
        </>
    );
}
