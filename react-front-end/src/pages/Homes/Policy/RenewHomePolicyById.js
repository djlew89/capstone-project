import {Button, Form} from 'react-bootstrap';
import { useState } from "react";

/**
 * The page responsible for modying home policy data
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function RenewHomePolicyById() {
    const [homeId, setHomeId] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/homes/${homeId}/policy`, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Updated Home Policy")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Renew Home Policy</h1>
            <Form method="post" onSubmit={handleSubmit} id="save_form_display">
                <Form.Group>
                    <Form.Label>Enter Home ID</Form.Label>
                    <Form.Control name='userId' type="text" placeholder="Home ID"
                                  value={homeId} onChange={(e) => setHomeId(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Renew</Button>
            </Form>
        </>
    );
}
