<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.col, .col-1, .col-10, .col-11, .col-12, .col-2, .col-3, .col-4, .col-5,
	.col-6, .col-7, .col-8, .col-9, .col-auto, .col-lg, .col-lg-1,
	.col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4,
	.col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-auto,
	.col-md, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2,
	.col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8,
	.col-md-9, .col-md-auto, .col-sm, .col-sm-1, .col-sm-10, .col-sm-11,
	.col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6,
	.col-sm-7, .col-sm-8, .col-sm-9, .col-sm-auto, .col-xl, .col-xl-1,
	.col-xl-10, .col-xl-11, .col-xl-12, .col-xl-2, .col-xl-3, .col-xl-4,
	.col-xl-5, .col-xl-6, .col-xl-7, .col-xl-8, .col-xl-9, .col-xl-auto {
	position: relative;
	width: 100%;
	padding-right: 0px;
	padding-left: 0px;
}

b, strong {
	font-weight: 500;
}

.col-sm-6 {
	padding-left: 10px;
}

.gameTitle {
	text-align: center;
	color: #13a77e;
}

.card {
	/* border-color:red ; */
	
}

.card-header {
	padding: .75rem 1.25rem;
	margin-bottom: 0;
	background-color: #17a2b863 !important;
	border-bottom: 1px solid rgba(0, 0, 0, .125);
}

.Player {
	background-color: #0e9fe4a6 !important;
}

.game {
	color: red;
}

.gameStartCard {
	text-align: center;
	height: 152px;
	width: 112px;
}

.cardExcess {
	height: 195px;
	width: 206px;
}
.borderColorP1{
border: 3px solid red;
}
.borderColorP2{
border: 3px solid yellow;
}
.statBorder{
border: 3px solid yellow;
}


</style>
<script>

var player1Score;
var player2Score;
$(document).ready(function(){
    $('input').prop('readonly',true);
    $('#gameStartHost').removeAttr('disabled');
    $('#btn1').attr('disabled','disabled');
    $('#btn2').attr('disabled','disabled');
 let player1;
 let player2;
  
  $('#gameStartHost').on('click',function() {
	     
	  $.ajax({
		    type: "GET",
		    url:"http://localhost:5050/startGame",
		    dataType:"json",
		    contentType: "application/json",
		    crossDomain: true,
		    success: function (response) {
		       let gameStartData=response;
		       console.log(gameStartData);
		     
		       player1Score=gameStartData.palyer1;
		       player2Score=gameStartData.palyer2;
		       $('#p1Amount').val(player1Score);
		      $('#0').addClass('statBorder');
		       $('#p2Amount').val(player2Score);
		       $('#btn1').removeAttr('disabled');
		       $('#btn2').removeAttr('disabled');
		       $('#gameStartHost').attr('disabled','disabled');
		    },
		      error: function (xhr, status, error) {
		                alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
		            }
		    });  
  
  }); 
  
  $('#reStartGame').on('click',function() {
	     
	  $.ajax({
		    type: "GET",
		    url:"http://localhost:5050/reStartGame",
		    dataType:"json",
		    contentType: "application/json",
		    crossDomain: true,
		    success: function (response) {
		       let gameStartData=response;
		       console.log(gameStartData);
		       $('#0').addClass('statBorder');
		       $('#p1Amount').val(gameStartData.palyer1);
		       $('#p2Amount').val(gameStartData.palyer2);
		       $('#btn1').removeAttr('disabled');
		       $('#btn2').removeAttr('disabled');
		       $('#gameStartHost').removeAttr('disabled');
		    }, 
		      error: function (xhr, status, error) {
		                alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
		            }
		    });  
	  
  
  }); 
  $('#btn1').on('click',function() {
      
    	  $.ajax({
    		    type: "GET",
    		    url:"http://localhost:5050/rollDice",
    		    dataType:"json",
    		    contentType: "application/json",
    		    crossDomain: true,
    		    success: function (response) {
    		       let data=response;
    		      let p=1;
    		      console.log(data);
    		    
    		       $('#diceP1').html(data);
    		       const p1Dice=  $('#diceP1').val();
    		       showScore(data,p);
    		       $('#btn1').attr('disabled','disabled');
    		       $('#btn2').removeAttr('disabled');
    		    },
    		      error: function (xhr, status, error) {
    		                alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
    		            }
    		    });  
    	  
    	});
  $('#btn2').on('click',function() {
      
	  $.ajax({
		    type: "GET",
		    url:"http://localhost:5050/rollDice",
		    dataType:"json",
		    contentType: "application/json",
		    crossDomain: true,
		    success: function (response) {
		       let data=response;
		       let player2= 2;
		       showScore(data,player2);
		      console.log(data);
		       $('#diceP2').html(data);
		       $('#btn2').attr('disabled','disabled');
		       $('#btn1').removeAttr('disabled');
		      
		    },
		      error: function (xhr, status, error) {
		                alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
		            }
		    });  
	  
	});
});
    
    function showScore(e,p){

    	
    	let dice=e;
    	let player = p;
    	
    	
    	const finalUrl ="http://localhost:5050/moneyOpertaion/"+dice+"/"+player;
  	  $.ajax({
		    type: "GET",
		    url:finalUrl,
		    dataType:"json",
		    contentType: "application/json",
		    crossDomain: true,
		    success: function (response) {
		       let data=response;
		      
		     console.log(data)
		     let index =data.index;
		     //index=1;
		     debugger;
		     if(player == 1){
		    	
		    	 let price =data.price;
		    	 let a =player1Score;
		    	
		    	 player1Score=player1Score-data.price;
		    	  $('#p1Amount').val(player1Score);
		    	   $('.card').removeClass('statBorder');
		    	   $('.card').removeClass('borderColorP1');
		    	   $('.card').removeClass('borderColorP2');
		    	  
             $('#'+index).addClass('borderColorP1');
             if(player1Score === 0){
            	 alert('Game Over');
            	  $('#btn1').attr('disabled','disabled');
            	  $('#btn2').attr('disabled','disabled');
             }
		     }
		     else{
		    	 player2Score=player2Score-data.price;
		    	  $('#p2Amount').val(player2Score);
		    	 
		    	   $('.card').removeClass('borderColorP1');
		    	   $('.card').removeClass('borderColorP2');
		    	  $('#'+index).addClass('borderColorP2');
		    	  if(player2Score === 0){
		            	 alert('Game Over');
		            	  $('#btn1').attr('disabled','disabled');
		            	  $('#btn2').attr('disabled','disabled');
		             }
		     }
		    },
		      error: function (xhr, status, error) {
		                alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
		            }
		    });  
	  

    }
    function startGame(){

    }
    function reStartGame(){
        
    }
