import {Button, Form} from 'react-bootstrap';
import {useState} from 'react';

/**
 * The page responsible for modying customer data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function EditHomeById() {
    const [homeId, setHomeId] = useState("");
    const [dateBuilt, setDateBuilt] = useState("");
    const [houseValue, setHouseValue] = useState("");
    const [heatingType, setHeatingType] = useState("");
    const [location, setLocation] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/homes/${homeId}?dateBuilt=${dateBuilt}&value=${houseValue}&heatingType=${heatingType}&location=${location}`, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Driver Modified")
        window.location.href = '/Drivers';
    }

    return (
        <>
            <h1 id="data_display">Edit Home Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="save_form_display">
                <Form.Group>
                    <Form.Label>Enter Home ID</Form.Label>
                    <Form.Control name='userId' type="text" placeholder="User ID"
                                  value={homeId} onChange={(e) => setHomeId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter new Date Built</Form.Label>
                    <Form.Control name='dateBuilt' type="date" placeholder="Date Built"
                                  value={dateBuilt} onChange={(e) => setDateBuilt(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter new House Value</Form.Label>
                    <Form.Control name='value' type="text" placeholder="Houses Value"
                                  value={houseValue} onChange={(e) => setHouseValue(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter new Heating Type</Form.Label>
                    <Form.Control name='ht' type="text" placeholder="Heating Type"
                                  value={heatingType} onChange={(e) => setHeatingType(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter new Location</Form.Label>
                    <Form.Control name='location' type="text" placeholder="Location"
                                  value={location} onChange={(e) => setLocation(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save Home</Button>
            </Form>
        </>
    );
}