 <%@taglib prefix ="c" uri="http://www.springframework.org/tags"%>
<%@taglib prefix ="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bella</title>
		<link href="https://fonts.googleapis.com/css?family=Niconne" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.myFunc = function() {
	$http.get("http://localhost:7072/CosmeticFrontend/SendMail")
	}
});
</script>

<c:url value="/resources/images" var="img"></c:url>
	<c:url value="/resources/css" var="css"></c:url>
	<c:url value="/resources/js" var="js"></c:url>
	
	
<!-- <base href="C:\\Users\\lakshmi\\Desktop\\Cosemtics project\\" target="_blank"/> -->
<link rel="stylesheet" type="text/css" href="${css}/style.css">

</head>
<body>
 <nav class="navbar navbar-expand-lg " id="navbar1">
<h3>Bella</h3>


 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" style=" color:#fff; ">
    <span class="navbar-toggler-icon" style="width:100%;font-family:'Playfair Display', serif;font-size=30px;"><img src="${img}/buttonnav.png" style="width:50px; margin-top:-5px;">Menu</span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent" >
  
    <ul class="navbar-nav ml-auto" >
       
      <li class="nav-item ">
      
        <a class="nav-link" href="<c:url value="/"/>" target="_self">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Brand
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="drop">
          <c1:forEach items="${Brands}" var="brand">
          <a class="dropdown-item" href="<c:url value="/display/${brand.getBrandId()}"/>" target="_self">${brand.getBrandName()}</a>
        </c1:forEach>
      	</div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="drop">
         <c1:forEach items="${Catgeories}" var="cat">
          <a class="dropdown-item" href="<c:url value="/displayProduct/${cat.getCatId()}"/>" target="_self">${cat.getCatName()}</a>
       </c1:forEach>
          </div>
      </li>
            <c1:if test="${pageContext.request.userPrincipal.name!=null}">
            <security:authorize access ="hasRole('ROLE_ADMIN')">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Admin
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="drop">
         <a class="dropdown-item" href="<c:url value="/category"/>" target="_self">Category</a>
          <a class="dropdown-item" href="<c:url value="/product"/>" target="_self">Product</a>
          <a class="dropdown-item" href="<c:url value="/supplier"/>" target="_self">Supplier</a>
          <a class="dropdown-item" href="<c:url value="/brand"/>"  target="_self">Brand</a>
            </div>
      </li>
      </security:authorize>
      </c1:if>
      <li class="nav-item" style="margin-top:9px;">
         <c1:if test="${pageContext.request.userPrincipal.name==null}">    
          <a href="<c:url value="/account"/>" >Login</a>    
           </c1:if>
           <c1:if test="${pageContext.request.userPrincipal.name!=null}">
           <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
           </c1:if>
      </li>

      <li class="nav-item">
     
        <a class="nav-link" href="<c:url value="/checkout"/>"><img src="${img}/cart1.png" id="cart">${items}</a>
         
      </li>

    </ul>

  </div>

