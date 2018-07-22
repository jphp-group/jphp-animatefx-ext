# AnimateFX for JPHP
## Установка
```
jppm add jphp-animatefx-ext
```
## Примеры
```php
// Первый вариант
$anim = new AnimationFX($animationName, $node, function(){
  var_dump('finished');
});
$anim->start();
// Второй вариант
$anim = AnimationFX::play($animationName, $node, function(){
   var_dump('finished');
});
```
## Дополнительно

[Список всех анимаций](https://github.com/Typhon0/AnimateFX/wiki/Animations)

[Расширение для DevelNext](https://github.com/jphp-group/jphp-websocket-client/releases/latest)

[Venity](https://vk.com/venity)

[DevelNext - extensions & manuals.](https://vk.com/dn_extension)

[Оригинальная библиотека](https://github.com/Typhon0/AnimateFX)