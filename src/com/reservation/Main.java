package com.reservation;

import java.io.*;

import com.reservation.console.CLI;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		try {
			CLI.CLIrun();
		} catch(IOException e) {
			System.out.println("IOE: " + e);
		}
	}
}
