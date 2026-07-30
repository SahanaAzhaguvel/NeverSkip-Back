function login() {

    const user = {

        username: document.getElementById("username").value,
        password: document.getElementById("password").value

    };

    fetch("/login", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(user)

    })

    .then(response => response.json())

    .then(data => {

        if (data === true) {

            sessionStorage.setItem("loggedIn", "true");


            window.location.href = "dashboard.html";

        } else {

            alert("Invalid Username or Password");

        }

    })

    .catch(error => {

        console.log(error);
        alert("Unable to connect to server");

    });

}