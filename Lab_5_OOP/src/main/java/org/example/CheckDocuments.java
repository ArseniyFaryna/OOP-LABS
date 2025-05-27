package org.example;

import java.util.Scanner;

public class CheckDocuments extends ClearenceHandler {

    @Override
    protected void process(ClearenceRequest request) {

        System.out.println("Is your documents ok? ");
        Scanner scanner = new Scanner(System.in);
        String check = scanner.nextLine();
        if (check.equalsIgnoreCase("yes")) {
            request.setDocsOk();
        }
        else{
            throw new RuntimeException("Document is not ok");
        }
    }
}