</script>

</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-sm-3">
				<div class="card" id="6">
					<div class="card-header">
						<h4>Break</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>No Charges</h6>
								
							</div>
							<div class="col-sm-6">
								
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="5">
					<div class="card-header">
						<h4>Whitechapel Road</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 60</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 30</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="4">
					<div class="card-header" >
						<h4>King's Cross station</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 200</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 100</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="2">
					<div class="card-header">
						<h4>The Angel Islington</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong> $ 100 </strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 50</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3">
				<div class="card" id="7">
					<div class="card-header">
						<h4>Euston Road</h4>
					</div>
					<div class="card-body cardExcess">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 100 </strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 50</strong>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<h1 class="gameTitle">MONOPOLY</h1>
				<div class="container">
					<div class="row">
						<div class="col-sm-5">
							<div class="card">
								<div class="card-header Player">
									<h6>Player 1</h6>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-xs-4">
											<button class="btn btn-success" id="btn1">Roll Dice</button>
											<br>
										</div>
										<div class="col-xs-2">
											<div style="height: 20px; width: 20px;"></div>
										</div>
										<div class="col-xs-4">
											<div class="card" style="height: 40px; width: 40px;">
												<h4 id="diceP1" style="text-align: center;"></h4>
											</div>
										</div>
									</div>
									<label>Amount</label> <input class="form-control" id="p1Amount">
									<!-- <img alt="Dice"src="https://freepngimg.com/thumb/dice/3-2-dice-png.png" height="60px;"width="60px;"> -->
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<div class="card">
								<div class="card-header Player">
									<h6>Player 2</h6>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-xs-4">
											<button class="btn btn-success" id="btn2">Roll Dice</button>
											<br>
										</div>
										<div class="col-xs-2">
											<div style="height: 20px; width: 20px;"></div>
										</div>
										<div class="col-xs-4">
											<div class="card" style="height: 40px; width: 40px;">
												<h4 id="diceP2" style="text-align: center;"></h4>
											</div>
										</div>
									</div>
									<label>Amount</label> <input class="form-control" id="p2Amount">

									<!-- <img alt="Dice"src="https://freepngimg.com/thumb/dice/3-2-dice-png.png" height="60px;"width="60px;"> -->
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="2">
					<div class="card-header">
						<h4>Pentonville Road</h4>
					</div>
					<div class="card-body cardExcess">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 120</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 60</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="card" id="8">
					<div class="card-header">
						<h4>Pall Mall</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 140</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 30</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-6"></div>
			<div class="col-sm-3">
				<div class="card" id="1">
					<div class="card-header">
						<h4>Old Kent Road</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 60</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 30</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="card" id="9">
					<div class="card-header">
						<h4>Whitehall</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 140</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 70</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="10">
					<div class="card-header">
						<h4>Northumberland</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 160</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 80</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="11">
					<div class="card-header">
						<h4>Marylebone station</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<h6>Price</h6>
								<strong>$ 200</strong>
							</div>
							<div class="col-sm-6">
								<h6>Rent</h6>
								<strong>$ 100</strong>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" id="0">
					<div class="card-body">
						<div class="card-body gameStartCard">
							<div class="row">
								<div class="col-xs-3">
									<h6 class="game">Game Start Here</h6>
								</div>
								<div class="col-xs-3">
									<button class="btn btn-success" id="gameStartHost">Start</button>
									<button class="btn btn-danger" id="reStartGame">Restart</button>
								</div>
								<div class="col-xs-4"></div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>