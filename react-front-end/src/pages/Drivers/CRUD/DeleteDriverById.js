import {useState} from 'react';

/**
 * The page responsible for deleting driver data
 * @author Mason Seward
 * @returns {JSX.Element}
 */
export default function DeleteDriverById() {
    const [driverId, setDriverId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/drivers/${driverId}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Driver deleted");
        window.location.href = "/";

    }

    return (
        <>
            <h1 id="data_display">Delete Driver Data</h1>
            <form onSubmit={handleSubmit} id="delete_form_display">
                <label>Enter the ID of the Driver you would like to delete:
                    <input
                        type="text"
                        value={driverId}
                        onChange={(e) => setDriverId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    )
}