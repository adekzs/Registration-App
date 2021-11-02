<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import Google Icon Font-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/styl.css"
	media="screen,projection" />
<title>Edit File</title>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col m6 offset-m6 center-align">

				
				<form class="center-screen" method="POST" action="login">
					<h5 class="red-text darken-4">${message}</h5>
					<div class="row">
						<div class="input-field col s12">
							<input id="user_name" type="text" name="username"
								class="validate"> <label for="user_name">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="password" type="password" name="password"
								class="validate"> <label for="password">Password</label>
						</div>
					</div>


					<button class="btn green darken-4 waves-effect waves-light"
						type="submit" value="Register" name="action">Login</button>
				</form>
			</div>
		</div>
	</div>
	<br />
	<br />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
