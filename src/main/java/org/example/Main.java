package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> a1=new ArrayList<>();
    private static int action;

    public static void main(String[] args) {

        Album a=new Album("Album1" ,"Arman");
        a.addSong("xyz",4.2);
        a.addSong("pqr",2.2);
        a1.add(a);
        a=new Album("Album2" ,"Arijit");

        a.addSong("lkj",1.8);
        a.addSong("qwe",3.0);
        a.addSong("uio",5.7);
        a1.add(a);

        LinkedList<Song> playList1=new LinkedList<>();
        a1.get(0).addToPlayList("pqr",playList1);
        a1.get(0).addToPlayList("xyz",playList1);
        a1.get(1).addToPlayList("uio",playList1);
        a1.get(1).addToPlayList("lkj",playList1);

        play(playList1);

    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner sc=new Scanner(System.in);
        boolean quit= false;
        boolean forward= true;
        ListIterator<Song> listIterator= playList.listIterator();
        if(playList.size()==0)
        {
            System.out.println("This playlist have no songs");
        }
        else
        {
            System.out.println("Now playing" +listIterator.next().toString());
            PrintMenu();
        }

        while(!quit)
        {
            int action=sc.nextInt();
            sc.nextLine();


            switch (action)
            {
                case 0:
                    System.out.println("playlist complete");
                    quit=true;
                    break;

                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next()	;
                        }
                        forward= true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing" +listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("no songs available ");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous()	;
                        }
                        forward= false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing" +listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("first songs are available ");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        }

                        else
                        {
                            System.out.println("songs of the list are available ");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing" +listIterator.next().toString());
                            forward=true;
                        }
                        else
                        {
                            System.out.println("reached the end songs of the list ");
                        }
                    }
                    break;
                case 4:
                    PrintList(playList);
                    break;
                case 5:
                    PrintMenu();
                    break;

                case 6:
                    if(playList.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing" +listIterator.next().toString());

                        }
                        else
                        {
                            if(listIterator.hasPrevious())
                            {
                                System.out.println("Now playing" +listIterator.previous().toString());
                            }

                        }
                    }
            }
        }
    }

    private static void PrintMenu()
    {
        System.out.println("Available options\n press");
        System.out.println("0 -to quite\n"+
                "1 -to play next songs\n"+
                "2 -to play previous songs\n"+
                "3 -to replay the current songs\n"+
                "4 -to list of all the songs\n "+
                "5 -to print all available options\n"+
                "6 -to delete current songs");
    }

    private static void PrintList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator=playList.iterator();
        System.out.println("-------------------------");
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }
}
