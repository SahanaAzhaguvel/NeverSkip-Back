const API = "/school/studentDetails";

window.onload = function () {
    loadStudents();
};

function loadStudents() {

    fetch(API)

        .then(response => response.json())

        .then(data => {

            const table = document.getElementById("studentTable");

            table.innerHTML = "";

            data.forEach(student => {

                table.innerHTML += `

                    <tr>

                        <td>${student.stdId}</td>

                        <td>${student.stdName}</td>

                        <td>${student.className}</td>

                        <td>${student.section}</td>

                        <td>${student.score}</td>

                        <td>

                            <button class="action-btn edit">
                                Edit
                            </button>

                            <button class="action-btn delete"
                            onclick="deleteStudent(${student.stdId})">

                                Delete

                            </button>

                        </td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.log(error);

        });

}