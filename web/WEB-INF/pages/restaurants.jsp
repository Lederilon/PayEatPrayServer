<%@ page import="domain.Profile" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Заведения</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="WEB-INF/pages/css/index.css">
<link rel="stylesheet" type="text/css" href="WEB-INF/pages/css/restaurants.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    
  </style>
  
  	
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1>Pay Eat Pray</h1>      
    <p>Всё, что тебе нужно</p>
  </div>
</div>

<nav class="navbar navbar-inverse">

    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">PPP</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li ><a href="start.html">Домой</a></li>
        <li class="active"><a href="#">Заведения</a></li>
		<li><a href="#">О нас</a></li>
        <li><a href="#">Как заказать?</a></li>
        <li><a href="#">Контакты</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="pages/enter_registration.html"><span class="glyphicon glyphicon-user"></span> Личный кабинет</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Покупки</a></li>
      </ul>
    </div>
  
</nav>

<div class = "container">

<div class = "search_with_params">
 <form>
	<div class = "search">
	<div class = "row">
	<div class = "col-sm-2">
	</div>
	<div class = "col-sm-8">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      </div>
    </div>
	</div>
	</div>
	</div>
	
	<div class = "row">
	<div class = "col-sm-6">
	</div>
	<div class = "col-sm-2">
	<label for="sel1">Сортировать по:</label>
      <select class="form-control" id="sel1">
        <option>популярности</option>
        <option>рейтингу</option>
        <option>самые новые</option>
      </select>
	
	</div>
	
	<div class = "col-sm-2">
	<label for="sel1">Штук на странице:</label>
      <select class="form-control" id="sel1">
        <option>5</option>
        <option>10</option>
        <option>15</option>
        <option>20</option>
      </select>
	</div>
	</div>
	
	
  </form>
  </div>
  
  <div class="restaurant_list">
  
  <div class = "restaurant_item">
  <div class = "row">
  <div class = "col-sm-5">
	<div class = "restaurant_photo">
		<img src = "WEB-INF/pages/images/dominos.jpg" alt="photo" >
	</div>
  </div>
  <div class = "col-sm-7">
	<div class = "restaurant_name">
		<a href="#"><strong>Domino's Pizza</strong></a>
	</div>
	<div class = "restaurant_type">
		<p><b>Тип:</b> <span>Пиццерия</span></p>
	</div>
	<div class = "restaurant_descr">
	<p>“Domino`s Pizza” – мировая сеть пиццерий, которая преодолела длинный путь к лидерству. Начиная с 1960 года, компания не перестает увеличивать количество пиццерий по всему миру.
	Сегодня “Domino`s Pizza” уже стала мировым брендом и является компанией №1 во всем мире по доставке пиццы – заказ доставляется за 30 минут. Мировая сеть насчитывает более 12 000 
	пиццерий в 85 странах мира. Каждая пиццерия сети Доминос не только гостеприимно распахивает свои двери для посетителей и увлекает в кулинарное путешествие на дегустацию пиццы, но
	и готова привезти Вам кулинарный шедевр домой.</p>
	</div>
  </div>
  
</div>
</div>

 <div class = "restaurant_item">
  <div class = "row">
  <div class = "col-sm-5">
	<div class = "restaurant_photo">
		<img src = "WEB-INF/pages/images/maxresdefault.jpg" alt="photo" >
	</div>
  </div>
  <div class = "col-sm-7">
	<div class = "restaurant_name">
		<a href="#"><strong>McDonald's</strong></a>
	</div>
	<div class = "restaurant_type">
		<p><b>Тип:</b> <span>Ресторан быстрого питания</span></p>
	</div>
	<div class = "restaurant_descr">
	<p>“Domino`s Pizza” – мировая сеть пиццерий, которая преодолела длинный путь к лидерству. Начиная с 1960 года, компания не перестает увеличивать количество пиццерий по всему миру.
	Сегодня “Domino`s Pizza” уже стала мировым брендом и является компанией №1 во всем мире по доставке пиццы – заказ доставляется за 30 минут. Мировая сеть насчитывает более 12 000 
	пиццерий в 85 странах мира. Каждая пиццерия сети Доминос не только гостеприимно распахивает свои двери для посетителей и увлекает в кулинарное путешествие на дегустацию пиццы, но
	и готова привезти Вам кулинарный шедевр домой.</p>
	</div>
  </div>
  