</nav>

	<!--End of nav-->
	
	
	<div id="formbody">
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<h4 id = "user1">Welcome   &nbsp<span  style="font-size:25px;font-family: 'Niconne', cursive;">${pageContext.request.userPrincipal.name}</span>     
</h4></c1:if>
<br>
<br>
	<div class="container" id="forms" style="width:800px;">
				<h2 style="width:400px;">Select Your Payment Mode</h2>
	 		<button class="accordion">Credit card</button>
	 		<div class="panel">
	 	<br>
	 	
	 	
	 	<c:url value="/addCard" var="card1"/>
  <form:form action="${card1}" method="post" modelAttribute="card" name="myform" >
     
	 	
	 		
            <label>Enter your Credit card details :</label>
            <br>
            <br>
                  <label>Credit Card Name :
                   <form:input  type="text" id="ccname" name="name"  onchange="return valName()" path="cardHolderName"/>
         
                </label>
                <br>
                <label>Credit Card Type :
                    <select name="cctype" required>
                    	<option >--Select--</option>
                        <option >Visa</option>
                        <option >Mastercard</option>
                      
                    </select>
                </label>      <br>
                    <label>Credit Card Number :
                    <form:input  type="text" id="ccnumber" name="phoneno"  onchange="return valNum()" path="cardNum" />
                    
                    </label>      <br>
                    <label>Credit Expiry Date : Month :
                        <select name="ccexpdatemonth" required>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select> <span>Year : <select name="ccexpdateyear" required>
                    <option value="2015">2019</option>
                    <option value="2016">2020</option>
                    <option value="2017">2021</option>
                    <option value="2018">2022</option>
                    <option value="2019">2023</option>
                    <option value="2020">2024</option>
                    <option value="2021">2025</option>
                    </select></span>
						</label>      <br>
                        <label>Credit Card CVV :
                         <form:input  type="text" id="cccvv" name="cccvc"  onchange="return valcvv()" path="cardCvv" />

                        </label>      <br>
            
 
				 <center style="margin-top:20px;">
				 <c:url value="/Payment" var="pay"/>
				<a href="${pay}" id="button" onclick ="return validate()">Submit</a>
				 </center>
				          </form:form> 
				       <br>
	 		</div>
	 		     
	 		          
	 		<button class="accordion">Debit card</button>
	 		<div class="panel">
	 		<br>
	 
	 	<c:url value="/addCard" var="card1"/>
  <form:form action="${card1}" method="post" modelAttribute="card" name="myform1" >
     
	 		<br>
            <label>Enter your Debit Card Details</label>
            <br>
            <br>
             <label>Debit Card Name :
                 <form:input  type="text" id="dcname" name="name"  onchange="return valName1()" path="cardHolderName"/>
                </label><br>
                <label>Debit Card Type :
                    <select name="cctype" required>
                    	<option >--Select--</option>
                        <option >Visa</option>
                        <option >Mastercard</option>
                      
                    </select>
                </label><br>
                    <label>Debit Card Number :
                        <form:input  type="text" id="dcnumber" name="phoneno"  onchange="return valNum1()" path="cardNum" />
                    </label><br>
                    <label>Debit Expiry Date : Month :
                        <select name="ccexpdatemonth" required>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select> <span>Year : <select name="ccexpdateyear" required>
                    <option value="2015">2019</option>
                    <option value="2016">2020</option>
                    <option value="2017">2021</option>
                    <option value="2018">2022</option>
                    <option value="2019">2023</option>
                    <option value="2020">2024</option>
                    <option value="2021">2025</option>
                    </select></span>
					</label><br>
                        <label>Debit Card CVV :
                          <form:input  type="text" id="dccvv" name="cccvc"  onchange="return valcvv1()" path="cardCvv" />
                        </label><br>

	 		 
				 <center style="margin-top:20px;">
				 <c:url value="/Payment" var="pay"/>
					<a href="${pay}" id="button" onclick ="return validate1()">Submit</a>
				 </center>
				 <br>
				 </form:form> 
	 		</div>
	 		<div ng-app="myApp" ng-controller="myCtrl" >
	 		<button class="accordion" ng-click="myFunc()">Cash On Delivery</button>
	 		<div class="panel">
	 			 <br>
				 <c:url value="/Paying" var="pay"/>
	 		<form:form action="${pay}" method="post" >
	 		<label> One Time Password has been sent to your Registered Mail Id</label>
	 		<br>
	 		<input type= "text" name="payb" />
	 		<br>
	 		<input type="submit" id="button"  value="Submit Otp">
	 		</form:form>
				
 </div>
 </div>
 <script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
