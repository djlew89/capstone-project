import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';

//TODO I just added in the form, I don't have editing setup

export default function EditUser() {

    return (
        <>
            <h1 id="data_display">Edit User Data</h1>
            <Form method="post" action="/v1/users" id="form_display">
                <Form.Group>
                    <Form.Label>Enter The New Email Value</Form.Label>
                    <OverlayTrigger placement="right">
                        <Form.Control name='email' type="email" placeholder="Email"></Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Password Value</Form.Label>
                    <OverlayTrigger placement="right"
                                    overlay={<Tooltip id='tooltip-right'>YYYY-MM-DD</Tooltip>}>
                        <Form.Control name='pass' type="text" placeholder="Password">
                        </Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New Address Value</Form.Label>
                    <OverlayTrigger placement="right"
                                    overlay={<Tooltip id='tooltip-right'>Any Character</Tooltip>}>
                        <Form.Control name='address' type="text" placeholder="Address"></Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New DOB</Form.Label>
                    <OverlayTrigger placement="right"
                                    overlay={<Tooltip id='tooltip-right'>A date</Tooltip>}>
                        <Form.Control name='dob' type="date" placeholder="Date of Birth"></Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Enter The New First Name</Form.Label>
                    <OverlayTrigger placement="right"
                                    overlay={<Tooltip id='tooltip-right'>letters</Tooltip>}>
                        <Form.Control name='fname' type="text" pattern="^[A-Za-z]" placeholder="First Name"></Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Form.Group style={{paddingBottom: 10}}>
                    <Form.Label>Enter The New Last Name</Form.Label>
                    <OverlayTrigger placement="right"
                                    overlay={<Tooltip id='tooltip-right'>letters</Tooltip>}>
                        <Form.Control name='lname' type="text" pattern="^[A-Za-z]" placeholder="Last Name"></Form.Control>
                    </OverlayTrigger>
                </Form.Group>
                <Button variant="primary" type="submit">Submit Movie Review!</Button>
            </Form>
        </>
    );
}