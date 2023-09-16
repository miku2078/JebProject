import java.util.*;

class Landlords {
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    final static String[] card_type = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" , "2"};
    public void shuffle() {
        for (int j = 0; j < card_type.length; j++) {
            cards.add(new Card('♢', card_type[j], j));
            cards.add(new Card('♧', card_type[j], j));
            cards.add(new Card('♤', card_type[j], j));
            cards.add(new Card('♡', card_type[j], j));
        }
        cards.add(new Card('大',"王", 13));
        cards.add(new Card('小',"王", 12));
        Collections.shuffle(cards);
    }

    public void Licensing() {
        if(players.size() != 3) {
            System.out.println("人员不够捏!");
            return;
        }
        Random random = new Random();
        for(int i = 0 ; i < 17; i++) {
            for(int j = 0; j < 3; j++) {
                int size = cards.size();
                int index = random.nextInt(size);
                players.get(j).getCards().add(cards.get(index));
                cards.remove(index);
            }
        }
    }

    public void show() {
        for (Player player : players) {
            System.out.println(player.toString());
        }

        System.out.printf("底牌 : %s", cards.toString());
    }

    public void addPlayer(Player player) {
        if(players.size() == 3){
            System.out.println("没有位置捏!");
            return;
        }
        players.add(player);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

class Player {
    TreeSet<Card> cards = new TreeSet<>();
    private String name;
    public TreeSet<Card> getCards() {
        return cards;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + cards.toString();
    }
}
class Card implements Comparable<Card> {
    private int weight = 0;
    private char first;
    private String second;
    public Card(char first, String second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%c%s", first, second);
    }

    @Override
    public int compareTo(Card card) {
        if(weight != card.weight) {
            return weight - card.weight;
        }
        return first - card.first;
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

public class Main {

    public static void main(String[] args) {
        Landlords landlords = new Landlords();
        landlords.shuffle();
        landlords.addPlayer(new Player("张三"));
        landlords.addPlayer(new Player("李四"));
        landlords.addPlayer(new Player("王二"));
        landlords.Licensing();
        landlords.show();

    }
}
