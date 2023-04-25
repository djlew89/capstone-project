import {Button, Form} from 'react-bootstrap';
import Card from 'react-bootstrap/Card';
import {useState} from 'react';

/**
 * The page responsible for modying customer data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function RenewVehiclePolicyById()
{
    const [autoId, setSetAutoId] = useState("");
    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/autos/${autoId}/policy`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Policy renewed for a year")
        window.location.href = '/';
    }

    return (
        <>
            <Card id="data_display">
                <Card.Body>
                    <Card.Title>Renew Vehicle Policy?</Card.Title>
                    <Card.Subtitle>Extends policy by a year</Card.Subtitle>
                </Card.Body>
            </Card>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>Enter the Auto ID for the policy you wish to renew</Form.Label>

                    <Form.Control name='cid' type="text" placeholder="Auto ID"
                                  value={autoId} onChange={(e) => setSetAutoId(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Renew</Button>
            </Form>
        </>
    );
}