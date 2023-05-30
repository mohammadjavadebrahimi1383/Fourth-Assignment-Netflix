package org.example;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        Scanner in = new Scanner(System.in);
        NetflixService netflix =new NetflixService();

        while (true){
            System.out.print("1.sign in\n2.sign up\n3.admin\n4.exit\n->");
            String order = in.nextLine();

            //sign in
            if (order.equals("1")){
                System.out.print("Enter username\n->");
                String username = in.nextLine();

                if(netflix.doesUserExist(username)){
                    netflix.login(username);
                }
                else System.out.println("this username doesn't exist.");

            }
            //sign up
            else if (order.equals("2")){
                while (true){
                    System.out.print("Enter username\n->");
                    String username = in.nextLine();
                    if(!netflix.doesUserExist(username)){
                        System.out.print("Enter password\n->");
                        String pass = in.nextLine();
                        netflix.createAccount(username, pass);
                        System.out.println("Account create successfully.");
                        break;
                    }

                    else System.out.println("this username already have gotten, enter another username.");
                }

            }

            //admin
            else if(order.equals("3")){

                System.out.print("Enter username\n->");
                String username = in.nextLine();
                if(username.equals("admin")){
                    boolean flag =true;
                    while(flag) {
                        System.out.print("Enter password\n->");
                        String pass = in.nextLine();
                        if (pass.equals("admin")){
                            while (true){
                                System.out.println("----------Hi admin----------");
                                System.out.print("1.add TV show\n2.add movie\n3.logout\n->");
                                order = in.nextLine();

                                //add TV show
                                if (order.equals("1")){

                                    System.out.print("Enter title of TV show\n->");
                                    String title = in.nextLine();

                                    if (!netflix.doesTitleExist(title)){
                                        System.out.print("Enter genre of TV show\n->");
                                        String genre = in.nextLine();

                                        System.out.print("Enter duration of TV show\n->");
                                        String duration = in.nextLine();

                                        System.out.print("Enter rating of TV show\n->");
                                        String rating = in.nextLine();

                                        System.out.print("Enter releaseYear of TV show\n->");
                                        int releaseYear = in.nextInt();

                                        System.out.print("How many casts played at TV show?\n->");
                                        int castsNum = in.nextInt();
                                        in.nextLine();
                                        ArrayList <String> casts = new ArrayList<>();
                                        if(castsNum >0 ) {

                                            System.out.println("Enter casts");
                                            for (int i = 0; i < castsNum; i++) {
                                                System.out.print("->");
                                                casts.add(in.nextLine());
                                            }
                                        }
                                        TVShow tv = new TVShow(title,genre, duration, rating, releaseYear, casts);
                                        netflix.addTVShow(tv);
                                        System.out.println("TV show added successfully.");
                                    }

                                    else System.out.println("This title already hve added.");
                                }

                                // add movie
                                else if (order.equals("2")){
                                    System.out.print("Enter title of movie\n->");
                                    String title = in.nextLine();

                                    if (!netflix.doesTitleExist(title)){
                                        System.out.print("Enter genre of movie\n->");
                                        String genre = in.nextLine();

                                        System.out.print("Enter duration of movie\n->");
                                        String duration = in.nextLine();

                                        System.out.print("Enter rating of movie\n->");
                                        String rating = in.nextLine();

                                        System.out.print("Enter releaseYear of movie\n->");
                                        int releaseYear = in.nextInt();

                                        System.out.print("Enter lenght of movie\n->");
                                        float lenght = in.nextFloat();

                                        System.out.print("How many casts played at movie?\n->");
                                        int castsNum = in.nextInt();
                                        in.nextLine();
                                        ArrayList <String> casts = new ArrayList<>();
                                        if(castsNum >0 ) {

                                            System.out.println("Enter casts");
                                            for (int i = 0; i < castsNum; i++) {
                                                System.out.print("->");
                                                casts.add(in.nextLine());
                                            }
                                        }
                                        Movie tv = new Movie(title,genre, duration, rating, releaseYear, casts, lenght);
                                        netflix.addTVShow(tv);
                                        System.out.println("TV show added successfully.");
                                    }

                                    else System.out.println("This title already hve added.");
                                }

                                //logout
                                else if (order.equals("3")){
                                    flag =false;
                                    break;
                                }

                                else System.out.println("Wrong order.");
                            }
                        }
                        else System.out.print("Wrong password. enter again\n->");
                    }
                }
                else System.out.println("this username doesn't exist.");
            }

            else if(order.equals("4")) System.exit(0);

            else System.out.println("Wrong order.");

        }

    }
}