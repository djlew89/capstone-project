import {Button, Form} from 'react-bootstrap';
import {useState} from 'react';

/**
 * The page responsible for modying customer data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function EditDriverById() {
    const [driverId, setDriverId] = useState("");
    const [numOfAccidents, setNumOfAccidents] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        var requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/drivers/${driverId}?numOfAccidents=${numOfAccidents}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Driver Modified")
        window.location.href = '/Drivers';
    }

    return (
        <>
            <h1 id="data_display">Edit Driver Data by driver Id</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>Enter The ID of the Driver you would like to edit</Form.Label>
                    <Form.Control name='userID' type="text" placeholder="ID"
                                  value={driverId} onChange={(e) => setDriverId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Number of Accidents</Form.Label>
                    <Form.Control name='noa' type="text" placeholder="Number of accidents"
                                  value={numOfAccidents} onChange={(e) => setNumOfAccidents(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Submit Change</Button>
            </Form>
        </>
    );
}