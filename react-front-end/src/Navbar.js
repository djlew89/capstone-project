import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function NavigationBar() {
    return (
        <Navbar bg="dark" sticky='top' variant='dark' expand="lg">
            <Container>
                <Navbar.Brand>Taylors Insurance API Demo</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Nav className="me-auto">
                    <Nav.Link href="/">Home</Nav.Link>

                    <NavDropdown title="Customers" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Users">View Data</NavDropdown.Item>
                        <NavDropdown.Item href="/EditUserData">Edit Data</NavDropdown.Item>
                        <NavDropdown.Item href="/DeleteUserData">Delete Data</NavDropdown.Item>
                        <NavDropdown.Item href="/SaveUserData">Save User</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/AssociatedHomes">List all homes associated with user</NavDropdown.Item>
                        <NavDropdown.Item href="/AssociatedVehicle">List all vehicles associated with
                            user</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/AssociatedDriver">View driver data associated with
                            user</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Homes" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Homes">View Home Data</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">Edit Home</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">Delete Home</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">Save Home</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="#action/3.3">Get Home Quote</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Vehicle" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Vehicles">View Vehicle Data</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">Edit Vehicle</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">Delete Vehicle</NavDropdown.Item>
                        <NavDropdown.Item href="/SaveVehicleData">Save Vehicle</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Driver" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Drivers">View Driver Data</NavDropdown.Item>
                        <NavDropdown.Item href="/EditDriver">Edit Driver</NavDropdown.Item>
                        <NavDropdown.Item href="/DeleteDriver">Delete Driver</NavDropdown.Item>
                        <NavDropdown.Item href="/SaveDriver">Save Driver</NavDropdown.Item>
                    </NavDropdown>
                </Nav>
            </Container>
        </Navbar>
    );
}

export default NavigationBar;