import React, { useState } from "react";

function MyComponent() {
  const [formData, setFormData] = useState({
    userName: "",
    password: "",
    email: "",
  });

  const handleInputChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const url = "http://localhost:3396/username/add";
    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        setFormData({ userName: "", password: "", email: "" }); // Reset form data
      })
      .catch((error) => console.error(error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="userName"
        placeholder="Username"
        value={formData.userName}
        onChange={handleInputChange}
      />

      <input
        type="password"
        name="password"
        placeholder="password"
        value={formData.password}
        onChange={handleInputChange}
      />

      <input
        type="email"
        name="email"
        placeholder="email"
        value={formData.email}
        onChange={handleInputChange}
      />

      <button type="submit">Submit</button>
    </form>
  );
}

export default MyComponent;
