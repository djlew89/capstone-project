import {Button, Form} from 'react-bootstrap';
import {useState} from 'react';

export default function EditUser() {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");
    const [address, setAddress] = useState("");
    const [dob, setDob] = useState("");
    const [fName, setFname] = useState("");
    const [lName, setLname] = useState("");
    const [userID, setUserID] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        let requestOptions = {
            method: 'PUT',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/users/${userID}?email=${email}&password=${pass}&address=${address}&dob=${dob}&fname=${fName}&lname=${lName}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        alert("User Modified")
        window.location.href = '/Users';
    }

    return (
        <>
            <h1 id="data_display">Edit User Data</h1>
            <Form method="post" onSubmit={handleSubmit} id="form_display">
                <Form.Group>
                    <Form.Label>Enter The ID of the User you would like to edit</Form.Label>
                    <Form.Control name='userID' type="text" placeholder="ID"
                                  value={userID} onChange={(e) => setUserID(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Email Value</Form.Label>
                    <Form.Control name='email' type="email" placeholder="Email"
                                  value={email} onChange={(e) => setEmail(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Password Value</Form.Label>
                    <Form.Control name='pass' type="text" placeholder="Password"
                                  value={pass} onChange={(e) => setPass(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Address Value</Form.Label>
                    <Form.Control name='address' type="text" placeholder="Address"
                                  value={address} onChange={(e) => setAddress(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New DOB</Form.Label>
                    <Form.Control name='dob' type="date" placeholder="Date of Birth"
                                  value={dob} onChange={(e) => setDob(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New First Name</Form.Label>
                    <Form.Control name='fname' type="text" placeholder="First Name"
                                  value={fName} onChange={(e) => setFname(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group style={{paddingBottom: 10}}>
                    <Form.Label>Enter The New Last Name</Form.Label>
                    <Form.Control name='lname' type="text" placeholder="Last Name"
                                  value={lName} onChange={(e) => setLname(e.target.value)}></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Submit Movie Review!</Button>
            </Form>
        </>
    );
}