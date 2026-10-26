package org.example.project

import kotlin.math.max

class Polynome (val coef: MutableList<Double>){
    var n = coef.size - 1
    fun upgradeDegree(m:Int){
        if (m>n){
            for ( i in n+1 .. m){
                coef.add(0.0)
            }

        }
    }
    fun zeros(n:Int)=Polynome(MutableList(n+1){0.0})
    operator fun plus(polynomial: Polynome): Polynome{
        val degree = max(n, polynomial.coef.size - 1)
        this.upgradeDegree(degree)
        polynomial.upgradeDegree(degree)
        val result = zeros(degree)
        for ( i in 0 .. degree ){
            result.coef[i] = this.coef[i] + polynomial.coef[i]
        }
        return result
    }

    operator fun times(polynomial: Polynome):Polynome{
        var result=zeros(this.n+polynomial.n)
        for(i in 0 .. this.n){
            for (j in 0 .. polynomial.n){
                result.coef[i+j]+=this.coef[i]*polynomial.coef[j]
            }
        }
        return result
    }

    override fun toString():String{
        var result = ""
        for (i in 0 .. n) {
            result += coef[i].toString() + "x^"+ i + "+"

        }
        return result
    }
}