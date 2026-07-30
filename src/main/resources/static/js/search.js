function searchStudent(){

const id=document.getElementById("studentId").value;

fetch("/school/"+id)

.then(response=>response.json())

.then(student=>{

document.getElementById("result").innerHTML=`

<h3>Student Details</h3>

<p><b>ID :</b> ${student.stdId}</p>

<p><b>Name :</b> ${student.stdName}</p>

<p><b>Class :</b> ${student.className}</p>

<p><b>Section :</b> ${student.section}</p>

<p><b>Score :</b> ${student.score}</p>

`;

})

.catch(error=>{

console.log(error);

alert("Student Not Found");

});

}