function valName()
{    	
    var fname = document.myform.ccname.value;
    var letters=/^[A-Za-z\s]+$/;
    if(!fname.match(letters))
    {
        alert("The Name Should Be In Alphabets Only")
    }
}
function valName1()
{    	
    var fname = document.myform1.dcname.value;
    var letters=/^[A-Za-z\s]+$/;
    if(!fname.match(letters))
    {
        alert("The Name Should Be In Alphabets Only")
    }
}
function valNum()
{    	
    var fccnumber = document.myform.ccnumber.value;
    var nums=/^[0-9]+$/;
    if(!fccnumber.match(nums))
    {
        alert("The Card Number Should Be In Numbers Only")
    }
    var n =/^\d{16}$/;
    if(!fccnumber.match(n))
    {
        alert("Enter Valid Card Number")
    }
}
function valNum1()
{    	
    var fdcnumber = document.myform1.dcnumber.value;
    var nums=/^[0-9]+$/;
    if(!fdcnumber.match(nums))
    {
        alert("The Card Number Should Be In Numbers Only")
    }
    var n =/^\d{16}$/;
    if(!fdcnumber.match(n))
    {
        alert("Enter Valid Card Number")
    }
}
function valcvv()
{    	
    var fcccvv = document.myform.cccvv.value;
    var nums=/^[0-9]+$/;
    if(!fcccvv.match(nums))
    {
        alert("The Card CVV Should Be In Numbers Only")
    }
    var n =/^\d{3}$/;
    if(!fcccvv.match(n))
    {
        alert("Enter Valid CVV")
    }
}
function valcvv1()
{    	
    var fdccvv = document.myform1.dccvv.value;
    var nums=/^[0-9]+$/;
    if(!fdccvv.match(nums))
    {
        alert("The Card CVV Should Be In Numbers Only")
    }
    var n =/^\d{3}$/;
    if(!fdccvv.match(n))
    {
        alert("Enter Valid CVV")
    }
}
function validate()
{
	
	var fname = document.myform.ccname.value;
	   var fccnumber = document.myform.ccnumber.value;
	   var fcccvv = document.myform.cccvv.value;
   
    if(fname==""||fname==null)
    {
        alert("Name Cannot be Left Blank")
        return false
    }
    if(fccnumber==""||fccnumber==null)
    {
        alert("Card Number Cannot be Left Blank")
        return false
    }
    if(fcccvv==""||fcccvv==null)
    {
        alert("CVV Number Cannot be Left Blank")
        return false
    }
   
    return true
}

function validate1()
{

	
	var fname = document.myform1.dcname.value;
	   var fccnumber = document.myform1.dcnumber.value;
	   var fcccvv = document.myform1.dccvv.value;
   
    if(fname==""||fname==null)
    {
        alert("Name Cannot be Left Blank")
        return false
    }
    if(fccnumber==""||fccnumber==null)
    {
        alert("Card Number Cannot be Left Blank")
        return false
    }
    if(fcccvv==""||fcccvv==null)
    {
        alert("CVV Number Cannot be Left Blank")
        return false
    }
   
    return true
}

</script>
 <br>
 <br>
</div>
<!-- footer -->
 
<footer style="margin-top:0px;">

<div id="left">
	<div id="inner">
		<img src="${img}/location.png">
		Commercial Street,
			Bangalore 
	</div>
	<div id="inner">
		<img src="${img}/call.png">
		1800228080
	</div>

<div id="inner">
		<img src="${img}/mail.png">
		india@bella.org
	</div>
</div>
	


	<div id="right">


	<div id="inner">
		<img src="${img}/delivery.png">
Free shipping
	</div>

	<div id="inner">
<img src="${img}/quality.png">
Assured Quality
	</div>

	<div id="inner">
<img src="${img}/time.png" style="padding-top:14px;">
On time Delivery
	</div>
</div>

<div id="link">
	<h5 style="color:#fff">Quick Links</h5>
	<ul>
		<li><a href="<c:url value="/"/>
			">Home</a></li>
			 <c1:forEach items="${Brands}" var="brand">
			<li><a href="<c:url value="/display/${brand.getBrandId()}"/> "target="_self">${brand.getBrandName()}</a></li>
			</c1:forEach>
			<c1:forEach items="${Catgeories}" var="cat">
			<li><a href="<c:url value="/displayProduct/${cat.getCatId()}"/>" target="_self">${cat.getCatName()}</a></li>
			</c1:forEach>
	</ul>
</div>
	<div id="connect">
	<span style="font-size:25px;margin-left:10px;">	Connect to us:</span>
	<a href="https://www.instagram.com/accounts/login/?hl=en" target="_blank"><img src="${img}/insta.png" id="mac" ></a>
<a href="https://www.facebook.com/" target="_blank"><img src="${img}/facebook.png"></a>
<a href="https://twitter.com/login" target="_blank"><img src="${img}/twitter.png" style="width:40px;padding-top:10px;"></a>
</div>
		
	
</footer>

</body>
</html>