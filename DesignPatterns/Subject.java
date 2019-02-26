package com.nik.designpatterns.observerPattern;

import java.util.ArrayList;

public interface Subject {

	// add observers
	public void register(Observer o);
	// del observers
	public void unregister(Observer o);
	// notify all
	public void notifyObserver();
	
}

class StockGrabber implements Subject{

	private ArrayList<Observer> observers;
	private double ibmPrice,aaplPrice,gooGPrice;
	
	public StockGrabber() {
		
		observers = new ArrayList<Observer>();
	}
	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		int observerIndex= observers.indexOf(o);
		System.out.println("Observer number"+ (observerIndex+1)+" deleted");
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
		for(Observer o:observers)
		{
			o.update(ibmPrice, aaplPrice, gooGPrice);	
		}
	}
	
	public void setIbmPrice(double ibmPrice)
	{
		this.ibmPrice=ibmPrice;
		notifyObserver();
	}
	
	
	public void setAaplPrice(double aaplPrice)
	{
		this.aaplPrice=aaplPrice;
		notifyObserver();
	}
	
	public void setGooGPrice(double gooGPrice)
	{
		this.gooGPrice=gooGPrice;
		notifyObserver();
	}
	
	
}