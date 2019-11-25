package canard.esport.recrutement.model;

public class Player {
    public String pseudo;
    public int rank;
    public int champs;
    public int winrate;
    public int score;

    public Player(final String pseudo, final int rank, final int champs, final int winrate, final int score) {
        this.pseudo = pseudo;
        this.rank = rank;
        this.champs = champs;
        this.winrate = winrate;
        this.score = score;
    }

    public Player(final String pseudo, final int rank, final int champs, final int winrate) {
        this.pseudo = pseudo;
        this.rank = rank;
        this.champs = champs;
        this.winrate = winrate;
    }

    public Player(final String pseudo, final int rank) {
        this.pseudo = pseudo;
        this.rank = rank;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(final String pseudo) {
        this.pseudo = pseudo;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public int getChamps() {
        return champs;
    }

    public void setChamps(final int champs) {
        this.champs = champs;
    }

    public int getWinrate() {
        return winrate;
    }

    public void setWinrate(final int winrate) {
        this.winrate = winrate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" + "pseudo='" + pseudo + '\'' + ", rank=" + rank + ", champs=" + champs + ", winrate=" + winrate + ", score=" + score + '}';
    }
}
