import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function SaveVehicleData() {
    const [make, setMake] = useState("");
    const [model, setModel] = useState("");
    const [year, setYear] = useState("");
    const [userId, setUserId] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userId}/autos?make=${make}&model=${model}&year=${year}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        alert("Vehicle saved")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Save Vehicle Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>User ID</Form.Label>
                    <Form.Control name='make' type="text" placeholder="User ID"
                                  value={userId} onChange={(e) => setUserId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Vehicle Make</Form.Label>
                    <Form.Control name='make' type="text" placeholder="Make"
                                  value={make} onChange={(e) => setMake(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Vehicle Model</Form.Label>
                    <Form.Control name='model' type="text" placeholder="Model"
                                  value={model} onChange={(e) => setModel(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Vehicle Year</Form.Label>
                    <Form.Control name='year' type="text" placeholder="Year"
                                  value={year} onChange={(e) => setYear(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save Vehicle</Button>
            </Form>
        </>
    );
}