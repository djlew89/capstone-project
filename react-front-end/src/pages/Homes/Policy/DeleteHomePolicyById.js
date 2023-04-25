import React, {useState} from 'react';

/**
 * The page responsible for deleting home policy data
 * @author Dan Lewis
 * @returns {JSX.Element}
 */
export default function DeleteHomePolicyByHomeId() {
    const [homeId, setHomeId] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch(`http://localhost:8080/v1/homes/${homeId}/policy`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        alert("Home Policy deleted");
        window.location.href = "/";
    }


    return (
        <>
            <h1 id="data_display">Delete Home Policy Data</h1>
            <form onSubmit={handleSubmit} id="delete_form_display">
                <label>Enter the ID of the Home Policy you would like to delete:
                    <input
                        type="text"
                        value={homeId}
                        onChange={(e) => setHomeId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    )
}
