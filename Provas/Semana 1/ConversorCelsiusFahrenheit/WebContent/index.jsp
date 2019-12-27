<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>Conversor Celsius para Fahrenheit</title>
</head>
<body>
	<section class="corpo">
		<section class="descricao">
			<header>
				<h1>CALCULADORA DE CONVERSÃO DE TEMPERATURA</h1>
			</header>
		</section>
		
		<section class="calculadora">
			<form action="calcular" class="form">
				<fieldset>
					<legend>Calculadora Conversora</legend>
					Escolha a conversão desejada:
					<input type="radio" name="tipo" value="fahtocel" class="radio-circle">Fahrenheit para Celsius
					<input type="radio" name="tipo" value="celtofah" class="radio-circle">Celsius para Fahrenheit<br><br>
					Valor a ser Convertido:
					<input type="number" name="valor" class="campo-input"><br><br>
					<input type="submit" name="calc" value="Calcular" class="botao">
				</fieldset>
			</form>
		</section>
	</section>
</body>
</html>