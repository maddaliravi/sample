package com.sg.ravee.h2;
import java.util.Scanner;
public class javaTutorial1class {
	public static void main(String[] args)
	{
		System.out.println("hello world");
		int age;
		age=27;
		System.out.println("age="+age);
		age+=3;
		System.out.println("after 3 years age="+age);
		Scanner in = new Scanner(System.in);
		System.out.println("plese enter u r age");
		age=in.nextInt();
		if(age<=20)
			System.out.println("you are young");
		else if(age>20 && age<=45)
			System.out.println("you are middle age");
		else
			System.out.println("u r old person");
		
	}
}
