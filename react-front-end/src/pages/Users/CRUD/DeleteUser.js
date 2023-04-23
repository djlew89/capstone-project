import {useState} from 'react';

export default function DeleteUser() {
    const [id, setId] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch("http://localhost:8080/v1/users/" + id, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    }

    return (
        <>
            <h1 id="data_display">Delete User Data</h1>
            <form onSubmit={handleSubmit} id="delete_form_display">
                <label>Enter the ID of the User you would like to delete:
                    <input
                        type="text"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                    />
                </label>
                <input type="submit"/>
            </form>
        </>
    )
}