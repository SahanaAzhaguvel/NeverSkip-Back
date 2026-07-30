function saveStudent() {

    const student = {

        stdId: document.getElementById("stdId").value,

        stdName: document.getElementById("stdName").value,

        className: document.getElementById("className").value,

        section: document.getElementById("section").value,

        score: document.getElementById("score").value

    };

    fetch("/school", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(student)

    })

    .then(response => {

        if(response.ok){

            alert("Student Added Successfully!");

            document.getElementById("studentForm").reset();

        }
        else{

            alert("Failed to Add Student");

        }

    })

    .catch(error => {

        console.log(error);

        alert("Server Error");

    });

}