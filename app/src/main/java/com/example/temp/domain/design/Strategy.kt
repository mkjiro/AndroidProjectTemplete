package com.example.temp.domain.design

import kotlin.random.Random

class Player(
    private val name: String,
    private val strategy: Strategy
){
    private var wincount : Int = 0
    private var losecount : Int = 0
    private var gamecount : Int = 0

    fun nextHand():Hand{
        return strategy.nextHand()
    }

    fun win(){
        strategy.study(true)
        wincount++
        gamecount++
    }

    fun lose(){
        strategy.study(false)
        losecount++
        gamecount++
    }

    fun even(){
        gamecount++
    }

    override fun toString(): String {
        return "[%s:%s games, %s win, %s lose]".format(name,gamecount,wincount,losecount)
    }
}

interface Strategy{
    fun nextHand():Hand
    fun study(win:Boolean)
}

class WinningStrategy(
):Strategy{
    var won = false
    var prevHand = Hand()
//    var random = Random(seed)

    override fun nextHand():Hand {
        return if(!won)Hand.getHand(Random.nextInt(3))
            else prevHand
    }

    override fun study(win:Boolean) {
        won = win
    }
}

class ProbStrategy():Strategy{
    var won = false
    var prevHandValue = 0
    var currentHandValue = 0

    var history = Array(3) {Array(3) {it} }

    override fun nextHand(): Hand {
        val bet = Random.nextInt(getSum(currentHandValue))
        var handvalue = 0
        if(bet < history[currentHandValue][0]){
            handvalue = 0
        }else if(bet < history[currentHandValue][0] + history[currentHandValue][1]){
            handvalue = 1
        }else{
            handvalue = 2
        }
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return  Hand.getHand(handvalue)
    }

    private fun getSum(hv:Int):Int{
        var sum = 0
        for(i in (0..2)){
            sum += history[hv][i]
        }
        return sum
    }

    override fun study(win: Boolean) {
        if(win){
            history[prevHandValue][currentHandValue]++
        }else{
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }
}

class Hand(
    private val handvalue:Int = 0,
    private val name:String = "no hand"
){

    companion object {
        private val HANDVALUE_GUU = 0
        private val HANDVALUE_CHO = 1
        private val HANDVALUE_PAA = 2

        private val hand = mutableListOf<Hand>(
            Hand(HANDVALUE_GUU,"グー"),Hand(HANDVALUE_CHO,"チョキ"),Hand(HANDVALUE_PAA,"パー")
        )

        fun getHand(handValue:Int):Hand{
            return hand[handValue]
        }
    }

    fun isStrongerThan(h:Hand):Boolean{
        return fight(h) == 1
    }

    fun isWeakerThan(h:Hand):Boolean{
        return fight(h) == -1
    }

    private fun fight(h:Hand):Int{
        return when {
            this == h -> {
                0
            }
            (this.handvalue + 1) % 3 == h.handvalue -> {
                1
            }
            else -> {
                -1
            }
        }
    }

    override fun toString():String{
        return name
    }
}