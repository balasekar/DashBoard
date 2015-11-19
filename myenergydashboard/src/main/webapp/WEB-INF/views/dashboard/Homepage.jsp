<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Corporate 1</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script type="text/javascript">

$(function() {
    $('#idDateField').datepicker();
});

</script>

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Logo and responsive toggle -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                	<span class="glyphicon glyphicon-fire"></span> 
                	Load Staus
                </a>
            </div>
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
                   <!--  <li>
                        <a href="#">Products</a>
                    </li>
                     <li>
                        <a href="#">Services</a>
                    </li> -->
				</ul>

				<!-- Search -->
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<div class="jumbotron feature">
		<div class="container">
			<h1><span class="glyphicon glyphicon-equalizer"></span>Load Staus Report</h1>
			<p>Daily Load status of MyEnergy</p>
		</div>
	</div>

    <!-- Content -->
    <div class="container">

        <!-- Heading -->
<!--        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Superior Collaboration
                    <small>Visualize Quality</small>
                </h1>
                <p>Proactively envisioned multimedia based expertise and cross-media growth strategies. Seamlessly visualize quality intellectual capital without superior collaboration and idea-sharing. Holistically pontificate installed base portals after maintainable products.</p>
            </div>
        </div>-->
        <!-- /.row -->

        <!-- Feature Row -->
        <div class="row">
<table style="width:100%; height:200px;"  border="1">
<tr>
<td colspan='2' style="height:50px;">
<form:form action="getLoadDetails" commandName="loadDetails" method="post">
<form:input id="idDateField" path="filedate"/>
<input id="Submit" type="submit"  value="Fetch Details" name="signin" class="login_btn"/>
</form:form>
</td>
<tr>
<!-- <td valign="top" style="width:15%; padding-top:30px;" align="center" >
<p><a href="#">Link 1</a></p>
<p><a href="#">Link 2</a></p>
<p><a href="#">Link 3</a></p>
<p><a href="#">Link 4</a></p>
<p><a href="#">Link 5</a></p>

</td> -->
<td style="width:85%;padding:30px;">

<table style="width:100%; height:200px;"  border="1">
<tr>
<th>Entity</th><th>Process Name</th><th>status</th><th>source Count</th>
<th>insert Count</th><th>update Count</th><th>delete Count</th><th>error Count</th> 
<th>target Count</th><th>start Time</th> <th>end Time</th> <th> run time</th> <th>file Date</th>
</tr>
<c:if test="${not empty processEntityList}">
<c:forEach var="i" items="${processEntityList}">
   <tr> <td><c:out value="${i.entity}"/></td> <td><c:out value="${i.processname}"/></td> 
   <td><c:out value="${i.status}"/></td><td><c:out value="${i.sourcecount}"/></td>
   <td><c:out value="${i.insertcount}"/></td><td><c:out value="${i.updatecount}"/></td>
   <td><c:out value="${i.deletecount}"/></td><td><c:out value="${i.errorcount}"/></td>
   <td><c:out value="${i.targetcount}"/></td><td><c:out value="${i.starttime}"/></td>
   <td><c:out value="${i.endtime}"/></td><td><c:out value="${i.runtime}"/></td>
   <td><c:out value="${i.filedate}"/></td>
   </tr>
</c:forEach>
</c:if>
</table>

</td>
</tr>

</table>
<br/>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
	
	<footer>
		<div class="footer-blurb">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-fire"></span> Dynamically Procrastinate</h3>
						
					</div>
					<div class="col-sm-4 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-cloud-upload"></span> Efficiently Unleash</h3>
					</div>
					<div class="col-sm-4 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-leaf"></span> Completely Synergize</h3>
					</div>
				</div>
				<!-- /.row -->	
			</div>
        </div>
        
        <div class="small-print">
        	<div class="container">
        		<p><a href="#">Privacy Policy</a> | <a href="#">Contact</a></p>
        	</div>
        </div>
	</footer>

	
    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" ></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
	<!-- IE10 viewport bug workaround -->
	<script src="<c:url value="/resources/js/ie10-viewport-bug-workaround.js" />" ></script>
	
	<!-- Placeholder Images -->
	<script src="<c:url value="/resources/js/holder.min.js" />" ></script>
	
</body>

</html>
