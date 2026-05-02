<?php
$conn = new mysqli("localhost", "root", "", "netshield");

if ($conn->connect_error) {
    die("Error de conexión");
}

$email = $_POST['email'];
$password = $_POST['password'];

$sql = "SELECT * FROM users WHERE email='$email'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {

    $row = $result->fetch_assoc();

    if (password_verify($password, $row['password'])) {
        echo "Bienvenido|" . $row['name'];
    } else {
        echo "Contraseña incorrecta";
    }

} else {
    echo "Usuario no existe";
}

$conn->close();
?>