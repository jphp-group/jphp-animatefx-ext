# AnimationFX

- **class** `AnimationFX` (`php\gui\animatefx\AnimationFX`)
- **source** `php/gui/animatefx/AnimationFX.php`

---

#### Properties

- `->`[`resetOnFinished`](#prop-resetonfinished) : `bool`
- `->`[`node`](#prop-node) : `UXNode`
- `->`[`cycleCount`](#prop-cyclecount) : `int`
- `->`[`delay`](#prop-delay) : `int`
- `->`[`cycleDuration`](#prop-cycleduration) : `int`
- `->`[`speed`](#prop-speed) : `double`

---

#### Static Methods

- `AnimationFX ::`[`play()`](#method-play)

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`start()`](#method-start)
- `->`[`stop()`](#method-stop)
- `->`[`setOnFinished()`](#method-setonfinished)

---
# Static Methods

<a name="method-play"></a>

### play()
```php
AnimationFX::play(string $type, php\gui\UXNode $node, [ callable $callback): AnimationFX
```

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(string $type, php\gui\UXNode $node, [ callable $callback): void
```

---

<a name="method-start"></a>

### start()
```php
start(): void
```

---

<a name="method-stop"></a>

### stop()
```php
stop(): void
```

---

<a name="method-setonfinished"></a>

### setOnFinished()
```php
setOnFinished(callable $callback): void
```