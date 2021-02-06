package ru.netology.repository;

import ru.netology.domain.AirTicket;


public class AitTicketRepository {

    private AirTicket[] items = new AirTicket[0];

    public void save(AirTicket item) {
        int length = items.length + 1;
        AirTicket[] tmp = new AirTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AirTicket[] getAll() {
        return items;
    }

    public AirTicket findById(int id) {
        for (AirTicket item : items) {
            if (item.getId() == id) ;
            {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id){
        int length = items.length -1;
        AirTicket[] tmp = new AirTicket[length];
        int index = 0;
        for (AirTicket item : items){
            if (item.getId()!= id){
                tmp[index] = item;
                index --;
            }
        }
        items = tmp;
    }

}
