package com.nik.designpatterns.observerPattern;

public interface Observer  {

	public void update(double ibmPrice,double aaplPrice, double gooGPrice);
}

class StockObserver implements Observer{

	private double ibmPrice,aaplPrice,gooGPrice;
	private static int observerTrack=0;
	private int observerId;	
	
	private Subject stockGrabber;
	
	public StockObserver(Subject stockGrabber) {
		this.stockGrabber = stockGrabber;
		this.observerId = ++ observerTrack;
		System.out.println("new observer created with id = "+this.observerId);
		stockGrabber.register(this);
	}
	
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.gooGPrice = googPrice;
		
		printThePrices();
		
	}
	
	public void printThePrices(){
		
		System.out.println(observerId + "\nIBM: " + ibmPrice + "\nAAPL: " + 
				aaplPrice + "\nGOOG: " + gooGPrice + "\n");
		
	}
	
	
}

