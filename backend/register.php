<?php
$conn = new mysqli("localhost", "root", "", "netshield");

if ($conn->connect_error) {
    die("Error de conexión");
}

$email = $_POST['email'];
$name = $_POST['name'];
$password = password_hash($_POST['password'], PASSWORD_BCRYPT);
$age = $_POST['age'];
$gender = $_POST['gender'];

$sql = "INSERT INTO users (email, name, password, age, gender)
VALUES ('$email', '$name', '$password', '$age', '$gender')";

if ($conn->query($sql)) {
    echo "Registro exitoso";
} else {
    echo "Error: " . $conn->error;
}

$conn->close();
?>