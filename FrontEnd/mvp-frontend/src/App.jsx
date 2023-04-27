import { useState } from "react";
import "./App.css";
import { BrowserRouter, Route } from "react-router-dom";
import AddUser from "../src/components/AddUser";
import UsersTable from "../src/components/UsersTable";
import NavBar from "../src/components/NavBar";

function App() {
  const [count, setCount] = useState(0);

  return (
    <BrowserRouter>
      <NavBar />
      <h1>HomePage</h1>
      <h3>Add User:</h3>

      <AddUser />
      <UsersTable />
    </BrowserRouter>
  );
}

export default App;
