<%@taglib prefix ="c" uri="http://www.springframework.org/tags"%>
<%@taglib prefix ="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bella</title>
		<link href="https://fonts.googleapis.com/css?family=Niconne" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


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
         <c1:forEach items="${Categories}" var="cat">
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
	
	
	<div id="formbody1">
	<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<h4 id = "user1">Welcome   &nbsp<span  style="font-size:25px;font-family: 'Niconne', cursive;">${pageContext.request.userPrincipal.name}</span>     
</h4></c1:if>
<br/>

	<div class="container" id="forms">
<c:url value="/addPro" var="pro"/>
 <form:form action="${pro}" method="post"  modelAttribute="product" name="myform" onsubmit ="return validate()" enctype="multipart/form-data" > 

  <h2>Product Form</h2>
    <form:input class="text" type="file" id="img" value="uploadfile" path="ping" />
<h6>Product Id:</h6>
 <form:input type="text" class="text"  name="Id" path="proId" />
 <h6>Category</h6>
 <form:select path = "category.catId" class="text" id="cat1">
  <option id="opt" value="0">--Select Category--</option>
 <c1:forEach items = "${Categories}" var="cat">
 <option value = "${cat.getCatId()}">${cat.getCatName()}
</option>
 </c1:forEach>
 </form:select>
 
  <h6>Brand</h6>
 <form:select path = "brand.brandId" class="text" id="brand1">
  <option value="0">--Select Brand--</option>
 <c1:forEach items = "${Brands}" var="brand">
  <option value = "${brand.getBrandId()}">${brand.getBrandName()}
</option>
 </c1:forEach>
 </form:select>
 <h6>Supplier</h6>
 <form:select path = "supplier.supId" class="text" id="sup1">
  <option value="0">--Select Supplier--</option>
 <c1:forEach items = "${Suppliers}" var="sup">

 <option value = "${sup.getSupId()}"/>${sup.getSupName()}
 </c1:forEach>
 </form:select>
<h6>Product Name:</h6>
 <form:input type="text"  class="text" id="name" name="name" path="proName"/>
 <h6>Product Price:</h6>
 <form:input type="text" class="text" id="price" name="price" onchange="return valNum()" path="proPrice"/>
<h6>Product Quantity:</h6>
 <form:input type="text" class="text"  id="quant" name="quant" onchange="return valNum1()" path="proQuant"/>
<h6> Product Description:</h6>
 <form:textarea class="text" style="height:50; width:30" id="des"  name="des"  path="proDes"/>
 <input type="submit" id="submit">
 <input type="reset" id="cancel">
  </form:form>
  <script>
     function validate()
            {
            	
            	var fname = document.myform.name.value;
                var fprice = document.myform.price.value;
                var fquant = document.myform.quant.value;
                var fdes = document.myform.des.value;
                
                if(fname==""||fname==null)
                {
                    alert("Name Cannot be Left Blank")
                    return false
                }
                if(fquant==""||fquant==null)
                {
                    alert("Quantity Cannot be Left Blank")
                    return false
                }
                if(fprice==""||fprice==null)
                {
                    alert("Price  Cannot be Left Blank")
                    return false
                }
                if(fdes==""||fdes==null)
                {
                    alert("Description Cannot be Left Blank")
                    return false
                }
              	if(document.getElementById("cat1").value=="0")
              		{
              		alert("Select a Category")
              		return false
              		}
              	if(document.getElementById("brand1").value=="0")
          		{
          		alert("Select a Brand")
          		return false
          		}
              	if(document.getElementById("sup1").value=="0")
          		{
          		alert("Select a Supplier")
          		return false
          		}
            	if(document.getElementById("img").value=="uploadfile")
          		{
          		alert("Select an Image")
          		return false
          		}
                return true
            }
     function valNum()
     {    	
    	 var fprice = document.myform.price.value;
         var nums=/^[0-9]+$/;
         if(!fprice.match(nums))
         {
             alert("The Price Should Be In Numbers Only")
         }
     }
     function valNum1()
     {    	
    	 var fquant = document.myform.quant.value;
         var nums=/^[0-9]+$/;
         if(!fquant.match(nums))
         {
             alert("The Quantity Should Be In Numbers Only")
         }
     }
     
            </script>
  
 </div>
 <table id="table">
 <tr>
 <th>Pro Img</th>
 <th>Pro Id</th>
 <th>Pro Name</th>
 <th>Pro Price</th>
 <th>Pro Quant</th>
 <th>Pro Des</th>
 <th colspan="2">Action</th>
 </tr>
 <c1:forEach items="${Products}" var="pro">
 <tr>
 <td><img  style="width:70px;height:70px" src="<c:url value="/resources/images/${pro.getProId()}.jpg"/>"/></td>
 <td>${pro.getProId()}</td>
  <td>${pro.getProName()}</td>
  <td>${pro.getProPrice()}</td>
  <td>${pro.getProQuant()}</td>
  <td>${pro.getProDes()}</td>
 <td><a href="<c:url value="/editProduct/${pro.getProId()}"/>">Edit</a></td> 
 <td><a href="<c:url value="/deleteProduct/${pro.getProId()}"/>">Delete</a></td> 
 </tr>
 </c1:forEach>
 </table>
 <br>
</div>
<!-- footer -->
 
<footer style="margin-top:0px">

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
			<c1:forEach items="${Categories}" var="cat">
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