package com.itacademy.enums;

public class Main {

	public static void main(String[] args){
		Days monday = Days.MONDAY;

	}

	public static void doSmth(Days days){
		switch(days){
			case MONDAY:
				System.out.println("Monday");
		}
	}
}
