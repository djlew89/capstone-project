import {useState} from 'react';

/**
 * The page responsible for deleting a vehicle's policy data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function DeleteVehiclePolicyById() {
    const [autoPolicyId, setAutoPolicyId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/autos/${autoPolicyId}/policy`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Vehicle policy deleted");
        window.location.href = "/";
    }

    return (
        <>
            <h1 id="data_display">Delete Vehicle Policy</h1>
            <form onSubmit={handleSubmit} id="delete_form_display">
                <label>Enter the Auto ID of the vehicle policy you would like to delete:
                    <input
                        type="text"
                        value={autoPolicyId}
                        onChange={(e) => setAutoPolicyId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    )
}