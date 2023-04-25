import {useState} from 'react';

/**
 * The page responsible for deleting vehicle data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function DeleteVehicleById() {
    const [vehicleId, setVehicleId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/autos/${vehicleId}`, requestOptions)
            .then(response => response.text())
            .then(setVehicleId)
            .catch(error => console.log('error', error));

        alert("Vehicle deleted");
        window.location.href = "/";
    }

    return (
        <>
            <h1 id="data_display">Delete vehicle Data</h1>
            <form onSubmit={handleSubmit} id="delete_form_display">
                <label>Enter the ID of the vehicle you would like to delete:
                    <input
                        type="text"
                        value={vehicleId}
                        onChange={(e) => setVehicleId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    )
}