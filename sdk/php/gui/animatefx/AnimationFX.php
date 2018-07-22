<?php


namespace php\gui\animatefx;


use php\gui\UXNode;

class AnimationFX{
    /**
     * @var bool
     */
    public $resetOnFinished;
    /**
     * @var UXNode
     */
    public $node;
    /**
     * @var int
     */
    public $cycleCount;
    /**
     * @var int
     */
    public $delay;
    /**
     * @var int
     */
    public $cycleDuration;
    /**
     * @var double
     */
    public $speed;


    public function __construct(string $type, UXNode $node, ?callable $callback = null){

    }
    public function start(){

    }
    public function stop(){

    }
    public function setOnFinished(callable $callback){

    }

    /**
     * @param string $type
     * @param UXNode $node
     * @return AnimationFX
     */
    public static function play(string $type, UXNode $node, ?callable $callback = null){

    }
}