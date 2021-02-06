package ru.netology.domain;

public class AirTicket implements Comparable<AirTicket>{
    public int id;
    public int price;
    public int time;
    public String from;
    public String to;

    @Override
    public String toString() {
        return "AirTicket{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public AirTicket(int id, int price, int time, String from, String to) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(AirTicket comparePrice) {
        return this.price - comparePrice.price;
    }


}
