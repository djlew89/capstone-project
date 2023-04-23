import {useState} from 'react';
import {Button, Form} from 'react-bootstrap';

export default function SaveData() {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");
    const [address, setAddress] = useState("");
    const [dob, setDOB] = useState("");
    const [fname, setFname] = useState("");
    const [lname, setLname] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        let requestOptions = {
            method: 'POST',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users?email=${email}&password=${pass}&address=${address}&dob=${dob}&fname=${fname}&lname=${lname}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        alert("User saved")
        window.location.href = '/';
    }

    return (
        <Form method="post" onSubmit={handleSubmit} id="form_display">
            <Form.Group>
                <Form.Label>Email</Form.Label>
                <Form.Control name='email' type="email" placeholder="E-Mail"
                              value={email} onChange={(e) => setEmail(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Password</Form.Label>
                <Form.Control name='password' type="text" placeholder="Password"
                              value={pass} onChange={(e) => setPass(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Address</Form.Label>
                <Form.Control name='address' type="text" placeholder="Address"
                              value={address} onChange={(e) => setAddress(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Date of Birth</Form.Label>
                <Form.Control name='dob' type="date" placeholder="DOB"
                              value={dob} onChange={(e) => setDOB(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>First Name</Form.Label>
                <Form.Control name='fname' type="text" placeholder="First Name"
                              value={fname} onChange={(e) => setFname(e.target.value)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Last Name</Form.Label>
                <Form.Control name='fname' type="text" placeholder="First Name"
                              value={lname} onChange={(e) => setLname(e.target.value)}></Form.Control>
            </Form.Group>
            <Button variant="primary" type="submit">Submit Movie Review!</Button>
        </Form>
    );
}