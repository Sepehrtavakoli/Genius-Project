package org.example;

import org.example.Models.Account;
import org.example.Models.Album;
import org.example.Models.Song;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.Console;
import java.io.IOException;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        File ArtistList = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Artists.txt");
        File UserList = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Users.txt");

        System.out.println("\n\t\tSEPI'S GENIUS\n");
        Console console = System.console();
        try {
            File myFile = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Top List.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String accountName = "---",pass = "---";
        String role = "---";

        while (true) {
            System.out.println("\nChoose Your Option :\n\ta.Create A New Account \n\t\tb.Log In \n\t\t\tc.Add Song (Only Artists) \n\t\t\td.Search For A Song \n\t\te.Search for An Album\n\tf.Exit");
            char option = scanner.next().charAt(0);
            switch (option) {
                case 'a':

                    boolean flag = false, doBreak = false;
                    while (!flag) {
                        System.out.printf("WEEELLLCCCOOOMMMEEE :))\nPlease Enter Your Account Name : ");
                        accountName = scanner.next();
                        if (accountName.equals("e")) {
                            doBreak = true;
                            break;
                        }

                        System.out.printf("Your Password : ");
                        pass = scanner.next();
                        if (pass.equals("e")) {
                            doBreak = true;
                            break;
                        }

                        boolean flagTaken = isUsernameTaken(accountName);
                        if (!flagTaken) {flag = true;}
                        else {
                            System.out.println("Your Account Name Is Already Taken Please Enter Again Or Press \"e\" For Exit : ");
                        }
                    }

                    boolean checkAge = false;
                    int age = 0;
                    while (!checkAge && !doBreak) {
                        System.out.printf("Age : ");
                        age = Integer.parseInt(scanner.next());
                        if (age < 18) System.out.println("Not a valid age");
                        else checkAge = true;
                    }

                    String email = "---";
                    if (!doBreak) {
                        while (true) {
                            System.out.printf("Your Email : ");
                            email = scanner.next();
                            boolean checkEmail = validateEmail(email);
                            if (checkEmail) {break;}
                            else {
                                System.out.println("Not A Valid Email Please Enter Again Or Press \"e\" For Exit : ");
                            }
                            if (email.equals("e")) {
                                doBreak = true;
                                break;
                            }
                        }
                    }

                    boolean checkR = false;
                    while (!checkR && !doBreak) {
                        System.out.println("Choose Your role : \na.User\tb.Artist");
                        role = scanner.next();

                        if (role.equals("a")) {
                            checkR = true;
                            role = "User";
                            break;
                        }
                        else if (role.equals("b")) {
                            checkR = true;
                            role = "Artist";
                            break;
                        }
                        else System.out.println("Not a Valid Role !");
                    }

                    if (role.equals("User"))
                    {
                        try {
                            FileWriter UserAccountWriter = new FileWriter("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Users.txt",true);
                            UserAccountWriter.write(accountName + " | " + pass + " | " + age + " | " + email + " | " + role + "\n");
                            System.out.println("Account Created !\nWelcome " + accountName);
                            UserAccountWriter.close();
                        }
                        catch (IOException e) {
                            System.out.println("Something went wrong");
                        }
                    }
                    else if (role.equals("Artist"))
                    {
                        try {
                            FileWriter ArtistAccountWriter = new FileWriter("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Artists.txt",true);
                            ArtistAccountWriter.write(accountName + " | " + pass + " | " + age + " | " + email + " | " + role + "\n");
                            System.out.println("Account Created !\nWelcome " + accountName);
                            ArtistAccountWriter.close();
                        }
                        catch (IOException e) {
                            System.out.println("Something went wrong");
                        }
                    }

                    Account account = new Account(accountName, pass, age, email, role);

                    break;

                case 'b':
                    System.out.printf("Please Enter Your Account Name : ");
                    String logaccountName = scanner.next();

                    System.out.printf("Your Password : ");
                    String logpass = scanner.next();

                    System.out.printf("Please Enter Role : ");
                    String logrole = scanner.next();

                    boolean checkUser = false;
                    while (!checkUser) {
                        if (logrole.equals("User")) {
                            if (searchUser(logaccountName, logpass)) {
                                checkUser = true;
                                System.out.printf("Welcome To Your Account" + logaccountName);
                                role = "User";
                                accountName = logaccountName;
                            }
                            else {
                                System.out.println("Or Account does not exist");
                                break;
                            }

                        } else if (logrole.equals("Artist")) {
                            if (searchArtist(logaccountName, logpass)) {
                                checkUser = true;
                                System.out.printf("Welcome To Your Account " + logaccountName);
                                role = "Artist";
                                accountName = logaccountName;
                            }
                            else {
                                System.out.println("Or Account does not exist");
                                break;
                            }

                        } else
                        {
                            System.out.println("Not a Valid Role !");
                            break;
                        }
                    }
                    break;


                case 'c':
                    if (role.equals("Artist"));
                    {
                        System.out.println("Press e For Exit\nPlease Enter Song Name : ");
                        String songName = scanner.next();
                        if (songName.equals("e")) {
                            break;
                        }
                        System.out.println("Please Enter Album Name : ");
                        String albumName = scanner.next();
                        if (albumName.equals("e")) {
                            break;
                        }
                        System.out.println("Please Enter Lyrics : ");
                        String lyrics = scanner.next();
                        if (lyrics.equals("e")) {
                            break;
                        }
                        try {
                            FileWriter addSong = new FileWriter("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Songs.txt",true);
                            addSong.write(songName + "\t" + albumName + "\t" + lyrics + "\n");
                            addSong.close();
                        }catch (IOException e) {
                            System.out.println("Something went wrong");
                        }
                    }
                    break;
                case 'd':
                    int Likes = 0;
                    System.out.printf("PLease Enter Song Name : ");
                    String songName = scanner.next();
                    Likes = searchSong(songName);
                    Song song = new Song(songName);
                    System.out.println("Press C For Comment ,L For Like ,E for Exit ");
                    String op = scanner.next();
                    if (op.equals("c")) {
                        if (accountName.equals("---")) System.out.println("You Are Not In Your Account");

                        else
                        {
                            System.out.println("Enter Comment : ");
                            String comment = scanner.next();
                            try {
                                FileWriter commentWrite = new FileWriter("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Songs.txt",true);
                                commentWrite.write(accountName + "Says : " + comment);
                                commentWrite.close();
                            } catch (IOException e) {
                                System.out.println("Something went wrong");
                            }
                        }
                    }
                    else if (op.equals("L")) {
                        Likes ++;
                        try {
                            FileWriter commentWrite = new FileWriter("Songs.txt",true);
                            commentWrite.write("Likes: " + Likes + "\n");
                            commentWrite.close();
                        } catch (IOException e) {
                            System.out.println("Something went wrong");
                        }
                    }
                    break;

                case 'e':
                    System.out.printf("PLease Enter Album Name : ");
                    String AlbumName = scanner.next();
                    searchAlbum(AlbumName);
                    Album album = new Album (AlbumName);
                    break;

                case 'f':
                    return;

                default:
                    System.out.println("Invalid Option Choose Again :");
                    break;
            }
        }
    }


    public static boolean isUsernameTaken(String accountName) {
                    try {
                        File file = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Users.txt");
                        Scanner reader = new Scanner(file);
                        while (reader.hasNextLine())
                        {
                            String line = reader.nextLine();
                            String[] parts = line.split(",");
                            if (parts.length > 0 && parts[0].equals(accountName))
                            {
                                reader.close();
                                return true;
                            }
                        }
                        reader.close();
                    } catch (FileNotFoundException e)
                    {
                        System.out.println("File not found");
                    }
                    return false;
                }

    public static void searchAlbum(String albumTitle) {
        boolean found = false;

        File albumfile = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Albums.txt");

        try (Scanner reader = new Scanner(albumfile)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split("\\|"); // ← با | جدا می‌کنیم

                if (parts.length >= 2 && parts[0].trim().equalsIgnoreCase(albumTitle.trim())) {
                    System.out.println("Album: " + parts[0].trim());
                    System.out.println("Artist: " + parts[1].trim());
                    if (parts.length >= 3) {
                        System.out.println("Release year: " + parts[2].trim());
                    }
                    if (parts.length >= 4) {
                        System.out.println("Songs : " + parts[3].trim());
                    }
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        if (!found) {
            System.out.println("Album not found!");
        }
    }

    public static int searchSong(String songTitle) {
        boolean found = false;

        File songsFile = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Songs.txt");

        try (Scanner reader = new Scanner(songsFile)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split("\\|");
                String[] likes = line.split("Likes :");
                if (parts.length >= 1 && parts[0].trim().equalsIgnoreCase(songTitle)) {
                    System.out.println(parts[0] + "By : " + parts[1] + "\n"); // Lyrics
                    found = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
        }

        if (!found) {
            System.out.println("Song not found !");
        }
        return 2;
    }

    public static boolean searchArtist(String artistName,String pass) {
        boolean found = false;

        File userList = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Artists.txt");

        try (Scanner reader = new Scanner(userList)) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split("\\|");

                if (parts.length >= 2 && parts[0].trim().equalsIgnoreCase(artistName.trim()) && parts[1].trim().equals(pass.trim())) {
                    System.out.println("✅ Artist found: ");
                    found = true;
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("🚫 File not found!");
        }

        if (!found) {
            System.out.println("❌ Username or password incorrect.");
        }

        return false;
    }

    public static boolean searchUser(String userName, String pass) {
        boolean found = false;

        File userList = new File("C:\\Users\\MSI Modern\\Desktop\\pro\\Daneshga\\Term 2\\AP\\Gproject\\src\\main\\java\\org\\example\\Models\\Data base\\Users.txt");

        try (Scanner reader = new Scanner(userList)) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split("\\|");

                if (parts.length >= 2 && parts[0].trim().equalsIgnoreCase(userName.trim()) && parts[1].trim().equals(pass.trim())) {
                    System.out.println("✅ User found: " + parts[0].trim());
                    found = true;
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("🚫 File not found!");
        }

        if (!found) {
            System.out.println("❌ Username or password incorrect.");
        }

        return false;
    }

    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


