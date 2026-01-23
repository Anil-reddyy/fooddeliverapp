import { useState } from "react";
import api from "./api";

function App() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [response, setResponse] = useState("");

    const register = async () => {
        try {
            const res = await api.post("/auth/register", {
                email,
                password
            });
            setResponse(res.data);
        } catch (err) {
            setResponse(err.response?.data || "Error");
        }
    };

    const login = async () => {
        try {
            const res = await api.post("/auth/login", {
                email,
                password
            });
            setResponse(res.data);
        } catch (err) {
            setResponse(err.response?.data || "Error");
        }
    };

    return (
        <div style={{ padding: "30px", fontFamily: "Arial" }}>
            <h2>Auth Service Test UI</h2>

            <input
                type="text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <br /><br />

            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <br /><br />

            <button onClick={register}>Register</button>
            <button onClick={login} style={{ marginLeft: "10px" }}>
                Login
            </button>

            <div style={{ marginTop: "20px" }}>
                <h4>Response</h4>
                <pre>{JSON.stringify(response, null, 2)}</pre>
            </div>
        </div>
    );
}

export default App;
