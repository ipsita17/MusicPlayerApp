package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artistName;
    private ArrayList<Song> songs;

    public Album(String name,String artistName)
    {
        this.name=name;
        this.artistName= artistName;
        this.songs=new ArrayList<Song>();
    }


    public Song FindSong(String title)
    {
        for(Song checkedSong: songs)    // it is used for checking if the song is exist or not
        {
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;  //because the return type is not boolean so it returns null
    }

    public boolean addSong(String title, double duration)
    {
        if(FindSong(title)==null)
        {
            songs.add(new Song(title,duration));
            System.out.println(title+ "Songs successfully added to the list");
            return true;
        }
        else
        {
            System.out.println("Songs with name" +title+"already exists in the list");
            return false;
        }
    }


    public boolean addToPlayList(int number, LinkedList<Song> PlayList)
    {
        int i=number-1;
        if(i>0 && i<=this.songs.size())
        {
            PlayList.add(this.songs.get(i));
            return true;
        }
        System.out.println("This album does not have song with number" +number);
        return false;

    }
    public boolean addToPlayList(String title,LinkedList<Song> PlayList)
    {
        for(Song checkedSong :this.songs)
        {
            if(checkedSong.getTitle().equals(title))
            {
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+ "There is no such songs in the playlist");
        return false;
    }
}