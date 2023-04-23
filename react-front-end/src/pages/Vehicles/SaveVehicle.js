import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function SaveVehicle() {
    const [make, setMake] = useState("");
    const [model, setModel] = useState("");
    const [year, setYear] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/1/autos?make=${make}&model=${model}&year=${year}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        alert("Vehicle saved")
        window.location.href = '/';
    }

    return (
        <Form method="post" onSubmit={handleSubmit} id="form_display">
            <Form.Group>
                <Form.Label>Email</Form.Label>
                <Form.Control name='make' type="text" placeholder="E-Mail"
                              value={make} onChange={(e) => setMake(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Password</Form.Label>
                <Form.Control name='model' type="text" placeholder="Password"
                              value={model} onChange={(e) => setModel(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Address</Form.Label>
                <Form.Control name='year' type="text" placeholder="Address"
                              value={year} onChange={(e) => setYear(e.target.value)}></Form.Control>
            </Form.Group>
            <Button variant="primary" type="submit">Submit Movie Review!</Button>
        </Form>
    );
}