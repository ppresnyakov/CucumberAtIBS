#language:ru
Функционал: Яндекс маркет
  Сценарий: Поиск товара(телевизор) с применением фильтра

    Когда перешел на сайт 'https://yandex.ru/'
    Тогда заголовок главной страницы -  'Яндекс'

    Когда нажат сервис - 'Маркет'
    Тогда заголовок страницы маркета -  'Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов'

    Когда нажат каталог - 'Электроника'
    Тогда заголовок страницы каталога электроника -  'Электроника — купить на Яндекс.Маркете'

    Когда нажат элемент каталога - 'Телевизоры'
    Тогда заголовок страницы каталога телевизоров содержит -  'Телевизоры — купить на Яндекс.Маркете'

    Когда  установлен ценовой диапозон -  'Цена от','20000'
    И выбран производитель 'Samsung'
    И выбран производитель 'LG'
    Тогда товаров >= '12'
    
    Когда выполнен поиск товара под номером '0'
    Тогда название товара в списке под номером '0' не изменился