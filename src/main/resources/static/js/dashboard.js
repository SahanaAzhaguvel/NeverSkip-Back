if (sessionStorage.getItem("loggedIn") !== "true") {

    alert("Please login first.");

    window.location.href = "login.html";

}

fetch("/stats")
    .then(response => response.json())
    .then(data => {
        document.getElementById("totalStudents").innerText = data.totalStudents;
        document.getElementById("avgScore").innerText = data.avgScore + "%";
        document.getElementById("totalClasses").innerText = data.totalClasses;
    })
    .catch(error => {
        console.log(error);
    });

// Add Student
document.getElementById("addStudentBtn").onclick = function () {
    window.location.href = "add-student.html";
};

// Upload CSV
document.getElementById("uploadBtn").onclick = function () {
    window.location.href = "upload-csv.html";
};

// View Students
document.getElementById("viewBtn").onclick = function () {
    window.location.href = "students.html";
};

// Search Student
document.getElementById("searchBtn").onclick = function () {
    window.location.href = "search.html";
};
function logout() {

    sessionStorage.removeItem("loggedIn");

    alert("Logged Out Successfully");

    window.location.href = "login.html";

}