</div>
</div>

 <div class = "restaurant_item">
  <div class = "row">
  <div class = "col-sm-5">
	<div class = "restaurant_photo">
		<img src = "WEB-INF/pages/images/u_ashota.jpg" alt="photo" >
	</div>
  </div>
  <div class = "col-sm-7">
	<div class = "restaurant_name">
		<a href="#"><strong>У Ашота и братух</strong></a>
	</div>
	<div class = "restaurant_type">
		<p><b>Тип:</b> <span>Лаваш в вине</span></p>
	</div>
	<div class = "restaurant_descr">
	<p>“Domino`s Pizza” – мировая сеть пиццерий, которая преодолела длинный путь к лидерству. Начиная с 1960 года, компания не перестает увеличивать количество пиццерий по всему миру.
	Сегодня “Domino`s Pizza” уже стала мировым брендом и является компанией №1 во всем мире по доставке пиццы – заказ доставляется за 30 минут. Мировая сеть насчитывает более 12 000 
	пиццерий в 85 странах мира. Каждая пиццерия сети Доминос не только гостеприимно распахивает свои двери для посетителей и увлекает в кулинарное путешествие на дегустацию пиццы, но
	и готова привезти Вам кулинарный шедевр домой.</p>
	</div>
  </div>
  
</div>
</div>

 <div class = "restaurant_item">
  <div class = "row">
  <div class = "col-sm-5">
	<div class = "restaurant_photo">
		<img src = "WEB-INF/pages/images/puzata_hata.jpg" alt="photo" >
	</div>
  </div>
  <div class = "col-sm-7">
	<div class = "restaurant_name">
		<a href="#"><strong>Пузата Хата</strong></a>
	</div>
	<div class = "restaurant_type">
		<p><b>Тип:</b> <span>Вкусная кулинария</span></p>
	</div>
	<div class = "restaurant_descr">
	<p>“Domino`s Pizza” – мировая сеть пиццерий, которая преодолела длинный путь к лидерству. Начиная с 1960 года, компания не перестает увеличивать количество пиццерий по всему миру.
	Сегодня “Domino`s Pizza” уже стала мировым брендом и является компанией №1 во всем мире по доставке пиццы – заказ доставляется за 30 минут. Мировая сеть насчитывает более 12 000 
	пиццерий в 85 странах мира. Каждая пиццерия сети Доминос не только гостеприимно распахивает свои двери для посетителей и увлекает в кулинарное путешествие на дегустацию пиццы, но
	и готова привезти Вам кулинарный шедевр домой.</p>
	</div>
  </div>
  
</div>
</div>

 <div class = "restaurant_item">
  <div class = "row">
  <div class = "col-sm-5">
	<div class = "restaurant_photo">
		<img src = "WEB-INF/pages/images/dominos.jpg" alt="photo" >
	</div>
  </div>
  <div class = "col-sm-7">
	<div class = "restaurant_name">
		<a href="#"><strong>Domino's Pizza</strong></a>
	</div>
	<div class = "restaurant_type">
		<p><b>Тип:</b> <span>Пиццерия</span></p>
	</div>
	<div class = "restaurant_descr">
	<p>“Domino`s Pizza” – мировая сеть пиццерий, которая преодолела длинный путь к лидерству. Начиная с 1960 года, компания не перестает увеличивать количество пиццерий по всему миру.
	Сегодня “Domino`s Pizza” уже стала мировым брендом и является компанией №1 во всем мире по доставке пиццы – заказ доставляется за 30 минут. Мировая сеть насчитывает более 12 000 
	пиццерий в 85 странах мира. Каждая пиццерия сети Доминос не только гостеприимно распахивает свои двери для посетителей и увлекает в кулинарное путешествие на дегустацию пиццы, но
	и готова привезти Вам кулинарный шедевр домой.</p>
	</div>
  </div>
  
</div>
</div>

</div>
    <%
        List<Profile> profiles = (List<Profile>) request.getAttribute("caterings");

        for (Profile profile :  profiles)
        {
            out.println(profile.getName()+"\n");
        }
    %>

<div class = "pages_numbers">
<ul class="pagination">
    <li class="active"><a href="#">1</a></li>
    <li ><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
  </ul>
  </div>
  </div>

  <footer>
  <div class="container-fluid bg-grey text-center">
	<h2><small>&trade;PayEatPray, 2017</small></h2>
 </div>
  </footer>
  
 

</body>
</html>
