package org.library.task.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    private final List<Integer> availableBooks = new LinkedList<>();
    private final List<Integer> borrowedBooks = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);

    public LibraryManagement() {
        availableBooks.addAll(
                List.of(101, 102, 103, 104, 105, 106)
        );
    }

    public void start() {
        while (true) {
            System.out.println("""
                    
                    1- Print Borrowed Books
                    2- Print Current Books
                    3- Borrow Book
                    4- Return Book
                    5- Exit
                    """);

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printBorrowedBooks();
                case 2 -> printCurrentBooks();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> {
                    System.out.println("Good Bye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }

        System.out.println("Borrowed Books: " + borrowedBooks);
    }

    private void printCurrentBooks() {
        if (availableBooks.isEmpty()) {
            System.out.println("No available books.");
            return;
        }

        System.out.println("Current Books: " + availableBooks);
    }

    private void borrowBook() {
        if (availableBooks.isEmpty()) {
            System.out.println("No available books to borrow.");
            return;
        }

        System.out.print("Enter book id: ");
        int bookId = scanner.nextInt();

        if (!availableBooks.contains(bookId)) {
            System.out.println("Book not available.");
            return;
        }

        availableBooks.remove(Integer.valueOf(bookId));
        borrowedBooks.add(bookId);

        System.out.println("Book borrowed successfully.");
    }

    private void returnBook() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books to return.");
            return;
        }

        System.out.print("Enter book id: ");
        int bookId = scanner.nextInt();

        if (!borrowedBooks.remove(Integer.valueOf(bookId))) {
            System.out.println("This book is not borrowed.");
            return;
        }

        availableBooks.add(bookId);

        System.out.println("Book returned successfully.");
    }
}