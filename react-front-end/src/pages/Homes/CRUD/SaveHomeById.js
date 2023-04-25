import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

/**
 * The page responsible for saving vehicles
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function SaveHomeById() {
    const [dateBuilt, setDateBuilt] = useState("");
    const [value, setValue] = useState("");
    const [heatingType, setHeatingType] = useState("");
    const [location, setLocation] = useState("");
    const [userId, setUserId] = useState("");
    const fetchQuery = `http://localhost:8080/v1/users/${userId}/homes?dateBuilt=${dateBuilt}&value=${value}&heatingType=${heatingType}&location=${location}`;

    function handleSubmit(event) {
        event.preventDefault();

        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(fetchQuery, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Home saved")
        window.location.href = '/';
    }

    return (
        <>
            <h1 id="data_display">Save Home Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="save_form_display">
                <Form.Group>
                    <Form.Label>User ID</Form.Label>
                    <Form.Control name='userId' type="text" placeholder="User ID"
                                  value={userId} onChange={(e) => setUserId(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Date Built</Form.Label>
                    <Form.Control name='dateBuilt' type="date" placeholder="Date Built"
                                  value={dateBuilt} onChange={(e) => setDateBuilt(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Value</Form.Label>
                    <Form.Control name='value' type="text" placeholder="Houses Value"
                                  value={value} onChange={(e) => setValue(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Heating Type</Form.Label>
                    <Form.Control name='ht' type="text" placeholder="Heating Type"
                                  value={heatingType} onChange={(e) => setHeatingType(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Location</Form.Label>
                    <Form.Control name='location' type="text" placeholder="Location"
                                  value={location} onChange={(e) => setLocation(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Save Vehicle</Button>
            </Form>
        </>
    );
}