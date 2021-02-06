package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<AirTicket> {
    @Override
    public int compare(AirTicket o1, AirTicket o2) {
        return o1.getTime() - o2.getTime();
        //TODO вопрос. А нельзя помимо 1 метода, добавить скажем еще плюсом айди и как это сделать?

    }
}
