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


<div class="container" id="forms" style="width:800px">

 <h2 style="width:400px;">Thank You for Shopping</h2>
  <center style="margin-top:20px;">
			 <c:url value="/" var="home"/>
				<a href="${home}" id="button" >Continue Shopping</a>
				 </center></div>
				 
<br>
<br>
<br>
</div>






<!--end of main-->




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