<?php

/*
Our "config.inc.php" file connects to database every time we include or require
it within a php script.  Since we want this script to add a new user to our db,
we will be talking with our database, and therefore,
let's require the connection to happen:
*/
//require("config.inc.php");
$con=mysql_connect("localhost","root","");
mysql_select_db("pizzastreet");
	
	
//$con=mysqli_connect("example.com","peter","abc123","my_db");


/*
$sql="INSERT INTO `orders` (`Order`) VALUES ('dsds')";

if (!mysql_query($sql))
  {
  die('Error: ' . mysql_error($con));
  }
echo "1 record added";

mysql_close($con);
*/

	$i=1;
	$data=mysql_query("select * from orders");
    while($e=mysql_fetch_assoc($data))
            {
			//$output[]=$e;
			
			echo ($i . "-ORDER " . $e['Order'] . " Name-" . $e['name'] . " Email-" . $e['email'] . " Address-" . $e['address'] . "</br>");
			$i++;
			}
	


//if posted data is not empty
if (!empty($_POST)) {
    //If the username or password is empty when the user submits
    //the form, the page will die.
    //Using die isn't a very good practice, you may want to look into
    //displaying an error message within the form instead.  
    //We could also do front-end form validation from within our Android App,
    //but it is good to have a have the back-end code do a double check.
    if (empty($_POST['order']) || empty($_POST['name'])) {
        
        
        // Create some data that will be the JSON response 
        $response["success"] = 0;
        $response["message"] = "Please Enter Both a Username and Password.";
        
        //die will kill the page and not execute any code below, it will also
        //display the parameter... in this case the JSON data our Android
        //app will parse
        die(json_encode($response));
    }
    
    
    
    //If we have made it here without dying, then we are in the clear to 
    //create a new user.  Let's setup our new query to create a user.  
    //Again, to protect against sql injects, user tokens such as :user and :pass
    
	$order=$_POST['order'];
	$name=$_POST['name'];
	$email=$_POST['email'];
	$phone=$_POST['phone'];
	$address=$_POST['address'];
	mysql_query("INSERT INTO `orders` ( `Order`,`name`,`email`, `address`, `phone` ) VALUES ( '$order','$name', '$email', '$address', '$phone') ");
    
	
    
    //time to run our query, and create the user
/*   
   try {
		//$query = "INSERT INTO orders ( Order ) VALUES ( :user) ";
		 //   $query_params = array(
     //   ':user' => $_POST['username']
   // );

     //   $stmt   = $db->prepare($query);
       // $result = $stmt->execute($query_params);
		//$myusername=$_POST['username'];
		
		//mysql_query("INSERT INTO 'orders' ( 'Order' ) VALUES ( '$myusername') ");
    
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one:
        $response["success"] = 0;
        //$response["message"] = "Database Error2. Please Try Again!";
        $response["message"]=$_POST['username'];
		die(json_encode($response));
    }
    
  */
  //If we have made it this far without dying, we have successfully added
    //a new user to our database.  We could do a few things here, such as 
    //redirect to the login page.  Instead we are going to echo out some
    //json data that will be read by the Android application, which will login
    //the user (or redirect to a different activity, I'm not sure yet..)
    $response["success"] = 1;
    $response["message"] = "Username Successfully Added!";
    echo json_encode($response);
    
    //for a php webservice you could do a simple redirect and die.
    //header("Location: login.php"); 
    //die("Redirecting to login.php");
    
} else {
?>
	
	<?php
}

?>
