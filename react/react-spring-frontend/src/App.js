import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import axios from "axios";

function App() {
  const [result, setResult] = useState(0);
  const [inputA, setInputA] = useState("");
  const [inputB, setInputB] = useState("");

  const getResult = () => {
    axios
      .post("http://localhost:8080/api/add", {
        a: inputA,
        b: inputB,
      })
      .then((response) => {
        setResult(response.data);
      })
      .catch((error) => console.log(error));
  };

  return (
    <div
      style={{
        border: "2px solid black",
        display: "flex",
        width: "100%",
        height: "100vh",
        background: "red",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div
        style={{
          backgroundColor: "black",
          padding: 10,
          boxShadow: "0px 0px 10px 5px white",
          width: 300,
          height: 500,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "space-evenly",
        }}
      >
        <span style={{ fontSize: 50, color: "white" }}> {result} </span>
        <input
          onChange={(e) => setInputA(e.target.value)}
          type="text"
          name="a"
          placeholder="Enter first number to add"
          value={inputA}
        />
        <input
          onChange={(e) => setInputB(e.target.value)}
          type="text"
          name="b"
          placeholder="Enter second number to add"
          value={inputB}
        />
        <button onClick={getResult}> Add </button>
      </div>
    </div>
  );
}

export default App;
