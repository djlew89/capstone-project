import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function NavigationBar() {
    return (
        <Navbar bg="dark" sticky='top' variant='dark' expand="lg">
            <Container>
                <Navbar.Brand>Taylor Insurance</Navbar.Brand>
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
                        <NavDropdown.Item href="/AssociatedVehicles">List all vehicles associated with
                            user</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/AssociatedDriver">View driver data associated with
                            user</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Homes" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Homes">View Home Data</NavDropdown.Item>
                        <NavDropdown.Item href="/editHomeData">Edit Home</NavDropdown.Item>
                        <NavDropdown.Item href="/deleteHomeData">Delete Home</NavDropdown.Item>
                        <NavDropdown.Item href="/saveHomeData">Save Home</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/GetQuote">Get Home Quote</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/listHomePolicy">View Home Policy Data</NavDropdown.Item>
                        <NavDropdown.Item href="/renewHomePolicy">Renew Home Policy</NavDropdown.Item>
                        <NavDropdown.Item href="/deleteHomePolicy">Delete Home Policy</NavDropdown.Item>
                        <NavDropdown.Item href="/saveHomePolicy">Save Home Policy</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Vehicle" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Vehicles">View Vehicle Data</NavDropdown.Item>
                        <NavDropdown.Item href="/editVehicleData">Edit Vehicle</NavDropdown.Item>
                        <NavDropdown.Item href="/deleteVehicleData">Delete Vehicle</NavDropdown.Item>
                        <NavDropdown.Item href="/SaveVehicleData">Save Vehicle</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/getVehicleQuote">Get Vehicle Quote</NavDropdown.Item>
                        <NavDropdown.Divider/>
                        <NavDropdown.Item href="/ViewVehiclePolicyData">View Vehicle Policy Data</NavDropdown.Item>
                        <NavDropdown.Item href="/EditVehiclePolicyData">Edit Vehicle Policy</NavDropdown.Item>
                        <NavDropdown.Item href="/deleteVehiclePolicyData">Delete Vehicle Policy</NavDropdown.Item>
                        <NavDropdown.Item href="/saveVehiclePolicyData">Save Vehicle Policy</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Driver" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/Drivers">View Driver Data</NavDropdown.Item>
                        <NavDropdown.Item href="/editDriverData">Edit Driver</NavDropdown.Item>
                        <NavDropdown.Item href="/deleteDriverData">Delete Driver</NavDropdown.Item>
                        <NavDropdown.Item href="/saveDriverData">Save Driver</NavDropdown.Item>
                    </NavDropdown>
                </Nav>
            </Container>
        </Navbar>
    );
}

export default NavigationBar;