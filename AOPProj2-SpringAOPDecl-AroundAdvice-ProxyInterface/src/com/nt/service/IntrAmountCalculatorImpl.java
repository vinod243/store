package com.nt.service;

public final  class IntrAmountCalculatorImpl implements IntrAmountCalculator {
	public final float calcIntrAmount(float pAmt,float rate,float time){
		System.out.println("target method");
		return (pAmt*rate*time)/100.0f;
	}//method
}//class
