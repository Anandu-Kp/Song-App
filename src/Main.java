import java.util.*;

public class Main
{

    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args)
    {

        Album album1 = new Album("Anirudh's Hits","Anirudh");
        album1.addSongtoAlbum("Vaathi Raid",3.50);
        album1.addSongtoAlbum("Porkanda Singam",4.30);
        album1.addSongtoAlbum("petta parag",3.25);

        Album album2 = new Album("Pradeep kumar Melodies","Padeep Kumar");
        album2.addSongtoAlbum("Nee kavithagalaa",4.40);
        album2.addSongtoAlbum("Aagayam Theepidithal",4.30);
        album2.addSongtoAlbum("Kannamma",4.20);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Vaathi Raid"));

        LinkedList<Song> MyPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("petta parag",MyPlayList);
        album2.addToPlaylistFromAlbum(3,MyPlayList);
        album1.addToPlaylistFromAlbum("Vaathi Raid",MyPlayList);
        album2.addToPlaylistFromAlbum(2,MyPlayList);

        play(MyPlayList);
    }

    public static void play(LinkedList<Song> playList)
    {
        ListIterator<Song> itr = playList.listIterator();
        Scanner sc = new Scanner(System.in);

        boolean isForward = false;

        if(playList.size()>0)
        {
            System.out.print("Currently playing: ");
            System.out.println(itr.next());
            isForward = true;
        }
        else
        {
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Enter your choice: ");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    if(isForward==false)
                    {
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());
                    }
                    else
                    {
                        System.out.println("You have reached the end of the playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward==true)
                    {
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious())
                    {
                        System.out.println(itr.previous());
                    }
                    else
                    {
                        System.out.println("You are at the first song");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward==true)
                    {
                        if(itr.hasPrevious())
                        {
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else
                    {
                        if(itr.hasNext())
                        {
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printSongs(LinkedList<Song> playList)
    {
        for(Song song: playList)
            System.out.println(song);
        return;
    }

    public static void printMenu()
    {
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");

        return;
    }
}