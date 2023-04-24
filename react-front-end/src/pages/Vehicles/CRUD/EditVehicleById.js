import {Button, Form} from 'react-bootstrap';
import {useState} from 'react';

/**
 * The page responsible for modying customer data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function EditVehicleById() {
    const [vehicleId, setVehicleId] = useState("");
    const [make, setMake] = useState("");
    const [model, setModel] = useState("");
    const [year, setYear] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/autos/${vehicleId}?make=${make}&model=${model}&year=${year}`, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        alert("Vehicle Modified")
        window.location.href = '/Vehicles';
    }

    return (
        <>
            <h1 id="data_display">Edit vehicle Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="edit_form_display">
                <Form.Group>
                    <Form.Label>Enter The vehicle ID of the vehicle you would like to edit</Form.Label>
                    <Form.Control name='vehicleId' type="text" placeholder="Vehicle ID"
                                  value={vehicleId} onChange={(e) => setVehicleId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Make Value</Form.Label>
                    <Form.Control name='make' type="text" placeholder="Make"
                                  value={make} onChange={(e) => setMake(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Model Value</Form.Label>
                    <Form.Control name='model' type="text" placeholder="Model"
                                  value={model} onChange={(e) => setModel(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Year Value</Form.Label>
                    <Form.Control name='year' type="text" placeholder="Year"
                                  value={year} onChange={(e) => setYear(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Submit Change</Button>
            </Form>
        </>
    );
}