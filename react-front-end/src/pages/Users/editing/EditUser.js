import { Button, Form } from 'react-bootstrap';

//TODO I just added in the form, I don't have editing setup

export default function EditUser() {

    return (
        <>
            <h1 id="data_display">Edit User Data</h1>
            <Form method="post" action="/v1/users" id="form_display">
                <Form.Group>
                    <Form.Label>Enter The New Email Value</Form.Label>
                    <Form.Control name='email' type="email" placeholder="Email"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Password Value</Form.Label>
                    <Form.Control name='pass' type="text" placeholder="Password"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Address Value</Form.Label>
                    <Form.Control name='address' type="text" placeholder="Address"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New DOB</Form.Label>
                    <Form.Control name='dob' type="date" placeholder="Date of Birth"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New First Name</Form.Label>
                    <Form.Control name='fname' type="text" pattern="^[A-Za-z]" placeholder="First Name"></Form.Control>
                </Form.Group>
                <Form.Group style={{paddingBottom: 10}}>
                    <Form.Label>Enter The New Last Name</Form.Label>
                    <Form.Control name='lname' type="text" pattern="^[A-Za-z]" placeholder="Last Name"></Form.Control>
                </Form.Group>
                <Button variant="primary" type="submit">Submit Movie Review!</Button>
            </Form>
        </>
    );
}