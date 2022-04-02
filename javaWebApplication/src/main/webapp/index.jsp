<%@ include file = "jsp/Header.jsp"%>
<body>

<div id="carouselExampleControls" class="carousel slide" 
	data-ride="carousel">
  	<div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
    </div>
    <div class="carousel-item">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
    </div>
    <div class="carousel-item">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
      	
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<h2 style="padding: 50px">Welcome to the YMCA Registration</h2>
</body>
<%@ include file = "jsp/Footer.jsp"%>
</html>
