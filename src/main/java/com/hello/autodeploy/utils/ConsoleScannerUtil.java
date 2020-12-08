package com.hello.autodeploy.utils;

import java.util.Scanner;

public class ConsoleScannerUtil {
    public static String getConsoleInput(){
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();
        inputScanner.close();
        return input;
    }
}
