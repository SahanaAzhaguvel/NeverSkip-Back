function uploadCSV(){

const file=document.getElementById("csvFile").files[0];

if(!file){

alert("Please Select CSV File");

return;

}

const formData=new FormData();

formData.append("file",file);

fetch("/upload/csv",{

method:"POST",

body:formData

})

.then(response=>{

if(response.ok){

alert("CSV Uploaded Successfully");

}
else{

alert("Upload Failed");

}

})

.catch(error=>{

console.log(error);

});

}