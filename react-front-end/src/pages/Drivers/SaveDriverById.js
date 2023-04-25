import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function SaveDriverById() {
    const [numberOfAccidents, setNumberOfAccidents] = useState("");
    const [userId, setUserId] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userId}/drivers?numOfAccidents=${numberOfAccidents}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Driver saved")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Save Driver Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>User ID</Form.Label>
                    <Form.Control name='userId' type="text" placeholder="User ID"
                                  value={userId} onChange={(e) => setUserId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Number of Accidents</Form.Label>
                    <Form.Control name='noa' type="text" placeholder="Number of Accidents"
                                  value={numberOfAccidents} onChange={(e) => setNumberOfAccidents(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save Driver</Button>
            </Form>
        </>
    );
}