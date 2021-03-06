
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import Google Icon Font-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<title>Edit File</title>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

	<nav class="green darken-4">
		<div class="nav-wrapper container ">
			<a id="logo-container" href="#" class="brand-logo">Registration</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="test.html">New Form</a></li>
				<li><a href="find?id=all">Record</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br />
	<br />
	<div class="container">

		<div class="row">
			<form name="RegisterForm" method="POST" action="update"
				enctype="multipart/form-data">
				<div class="col s6">
					<label for="id">ID </label> <input disabled type="text" name="id"
						value="${student.id}" /> <br /> <input id="id" type="hidden"
						name="id" value="${student.id}" /> <br /> <label for="f_name">First
						Name </label> <input id="f_name" type="text" name="firstname"
						value="${student.firstName}" /> <br /> <br /> <label
						for="m_name">Middle Name </label> <input id="m_name" type="text"
						name="middlename" value="${student.middleName }" /> <br /> <br />
					<label for="s_name">Surname </label> <input id="s_name" type="text"
						name="surname" value="${student.surName}" /> <br /> <br /> <label
						for="addr">Address </label> <input id="addr" type="text"
						name="address" value="${student.address }" /> <br /> <br /> <label
						for="phn">Phone </label><input id="phn" type="text" name="phone"
						value="${student.phone}" /> <br /> <br /> <label for="eml">Email
					</label><input id="eml" type="email" name="email" value="${student.email }" />
					 <br /> <br />
				</div>
				<div class="col s6 center-align">
					<div class="row">
						<div class="col offset-s3">
							<div class="file-field input-field">
								<div class="btn">
									<span>File</span> <input type="file" name="photo"
										accept="image/*" onchange="loadFile(event)">
								</div>
								<div class="file-path-wrapper">
									<input class="file-path validate" type="text" required>
								</div>
							</div>
						</div>
						<img id="output" class="circle responsive-img"
							src="data:image/jpg;base64,${base64Image}" />


					</div>
				</div>
				<br /> <br />
				<div class="col s12 center-align">
					<button class="btn green darken-4 waves-effect waves-light"
						type="submit" value="Register" name="action">
						Update <i class="material-icons right">send</i>
					</button>
				</div>

			</form>
		</div>
	</div>



	<!--JavaScript at end of body for optimized loading-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script>
  var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.width=300;
    output.height=300;
    output.onload = function() {
      URL.revokeObjectURL(output.src) // free memory
    }
  };
</script>


</body>
</html>

