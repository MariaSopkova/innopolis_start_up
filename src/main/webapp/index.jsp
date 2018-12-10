<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Taksnet - Dog SocialNetwork</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Plugin CSS -->
  <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/creative.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
  <div class="container">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">TAKSANET</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/login">Войти</a>
        </li>
        <li class="nav-item">
          <a class="nav-link btn btn-primary text-white" href="/registration">Регистрация</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<header class="masthead text-center text-white d-flex">
  <div class="container my-auto">
    <div class="row">
      <div class="col-lg-10 mx-auto">
        <h1 class="text-uppercase">
          <strong>Невероятно крутая социальная сеть для ваших питомцев</strong>
        </h1>
        <hr>
      </div>
      <div class="col-lg-8 mx-auto">
        <p class="text-faded mb-5">Здесь вы можете найти друзей как для себя так и для ваших питомцев! Мы даем возможность найти крутых профессианалов в области дрессировки а так же возможность учавствовать в различных выставках!</p>
        <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Узнать больше</a>
      </div>
    </div>
  </div>
</header>

<section id="about" class="bg-dark dog-photo text-white">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h2 class="section-heading">В нашей социальной сети вы сможете найти</h2>
        <hr class="my-4">
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <i class="fas fa-4x fa-gem text-primary mb-3 sr-icon-1"></i>
          <h3 class="mb-3">Информацию</h3>
          <p class="text-light mb-0">Каждый владелец питомцев может поделиться своими серкретами о том как сделать жизнь своих подопечных лучше и качестввенней.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <i class="fas fa-4x fa-paper-plane text-primary mb-3 sr-icon-2"></i>
          <h3 class="mb-3">Друзей</h3>
          <p class="text-light mb-0">Есть прекрасная возможность обзавестисть новыми друзьями как для себя, так и для своих питомцев!</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <i class="fas fa-4x fa-code text-primary mb-3 sr-icon-3"></i>
          <h3 class="mb-3">Кинологов</h3>
          <p class="text-light mb-0">Хотите прокачать навыки вашего питомца? В нашей социальной сети вы найдете крутых специалистов в этой области.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <i class="fas fa-4x fa-heart text-primary mb-3 sr-icon-4"></i>
          <h3 class="mb-3">Известность</h3>
          <p class="text-light mb-0">Поделитесь радостью со всеми! Расскажите и покажите своих питомцев всему миру! Учавствуйте в выставках и других мероприятиях!</p>
        </div>
      </div>
    </div>
    <div class="row text-center">
      <div class="col tex"><a class="btn btn-primary btn-xl mt-5" href="/registration">Регистрация</a></div>
    </div>
  </div>
</section>

<section id="contact">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 mx-auto text-center">
        <h2 class="section-heading">Будем одной командой!</h2>
        <hr class="my-4">
        <p class="mb-5">Есть идеи для сотрудничества? присоединяйтесь! рассмотрим любые предложения и обязательно свяжемся с Вами в ближайшее время!</p>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4 ml-auto text-center">
        <i class="fas fa-phone fa-3x mb-3 sr-contact-1"></i>
        <p>123-456-6789</p>
      </div>
      <div class="col-lg-4 mr-auto text-center">
        <i class="fas fa-envelope fa-3x mb-3 sr-contact-2"></i>
        <p>
          <a href="mailto:your-email@your-domain.com">feedback@taksanet.ru</a>
        </p>
      </div>
    </div>
  </div>
</section>

<!-- Bootstrap core JavaScript -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
<script src="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Custom scripts for this template -->
<script src="/resources/js/creative.min.js"></script>

</body>

</html>
