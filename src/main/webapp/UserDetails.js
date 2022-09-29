
//Method to get data Directly from JSON
function getData(){
    xhr = new XMLHttpRequest();
    if(xhr){
        xhr.open("GET","costs.json",true);
        xhr.send();
        xhr.onreadystatechange = function(){
                let obj = JSON.parse(xhr.responseText);
                //let htmlStr = "<h4>data Directly from JSON</h4>";
                let htmlStr = "<tr><th>City</th><th>Price</th></tr>";
                obj.forEach(o => {
                    htmlStr+="<tr> <td> "+ o.city +" </td> <td> "+ o.price+ " </td> </tr>";
                });
                document.getElementById("t1").innerHTML = htmlStr;
        }
    }
}

//Method to get data from a java servlet within server
function getDatafromservlet(){

	xhr = new XMLHttpRequest();
    if(xhr){
        xhr.open("GET","http://localhost:8080/CostDemos/controller",true);
        xhr.send();
        xhr.onreadystatechange = function(){
                let obj = JSON.parse(xhr.responseText);   
                let htmlStr = "<tr style='color:red;' ><th  >City</th><th>Price</th></tr>";
                //htmlStr += "<tr><td >data Directly from a java servlet within server</td> <td>OK</td> </tr>";
                obj.forEach(o => {
                    htmlStr+="<tr> <td> "+ o.city +" </td> <td> "+ o.price+ " </td> </tr>";
                });
                document.getElementById("t1").innerHTML = htmlStr;
        }
    }

}













function validateName() {
  let username = uname.value;
  if (username.length < 6) {
    document.getElementById("s1").innerHTML ="Name should be more than 6 chars ";
    return false;
  } else {
    document.getElementById("s1").innerHTML = "";
    return true;
  }
}

function validateCity(){
    if(city.value == null || city.value == "" ){
        document.getElementById("s2").innerHTML ="City Cannot be empty";
        return false;
    }
    else{
        document.getElementById("s2").innerHTML ="";
        return true;
    }
}
function validateDistance(){
    if( (distance.value >9) && (distance.value <61)  ){
        document.getElementById("s3").innerHTML ="";
        return true;
    }
    else{
        document.getElementById("s3").innerHTML ="Enter a numeric value bettween 10 & 60";
        return false;
    }
}

function calculateCost(){
    return parseInt(distance.value)*10;
}

function validate() {    
    // Checking by addition is done so that all three errors should appear simultaneously
    if( validateName() + validateCity() + validateDistance() == 3){ 
        document.getElementById("Summary").value = "The Cost of Journey is "+calculateCost() ;
    }
    else{
        document.getElementById("Summary").value ="";
    }
}
