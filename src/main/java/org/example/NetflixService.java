package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    static Scanner in = new Scanner(System.in);
    private HashMap<String,User> users;
    private ArrayList <TVShow> tvShowes_movies;

    public NetflixService() {
        users= new HashMap<>();
        tvShowes_movies=new ArrayList <>();
    }

    public void addTVShow(TVShow tvShow){
        tvShowes_movies.add(tvShow);
    }

    public boolean doesTitleExist(String title) {
        for (TVShow i : tvShowes_movies)
        {
            if(Objects.equals(i.getTitle(), title))
                return true;
        }
        return false;
    }

    public boolean doesUserExist(String username){
        return users.containsKey(username);
    }

    public void createAccount(String username, String password) {
        User user=new User(username,password);
        users.put(username,user);
    }

    public void login(String username){
        boolean flag =true;
        while (true && flag) {
            System.out.print("Enter password\n->");
            String pass = in.nextLine();
            if (users.get(username).userPassCheck(pass)) {
                while (true) {
                    System.out.println("----------Hi "+username+"---------");
                    System.out.print("1.Search on All\n2.Search on favorite\n3.add favorite\n4.watching\n5.view History\n6.logout\n->");
                    String order = in.nextLine();

                    //search all
                    if(order.equals("1")){
                        while (true){
                            System.out.println("1.Search by title\n2.Search by genre\n3.Search by Release Year\n4.Back");
                            order = in.nextLine();

                            //Search by title
                            if (order.equals("1")) {
                                System.out.print("Enter title that you want search\n->");
                                String title = in.nextLine();

                                for (TVShow i : searchByTitle(title))
                                {
                                    System.out.println(i.toString());
                                }
                            }

                            //Search by genre
                            else if (order.equals("2")) {
                                System.out.print("Enter genre that you want search\n->");
                                String genre = in.nextLine();
                                for (TVShow i : searchByGenre(genre))
                                {
                                    System.out.println(i.toString());
                                }
                            }

                            //Search by release year
                            else if (order.equals("3")) {
                                System.out.print("Enter release year that you want search\n->");
                                int year = in.nextInt();
                                in.nextLine();

                                for (TVShow i : searchByReleaseYear(year))
                                {
                                    System.out.println(i.toString());
                                }
                            }
                            else if (order.equals("4")) break;

                            else System.out.println("Wrong order!");
                        }
                    }

                    //search favorite
                    else if(order.equals("2")){

                        while (true){
                            System.out.println("1.View Favorites\n2.Search favorites by title\n3.Search favorites by genre\n4.Search favorites by Release Year\n5.Back");
                            order = in.nextLine();

                            //View Favorites
                            if (order.equals("1")) users.get(username).viewFavorites();

                                //Search favorites by title
                            else if (order.equals("2")) {
                                System.out.print("Enter title that you want search\n->");
                                String title = in.nextLine();
                                for (TVShow i : users.get(username).searchByTitle(title))
                                {
                                    System.out.println(i.toString());
                                }
                            }

                            //Search favorites by genre
                            else if (order.equals("3")) {
                                System.out.print("Enter genre that you want search\n->");
                                String genre = in.nextLine();
                                for (TVShow i : users.get(username).searchByGenre(genre))
                                {
                                    System.out.println(i.toString());
                                }
                            }

                            //Search favorites by release year
                            else if (order.equals("4")) {
                                System.out.print("Enter release year that you want search\n->");
                                int year = in.nextInt();
                                in.nextLine();

                                for (TVShow i : users.get(username).searchByReleaseYear(year))
                                {
                                    System.out.println(i.toString());
                                }
                            }
                            else if (order.equals("5")) break;

                            else System.out.println("Wrong order!");
                        }

                    }

                    //add favorite
                    else if(order.equals("3")){

                        System.out.print("Enter title of movie or TVshow\n->");
                        String title = in.nextLine();

                        if (doesTitleExist(title)){
                            for (TVShow i : tvShowes_movies)
                            {
                                if(Objects.equals(i.getTitle(), title)) {
                                    users.get(username).addToFavorites(i);
                                    break;
                                }
                            }
                            System.out.println("added successfully.");
                        }

                        else System.out.println("This title doesn't exist.");
                    }

                    //watch
                    else if(order.equals("4")){
                        System.out.print("Enter title of movie or TVshow that you want to watch\n->");
                        String title = in.nextLine();

                        if (doesTitleExist(title)){
                            for (TVShow i : tvShowes_movies)
                            {
                                if(Objects.equals(i.getTitle(), title)) {
                                    users.get(username).addToHistory(i);
                                    break;
                                }
                            }
                            System.out.println("you are watching "+ title+".\nHave a fun time");
                        }

                        else System.out.println("This title doesn't exist.");

                    }

                    else if(order.equals("5")) users.get(username).viewHistory();

                    else if (order.equals("6")){
                        flag =false;
                        break;
                    }
                    else System.out.println("Wrong order!");
                }
            }

            else System.out.println("Password was incorrect.");
        }
    }

    public ArrayList<TVShow> searchByTitle(String title) {

        ArrayList<TVShow> output = new ArrayList<>();
        for (TVShow show : tvShowes_movies)
        {
            if(Objects.equals(show.getTitle(), title))
                output.add(show);
        }
        return output;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {

        ArrayList<TVShow> output = new ArrayList<>();
        for (TVShow show : tvShowes_movies)
        {
            if(Objects.equals(show.getGenre(), genre))
                output.add(show);
        }
        return output;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {

        ArrayList<TVShow> output = new ArrayList<>();
        for (TVShow show : tvShowes_movies)
        {
            if(Objects.equals(show.getReleaseYear(), year))
                output.add(show);
        }
        return output;
    }
}
